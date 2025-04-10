package in.pwskills.akash.dao;

import java.util.List;

import in.pwskills.akash.beans.ProductBO;

public interface IProductDao {
	public List<ProductBO> getProductsByName(String prod1,String prod2);
}
