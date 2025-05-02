package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
