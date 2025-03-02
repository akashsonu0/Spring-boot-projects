package in.pwskills.akash;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.pwskills.akash.beans.BillGenerator;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // Start the container
    	System.out.println("*************Conatiner Started*************");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        
        BillGenerator generator =  context.getBean( BillGenerator.class);
        System.out.println(generator);
       
        // Close the container
        ((ConfigurableApplicationContext) context).close();
        System.out.println("*************Conatiner Stopped*************");
    }
}