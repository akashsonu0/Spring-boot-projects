package in.pwskills.akash.dao;

import java.sql.SQLException;

import in.pwskills.akash.beans.Naukri;

public interface INaukriDao {
	public void saveObject(Naukri naukri);
	public Naukri readObject() throws SQLException;
}
