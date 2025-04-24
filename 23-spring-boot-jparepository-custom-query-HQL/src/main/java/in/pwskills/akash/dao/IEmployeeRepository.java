package in.pwskills.akash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.pwskills.akash.entity.Employee;
import jakarta.transaction.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//======================select operation======================
	//SQL: 1. fetch one column data
	@Query("FROM Employee Where empSal>=:esal")
	public List<Employee> fetchAllEmployees(Double esal);
	
	@Query("FROM Employee")
	public List<Employee> fetchAllEmployees();
	
	//SQL: 2. select all columns
	@Query("SELECT empName FROM Employee")
	public List<String> fetchNameOfEmployees();
	
	@Query("SELECT empId,empName FROM Employee")
	public List<Object[]> fetchIdAndNameofEmployee();
	
	@Query("SELECT empId,empDept FROM Employee WHERE empDept =:dept")
	public List<Object[]> fetchBasedonDept(String dept);
	
	//@Query("SELECT empId,empDept FROM Employee WHERE empDept =:dep")
	//public List<Object[]> fetchBasedonDept(@Param("dep") String dept)
	
	//======================non-select operation======================
	@Query("DELETE FROM Employee WHERE empId=:id")
	@Modifying
	@Transactional
	public int deleteEmployeeById(Integer id);
	
	@Query("UPDATE Employee SET empSal=empSal+:bonus where empId=:id")
	@Modifying
	@Transactional
	public int updateEmployeeSalaryById(Integer id,Double bonus);
	
	
}
