package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import in.pwskills.akash.entity.MarriageSeeker;

public interface IMarriageRepository extends JpaRepository<MarriageSeeker, Long> {
   
	
	
}