package in.pwskills.akash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.pwskills.akash.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//SQL: 1. fetch one column data
	@Query("FROM Employee Where empSal>=:esal")
	public List<Employee> fetchAllEmployees(Double esal);
	
	//SQL: 2. select all columns
	@Query("SELECT empName FROM Employee")
	public List<String> fetchNameOfEmployees();
	
	@Query("SELECT empId,empName FROM Employee")
	public List<Object[]> fetchIdAndNameofEmployee();
	
	@Query("SELECT empId,empDept FROM Employee WHERE empDept =:dept")
	public List<Object[]> fetchBasedonDept(String dept);
	
	//@Query("SELECT empId,empDept FROM Employee WHERE empDept =:dep")
	//public List<Object[]> fetchBasedonDept(@Param("dep") String dept);
	
}
