package in.pwskills.akash.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IStudentDao;
import in.pwskills.akash.entity.Student;
import in.pwskills.akash.exception.StudentRecordNotFoundException;

@Component
public class StudentDeleteRunner implements CommandLineRunner {
	
	@Autowired
	private IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		//dao.deleteById(10);
		
		Student student = new Student();
		student.setSid(10);
		student.setSname("sachin");
		student.setSage(52);
		student.setSaddress("MI");
		dao.delete(student);
		
		dao.delete(dao.findById(7).orElseThrow(()->new StudentRecordNotFoundException(
						String.format("Record for %s object not available for the given id %d", Student.class.getName(), 100))));
	
		dao.deleteAllById(List.of(18,7));
	
	}

}
