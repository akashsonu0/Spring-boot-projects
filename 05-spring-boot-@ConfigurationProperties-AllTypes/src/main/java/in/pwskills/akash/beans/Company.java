package in.pwskills.akash.beans;

public class Company {
	
	static {
		System.out.println("Company.class file is loading...");
	}
	
	public Company() {
		System.out.println("Company Object is created...");
	}

	private String title;
	private String location;
	private Integer size;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", size=" + size + "]";
	}
	
	
}
