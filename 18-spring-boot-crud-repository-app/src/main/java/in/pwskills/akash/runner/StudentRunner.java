package in.pwskills.akash.runner;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IStudentDao;
import in.pwskills.akash.entity.Student;
import in.pwskills.akash.exception.StudentRecordNotFoundException;

@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getClass().getName());
		
		//save operation
		/*
		dao.save(new Student(10,"messi","Argentina",38));
		Student s1 = new Student(7,"dhoni","CSK",42);
		Student s2 = new Student(18,"kohli","RCB",37);
		Student s3 = new Student(45,"rohith","MI",38);
		dao.saveAll(List.of(s1,s2,s3)).forEach(System.out::println);
		*/
		
		Optional<Student> optional = dao.findById(7);
		if(optional.isPresent()) {
			Student student = optional.get();
			System.out.println(student);
		}else {
			System.out.println("Record not avialable for the given id");
		}
		
		//select * from student where sid = ?
		Student student = dao.findById(18).orElseThrow(()->new StudentRecordNotFoundException("Record not available"));
		System.out.println(student);
		
		//select * from student
		dao.findAll().forEach(System.out::println);
		
		//select * from student where sid IN (?,?,?)
		dao.findAllById(List.of(7, 18, 10)).forEach(System.out::println);
		
		System.out.println("*********************************");
		
		if(dao.existsById(7)) {
			System.out.println(dao.findById(7).get());
		}
		
		//select count(*) from student;
		long noOfRecords = dao.count();
		System.out.println("No of records is :: "+noOfRecords);
		
		
		
		
		
	}

}
