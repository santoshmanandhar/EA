package customers;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Logger implements ILogger{

	public void log(String logstring) {
		System.out.println("Logging "+LocalDateTime.now()+" "+logstring);		
	}

}
