package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
