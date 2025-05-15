package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.MobileNumber;

public interface IMobileNumberRepository extends JpaRepository<MobileNumber, Long> {

}
