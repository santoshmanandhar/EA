package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class CustomerDAOMockImpl implements CustomerDAO {
    private Logger logger;

    @Autowired
    public CustomerDAOMockImpl(Logger logger){
        this.logger = logger;
    }
    @Override
    public void save(Customer customer) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAO: saving customer from Test environment "+customer.getName());
        logger.log("Customer is saved in the DB of Test Environment: "+ customer.getName() );

    }
}
