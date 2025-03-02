package in.pwskills.akash.bean;

import org.springframework.stereotype.Component;

@Component("dotNet")
public final class DotNetCourseMaterial implements ICourseMaterial {

	 static {
	        System.out.println("DotNetCourseMaterial.class file is loading....");
	    }

	    public DotNetCourseMaterial() {
	        System.out.println("DotNetCourseMaterial Object is created...");
	    }
	    
	@Override
	public String courseContent() {
		return "1. C#Ooops 2. C#ExceptionalHandling 3.C#Collections..." ;
	}

	@Override
	public Double price() {
		return 3500.0;
	}

}
