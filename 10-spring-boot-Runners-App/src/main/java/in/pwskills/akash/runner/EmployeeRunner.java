package in.pwskills.akash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.akash.beans.Employee;
import in.pwskills.akash.beans.Student;

@Component
@Order(5)
public class EmployeeRunner implements CommandLineRunner {
	
	static {
		System.out.println("EmployeeRunner.class file is loading...");
	}
	
	public EmployeeRunner() {
		System.out.println("EmployeeRunner Object is created...");
	}
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private Student student;
	
	//Called by the container automatically 
	//After creation of all object of singleton scope
	@Override
	public void run(String... args) throws Exception {
		System.out.println("EmployeeRunner.run()");
		System.out.println(employee);
		System.out.println(student);
		
		System.out.println("Arguments passed are ::  ");
		for(String cmd: args) {
			System.out.println(cmd);
		}
		
		
		

	}

}
