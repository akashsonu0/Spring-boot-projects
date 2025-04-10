package in.pwskills.akash.dao;

import java.util.List;

import in.pwskills.akash.beans.EmployeeBO;
import in.pwskills.akash.beans.EmployeeDTO;

public interface IEmployeeDao {
	public String getEmpNameByEno(Integer empNo);
	public List<EmployeeBO> getEmployeeDetailsBasedOnDesg(String desg1,String desg2);
	public int saveEmployee(EmployeeBO bo);

}
