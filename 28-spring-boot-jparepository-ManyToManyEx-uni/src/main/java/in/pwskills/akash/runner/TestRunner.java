package in.pwskills.akash.runner;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.ICourseRepository;
import in.pwskills.akash.dao.IStudentRepository;
import in.pwskills.akash.entity.Course;
import in.pwskills.akash.entity.Student;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IStudentRepository srepo;
	
	@Autowired
	private ICourseRepository crepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Course c1 = new Course(50,"SpringBoot",500.0);
		Course c2 = new Course(51,"Angular",600.0);
		
		crepo.save(c1);
		crepo.save(c2);
		
		Student s1 = new Student(10, "AJAY" , "aj@gm.com" , Arrays.asList(c1,c2));
		Student s2 = new Student(11, "SAM" , "sa@gm.com" , Arrays.asList(c1,c2));
		
		srepo.save(s1);
		srepo.save(s2);
		
	
	}

}
