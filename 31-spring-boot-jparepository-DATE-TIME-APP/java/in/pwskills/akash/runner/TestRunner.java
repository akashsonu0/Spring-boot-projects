package in.pwskills.akash.runner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.ICustomerRepository;
import in.pwskills.akash.entity.Customer;


@Component
public class TestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerRepository repo;
		
	@Override
	public void run(String... args) throws Exception {
		
		Customer cust = new Customer(10, "Akash Sonu" , "Bihar" ,
				LocalDateTime.of(2005, 1 , 3 , 19 , 45 , 3),
				LocalTime.now(),
				LocalDate.now());
		
				repo.save(cust);
		
				System.out.println("****Customer Object is saved****");
				
				repo.findAll().forEach(System.out::println);
				
				
	}

}
