package in.pwskills.akash.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.akash.beans.ProductBO;
import in.pwskills.akash.beans.ProductDTO;
import in.pwskills.akash.dao.IProductDao;

@Service("service")
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao dao;

	@Override
	public List<ProductDTO> fetchProductsByName(String prod1, String prod2) {
		
		List<ProductBO> listBo = dao.getProductsByName(prod1, prod2);
		
		ArrayList<ProductDTO> listDto = new ArrayList<>();
		
		listBo.forEach(bo -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});
		
		return listDto;
	}
	

}
