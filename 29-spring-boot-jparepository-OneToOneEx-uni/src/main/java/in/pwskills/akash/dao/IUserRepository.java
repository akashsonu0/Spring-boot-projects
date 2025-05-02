package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
