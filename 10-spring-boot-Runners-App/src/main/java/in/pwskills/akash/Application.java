package in.pwskills.akash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	
    	System.out.println("*******conatiner started*******");
    	
    	//Perform some startup activities + create an object for all beans(singleton) + DI(singleton)
    	//calls run() of such classes which implements XXXXRunner only once after the creation of container
    	SpringApplication.run(Application.class, args);
    	
    	System.out.println("*******conatiner stopped*******");
       
     }
}