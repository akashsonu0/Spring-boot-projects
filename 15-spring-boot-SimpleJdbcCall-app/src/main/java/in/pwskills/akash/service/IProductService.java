package in.pwskills.akash.service;

import java.util.List;

import in.pwskills.akash.beans.ProductDTO;

public interface IProductService {
	public List<ProductDTO> fetchProductsByName(String prod1,String prod2);
}
