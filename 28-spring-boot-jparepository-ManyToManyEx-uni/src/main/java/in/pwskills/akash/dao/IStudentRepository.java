package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
