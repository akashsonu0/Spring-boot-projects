package in.pwskills.akash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import in.pwskills.akash.beans.Employee;
import in.pwskills.akash.beans.Student;
@Component
@Order(10)
public class StudentRunner implements CommandLineRunner,Ordered{
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private Student student;
	
	static {
		System.out.println("StudentRunner.class file is loading...");
	}
	
	public StudentRunner() {
		System.out.println("StudentRunner Object is created...");
	}
	
	
	//Called by the container automatically 
	//After creation of all object of singleton scope
	@Override
	public void run(String... args) throws Exception {
		System.out.println("StudnetRunner.run()");
		System.out.println(employee);
		System.out.println(student);

		
		System.out.println("Arguments passed are ::  ");
		for(String cmd: args) {
			System.out.println(cmd);
		}
		
	}

	@Override
	public int getOrder() {
		System.out.println("StudentRunner.getOrder()");
		return 15;
	}

}
