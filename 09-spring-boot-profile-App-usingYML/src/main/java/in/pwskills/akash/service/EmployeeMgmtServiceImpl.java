package in.pwskills.akash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.akash.beans.EmployeeBO;
import in.pwskills.akash.beans.EmployeeDTO;
import in.pwskills.akash.service.dao.IEmployeeDao;
@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<EmployeeDTO> fetchEmpByDesg(String[] desg) throws Exception {
		//desg = ['batsman','bowler']
		System.out.println(dao.getClass().getName());
		
		//setting up immutable memory for conversion
		StringBuilder builder = new StringBuilder("(");
		
		for(int i =0; i<desg.length ; i++) {
			//append based on the index we are processing
			if(i == desg.length-1) {
				//last index we are processing
				builder.append("'"+desg[i]+"')");
			}else {
				//still data is there is to be processed
				builder.append("'"+desg[i]+"',");
			}
			
		}	
		
		//converting StringBuilder to String object
		String cond = builder.toString();
		System.out.println("Condition to be sent is :: "+cond);
		
		List<EmployeeBO> listBo = dao.fetchEmpByDesg(cond);
		
		List<EmployeeDTO> listDto = new ArrayList<>();
		
		listBo.forEach(
				bo->{
					EmployeeDTO dto = new EmployeeDTO();
					//copy from bo to dto
					//[datatype and fieldname same]
					BeanUtils.copyProperties(bo,dto);
					
					//setting srNo with our logic
					dto.setSrNo(listDto.size() + 1);
					
					//add the object to listDto
					listDto.add(dto);
				}
	);
		
		return listDto;
	}

}
