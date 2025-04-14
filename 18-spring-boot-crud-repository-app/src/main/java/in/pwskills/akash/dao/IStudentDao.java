package in.pwskills.akash.dao;

import org.springframework.data.repository.CrudRepository;

import in.pwskills.akash.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {
	// C R U D operation methods are auto coming from CrudRepository
}
