package in.pwskills.akash;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.pwskills.akash.beans.Employee;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // Start the container
    	System.out.println("*************Conatiner Started*************");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        
        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);
       
       DataSource source = context.getBean(DataSource.class);
       System.out.println("DataSource is :: "+source.getClass().getName());
        // Close the container
        ((ConfigurableApplicationContext) context).close();
        System.out.println("*************Conatiner Stopped*************");
    }
}