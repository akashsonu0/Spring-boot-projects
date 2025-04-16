package in.pwskills.akash.dao;

import org.springframework.data.repository.CrudRepository;

import in.pwskills.akash.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
