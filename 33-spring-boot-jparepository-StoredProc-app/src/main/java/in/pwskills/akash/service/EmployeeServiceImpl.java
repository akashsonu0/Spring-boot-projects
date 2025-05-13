package in.pwskills.akash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.akash.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> searchEmpByDesgs(String desg1, String desg2) {
		
		//Logic to call stored procedure
		System.out.println(entityManager.getClass().getName());
		
		//Creating an Object to call storedProcedure
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GET_EMPDETAILS_BY_DESGS",Employee.class); 
		
		//Registering the type of IN parameter
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		//Set the parameter value
		query.setParameter(1,desg1);
		query.setParameter(2,desg2);
		
		//run stored Procedure and get the result
		List<Employee> list = query.getResultList();
		
		return list;
	}

}
