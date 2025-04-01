package in.pwskills.akash.service;

import java.util.List;

import in.pwskills.akash.beans.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO>fetchEmpByDesg(String desg[]) throws Exception;
}
