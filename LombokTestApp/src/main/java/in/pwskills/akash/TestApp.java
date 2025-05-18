package in.pwskills.akash;

import in.pwskills.akash.bean.Employee;

public class TestApp {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setEid(10);
		emp1.setEname("sachin");
		emp1.setEaddress("MI");
		emp1.setEsalary(3456.7f);
		
		System.out.println(emp1);
		
		Employee emp2 = new Employee(7,"dhoni","CSK",45678.5f);	
		System.out.println(emp2);
		
		Employee emp3 = new Employee(18,"kohli","RCB");	
		System.out.println(emp3);
		
		System.out.println(emp1==emp2);//compare the reference 
		System.out.println(emp1.equals(emp2));//compare the data
		
		//hashcode of 2 objects can be same only when we override hashcode()
		//depending upon the state of the object we can keep 2 objects hashcode same
		System.out.println(emp1.hashCode()+ "==" +emp2.hashCode());
		
		//JVM maintaining the hashcode(through this only == operators works)
		System.out.println("JVM Miantained hashcode is :: "
				+System.identityHashCode(emp1) + "==" +System.identityHashCode(emp2));
		
	}

}
