package in.pwskills.akash.runner;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.akash.beans.Naukri;
import in.pwskills.akash.dao.INaukriDao;


@Component
public class NaukriRunner implements CommandLineRunner {
	
	@Autowired
	private INaukriDao dao;
	
	@Override
	public void run(String... args) throws Exception {
			

		
		 Naukri naukri = new Naukri(); 
		 naukri.setAddress("RCB");
		 naukri.setName("akash");
		 
		 File image = new File("D:\\akash.jpg"); naukri.setImage(image);
		  
		 File resume = new File("D:\\resume.txt"); naukri.setResume(resume);
		 
		 dao.saveObject(naukri);
		 
		 
		/*Naukri naukri = dao.readObject();
		System.out.println("Name     is :: " + naukri.getName());
		System.out.println("Address  is :: " + naukri.getAddress());
		System.out.println("Image    is :: " + naukri.getImage().getAbsolutePath());
		System.out.println("Resume   is :: " + naukri.getResume().getAbsolutePath());
		
		 */ 
		}

}
