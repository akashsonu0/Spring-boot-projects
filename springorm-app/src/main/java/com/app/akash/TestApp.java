package com.app.akash;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.app.akash.beans.Student;
import com.app.akash.config.AppConfig;
import com.app.akash.repo.IStudentRepo;

public class TestApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IStudentRepo repo = context.getBean(IStudentRepo.class);

		
		repo.findAllStudents().forEach(System.out::println);
		
		System.out.println("*******************************************************");
		Student student = repo.findById(2);
		System.out.println(student);
		
		System.out.println("*******************************************************");
		Student stdUpdate = new Student();
		stdUpdate.setSid(2);
		stdUpdate.setSaddress("IND");
		stdUpdate.setSage(42);
		stdUpdate.setSname("mahendra");
		
		System.out.println(repo.updateStudent(stdUpdate));
		
		context.close();
	}
}