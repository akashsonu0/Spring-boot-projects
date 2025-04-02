package in.pwskills.akash.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import in.pwskills.akash.beans.Employee;
import in.pwskills.akash.beans.Student;

@Component
@Order(5)
public class StudentRunner implements ApplicationRunner, Ordered {

    static {
        System.out.println("StudentRunner.class file is loading...");
    }

    public StudentRunner() {
        System.out.println("StudentRunner Object is created...");
    }

    @Autowired
    private Employee employee;

    @Autowired
    private Student student;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("\nStudentRunner.run()");
        System.out.println(employee);
        System.out.println(student);

        System.out.println("Application- Arguments passed are :: ");
        System.out.println("Optional Args are :: " + args.getOptionNames());
        System.out.println("NonOptional Args are :: " + args.getNonOptionArgs());
    }

    @Override
    public int getOrder() {
        System.out.println("StudentRunner.getOrder()");
        return 5;
    }
}