package demo;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    public void sendEmail() {
        System.out.println("Sending email");
    }
}