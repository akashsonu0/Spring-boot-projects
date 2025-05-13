package in.pwskills.akash.service;

import java.util.List;

import in.pwskills.akash.entity.Employee;

public interface IEmployeeService {
	public List<Employee> searchEmpByDesgs(String desg1,String desg2);

}
