package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
