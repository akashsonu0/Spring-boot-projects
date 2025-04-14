package in.pwskills.akash.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IStudentDao;
import in.pwskills.akash.entity.Student;
@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getClass().getName());
		
		dao.save(new Student(10,"messi","Argentina",38));
		
		Student s1 = new Student(7,"dhoni","CSK",42);
		Student s2 = new Student(18,"kohli","RCB",37);
		Student s3 = new Student(45,"rohith","MI",38);
		
		dao.saveAll(List.of(s1,s2,s3)).forEach(System.out::println);

	}

}
