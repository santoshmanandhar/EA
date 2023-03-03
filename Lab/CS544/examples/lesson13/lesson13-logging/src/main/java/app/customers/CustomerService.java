package app.customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public void addCustomer(){
        logger.trace("A TRACE Message");
    }

    public void updateCustomer(){
        logger.debug("A DEBUG Message");
    }

    public void removeCustomer(){
        logger.info("An INFO Message");
    }

    public void findCustomerById(){
        logger.warn("A WARN Message");
    }

    public void findCustomersByName(){
        logger.error("An ERROR Message");
    }

}
