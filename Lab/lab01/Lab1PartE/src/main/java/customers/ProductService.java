package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private IProductDAO iProductDAO;
    private IEmailSender iEmailSender;

    @Autowired
    public void setiProductDAO(IProductDAO iProductDAO){
        this.iProductDAO = iProductDAO;
    }

    @Autowired
    public void setiEmailSender(IEmailSender iEmailSender){
        this.iEmailSender=iEmailSender;
    }
    @Override
    public void addProduct(int id, String name, String category) {
        Product prod = new Product(id, name, category);
        iProductDAO.save(prod);
        iEmailSender.sendEmail("abc@gmail.com", "Product " + name + " added to the DB.");
    }
}
