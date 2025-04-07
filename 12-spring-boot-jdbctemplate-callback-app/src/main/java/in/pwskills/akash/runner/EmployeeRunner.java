package in.pwskills.akash.runner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import in.pwskills.akash.beans.EmployeeDTO;
import in.pwskills.akash.service.IEmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;
 
	@Override
	public void run(String... args) throws Exception {
		
		EmployeeDTO employee = service.fetchEmployeeByNo(6);
		System.out.println(employee);
		
		System.out.println("****************************");
		
		service.fetchEmployeeByDesg("bowler", "captain").forEach(System.out::println);
		
		System.out.println("****************************");
		service.fetchAllEmployees().forEach(System.out::println);
			
	}

}
