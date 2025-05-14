package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
