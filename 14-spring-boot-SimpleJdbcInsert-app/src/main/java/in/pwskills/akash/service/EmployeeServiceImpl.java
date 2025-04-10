package in.pwskills.akash.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.akash.beans.EmployeeBO;
import in.pwskills.akash.beans.EmployeeDTO;
import in.pwskills.akash.dao.IEmployeeDAO;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public int registerEmployee(EmployeeDTO dto) {
		
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.saveEmployee(bo);
		
	}

}
