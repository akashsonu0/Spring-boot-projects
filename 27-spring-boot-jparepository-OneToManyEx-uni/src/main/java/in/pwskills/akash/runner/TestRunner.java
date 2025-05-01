package in.pwskills.akash.runner;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IModelsRepository;
import in.pwskills.akash.dao.IProductRepository;
import in.pwskills.akash.entity.Models;
import in.pwskills.akash.entity.Product;
@Component
public class TestRunner implements CommandLineRunner {
	
	@Autowired
	private IModelsRepository mrepo;
	
	@Autowired
	private IProductRepository prepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Models m1 = new Models(1012, "XYZ-A", "4GB-128GB-RED");
		Models m2 = new Models(1013, "XYZ-B", "6GB-256GB-GREEN");
		Models m3 = new Models(1014, "MN-V", "12GB-512GB-PINK");
		Models m4 = new Models(1011, "MN-D", "2GB-2GB-BLACK");
		
		Product p1 = new Product(10, "ABCD-XYZ" ,Arrays.asList(m1,m2));
		Product p2 = new Product(11, "ABCD-MN" ,Arrays.asList(m3,m4));
		
		mrepo.save(m1);
		mrepo.save(m2);
		mrepo.save(m3);
		mrepo.save(m4);
		
		prepo.save(p1);
		prepo.save(p2);
	}

}
