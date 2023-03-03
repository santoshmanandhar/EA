package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ICustomerService  customerService(){
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public ICustomerDAO customerDAO(){
        CustomerDAO customerDAO = new CustomerDAO(logger());
        return customerDAO;
    }

    @Bean
    public IEmailSender emailSender(){
        EmailSender emailSender = new EmailSender(logger());
        return emailSender;
    }

    @Bean
    public ILogger logger(){
        Logger logger = new Logger();
        return logger;
    }
}
