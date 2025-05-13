package in.pwskills.akash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.service.IEmployeeService;

@Component
public class TestRunner implements CommandLineRunner {
    
   @Autowired
   private IEmployeeService service;
    
    @Override
    public void run(String... args) throws Exception {
    	
        service.searchEmpByDesgs("QA", "DEV").forEach(System.out::println);
		
		
	}

}
