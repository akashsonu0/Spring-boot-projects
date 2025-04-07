package in.pwskills.akash.dao;

import java.util.List;

import in.pwskills.akash.beans.EmployeeBO;

public interface IEmployeeDao {
	public EmployeeBO getEmployeeByNo(Integer empNo);
	public List<EmployeeBO> getEmployeeByDesg(String desg1, String desg2);
	public List<EmployeeBO> getAllEmployees();
}
