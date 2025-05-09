package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
