package in.pwskills.akash.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pwskills.akash.entity.Employee;

public interface IEmployeePagingSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
