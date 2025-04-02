package in.pwskills.akash.runner;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import in.pwskills.akash.beans.Employee;
import in.pwskills.akash.beans.Student;

@Component
@Order(10)
public class EmployeeRunner implements ApplicationRunner {

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

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("\nEmployeeRunner.run()");
        System.out.println(employee);
        System.out.println(student);

        System.out.println("Application- Arguments passed are :: ");
        System.out.println("Optional Args are :: " + args.getOptionNames());
        System.out.println("NonOptional Args are :: " + args.getNonOptionArgs());
        System.out.println("Source Arguments are :: " + Arrays.toString(args.getSourceArgs()));
    }
}
