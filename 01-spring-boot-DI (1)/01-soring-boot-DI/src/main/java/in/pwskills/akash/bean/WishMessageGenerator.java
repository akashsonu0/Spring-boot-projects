package in.pwskills.akash.bean;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {
	
	static {
		System.out.println("WishMessageGenerator.class file is loading....");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator Object is created...");
		
	}
	@Autowired
	private LocalDateTime ldt;
	
	//Business logic
	public String WishMessage(String user) {
		
		int hour = ldt.getHour();
		String msg="";
		if(hour<12) {
			msg +="Good morning :: "+ user;
		} else if(hour<16) {
			msg +="Good Afternoon :: "+ user;
		} else if(hour<20) {
			msg +="Good Evening :: "+ user;
		} else {
			msg +="Good night :: "+ user;
		}
		return msg;
	}
	
}
