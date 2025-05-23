package in.pwskills.akash.runner;

import java.util.Arrays;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.dao.IProductRepository;
import in.pwskills.akash.entity.Product;


@Component
public class ProductRunner implements CommandLineRunner {
	
	@Autowired
	private IProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
	
		Product pob = new Product();
		pob.setProdId(10);
		pob.setProdCode("PEN");
		
		pob.setColors(Arrays.asList("RE","GE","BL"));
		//pob.setColors(List.of("RE","GE","BL"))
		
		Set<String> set = new LinkedHashSet<>();
		set.add("MI");
		set.add("LA");
		set.add("SF");
		
		Map<String, String> map = new LinkedHashMap<>();
		map.put("D1", "ABC");
		map.put("D2","XYZ");
		
		pob.setDetails(map);
		pob.setModels(set);
		
		repo.save(pob);
		
		
		
		
	}

}
