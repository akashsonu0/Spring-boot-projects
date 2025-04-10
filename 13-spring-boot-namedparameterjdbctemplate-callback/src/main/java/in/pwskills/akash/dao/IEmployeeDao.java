package in.pwskills.akash.dao;

import java.util.List;


import in.pwskills.akash.beans.EmployeeBO;

public interface IEmployeeDao {
	public String getEmpNameByEno(Integer empNo);
	public List<EmployeeBO> getEmployeeDetailsBasedOnDesg(String desg1,String desg2);
	public int saveEmployee(EmployeeBO bo);

}
