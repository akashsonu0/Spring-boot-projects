package in.pwskills.akash.runner;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IMarriageRepository;
import in.pwskills.akash.entity.MarriageSeeker;

@Component
public class TestRunner implements CommandLineRunner {
    
    @Autowired
    private IMarriageRepository repo;
    
    @Override
    public void run(String... args) throws Exception {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of the user :: "); 
        String name = scanner.next();
        
        System.out.print("Enter the address of the user :: "); 
        String address = scanner.next();
        
        System.out.print("Is Person Indian? :: "); 
        boolean indian = scanner.nextBoolean();
        
        System.out.print("Enter the path of Person photo :: "); 
        String photoLoc = scanner.next();
        
        System.out.print("Enter the path of Person biodata :: "); 
        String bioDataLoc = scanner.next();
        
        // working with binary image data
        InputStream is = new FileInputStream(new File(photoLoc)); 
        byte[] img = new byte[is.available()]; 
        is.read(img);
        
        // working with text file data 
        File file = new File(bioDataLoc); 
        Reader reader = new FileReader(file); 
        char[] bio = new char[(int) file.length()]; 
        reader.read(bio);
        
        MarriageSeeker obj = new MarriageSeeker(name, address, LocalDateTime.of(1991, 1, 3, 19, 45), img, bio, indian); 
        repo.save(obj);
        System.out.println("Object saved to database....");
        
        scanner.close(); 
        reader.close(); 
        is.close();
    

		//code for retrieval
		Optional<MarriageSeeker> optional = repo.findById(1L);
		if (optional.isPresent()) {
			MarriageSeeker obj1 = optional.get();
			System.out.println(obj1);
			
			System.out.println("Image data stored in ...");
			@SuppressWarnings("resource")
			OutputStream os = new FileOutputStream(new File("retrieved_akash.jpg"));
			os.write(obj.getPhoto());
			os.flush();

			System.out.println("BioData stored in ...");
			@SuppressWarnings("resource")
			Writer writer = new FileWriter(new File("retrieved_resume.txt"));	
			writer.write(obj.getBiodata());
			writer.flush();
			System.out.println("Lob's are retrieved...");

			} else {
			   System.out.println("Record not available...");
			}
		
		
	}

}
