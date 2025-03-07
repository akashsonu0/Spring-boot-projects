package in.pwskills.akash.service.dao;

import java.util.List;

import in.pwskills.akash.beans.EmployeeBO;

public interface IEmployeeDao {
	public List<EmployeeBO>fetchEmpByDesg(String cond) throws Exception;

}
