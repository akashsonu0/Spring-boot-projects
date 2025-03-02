package in.pwskills.akash.bean;

import org.springframework.stereotype.Component;

@Component("java")
public final class javaCourseMaterial implements ICourseMaterial {
	
	 static {
	        System.out.println("javaCourseMaterial.class file is loading....");
	    }

	    public javaCourseMaterial() {
	        System.out.println("javaCourseMaterial Object is created...");
	    }

	@Override
	public String courseContent() {
		
		return "1. OOPS 2. ExceptionHandling 3. Collections...";
	}

	@Override
	public Double price() {
		return 5000.0;
	}

}
