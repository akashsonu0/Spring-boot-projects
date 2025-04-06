package in.pwskills.akash;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.pwskills.akash.config.AppConfig;
import in.pwskills.akash.service.IEmployeeMgmtService;

public class MainApp {

    public static void main(String[] args) {

        // Start Spring container
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //asking the container to give the bean
        IEmployeeMgmtService service = applicationContext.getBean(IEmployeeMgmtService.class);
        
        
        System.out.println("No of employees     is ::" + service.fetchEmpCount());      
        System.out.println("Salary of employees is ::" + service.fetchEmployeeSalaryByEno(3));      
        service.fetchEmployeeByEno(3).entrySet()
        	.forEach(row -> { 
        				System.out.println(row.getKey() + " ====== " + row.getValue());
        	}
        );
        
        System.out.println("______________________");
        
        service.fetchEmployeeByDesg("batsman","keeper").forEach(map -> {
        	map.entrySet().forEach(row -> {
        		System.out.println(row.getKey() +  " " + row.getValue());
        	});
        	System.out.println("\n");
        }); 
         
        int count = service.registerEmployee("rohith", "captain", 35000.0f, 12, 30);
        System.out.println("No of records inserted is :: "+count);
             
        System.out.println("Before hike salary is :: "+service.fetchEmployeeSalaryByEno(3));
        System.out.println(service.hikeEmployeeEsalary(3,45000.0f));
        System.out.println("After hike salary is :: "+service.fetchEmployeeSalaryByEno(3));
        
        int noOfRecords = service.fireEmployeeBySalaryRange(35000.0f, 45000.0f);
        System.out.println("No of records deleted is :: "+noOfRecords);
        
        // Close Spring container
        applicationContext.close();
    }
}