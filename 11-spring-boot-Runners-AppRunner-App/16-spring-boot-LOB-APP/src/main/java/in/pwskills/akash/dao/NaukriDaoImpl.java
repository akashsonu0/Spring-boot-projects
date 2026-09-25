package in.pwskills.akash.dao;
import in.pwskills.akash.beans.Naukri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("dao")
public class NaukriDaoImpl implements INaukriDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveObject(Naukri naukri) {
        String sql = "INSERT INTO naukri (address, image, name, resume) VALUES (?, ?, ?, ?)";

        try (
            FileInputStream imageStream = new FileInputStream(naukri.getImage());
            FileReader resumeReader = new FileReader(naukri.getResume());
        ) {
            int rowCount = jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, naukri.getAddress());
                try {
					ps.setBinaryStream(2, imageStream, imageStream.available());
				} catch (IOException e) {
					e.printStackTrace();
				} // BLOB
                ps.setString(3, naukri.getName());
                ps.setCharacterStream(4, resumeReader); // CLOB
                return ps;
            });

            if (rowCount == 0) {
                System.out.println("Insertion failed");
            } else {
                System.out.println("Record inserted successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Naukri readObject() throws SQLException {
        return jdbcTemplate.query("SELECT name, address, image, resume FROM Naukri WHERE id = 1",
            (ResultSet rs) -> {
                Naukri naukri = null;
                if (rs.next()) {
                    naukri = new Naukri();
                    naukri.setName(rs.getString("name"));
                    naukri.setAddress(rs.getString("address"));

                    byte[] imageData = rs.getBytes("image");
                    byte[] resumeData = rs.getBytes("resume");

                    try {
                        File imageFile = new File("image.jpg");
                        FileOutputStream imgOut = new FileOutputStream(imageFile);
                        imgOut.write(imageData);
                        imgOut.close();
                        naukri.setImage(imageFile);

                        File resumeFile = new File("resume.txt");
                        FileOutputStream resOut = new FileOutputStream(resumeFile);
                        resOut.write(resumeData);
                        resOut.close();
                        naukri.setResume(resumeFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return naukri;
            }
        );
    }
}