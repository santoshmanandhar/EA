package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private ProductDAO productDAO;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);

		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());

		System.out.println("==================END OF LINE FOR CUSTOMER============\n \n");

		//PRODUCT
		productDAO.clearDB();
		Product product = new Product(3,"Haldiram Rasbari",20);
		Supplier supplier = new Supplier("ABC Corp", "1234567890");
		product.setSupplier(supplier);
		productDAO.save(product);
		product = new Product(4,"KFC",45);
		supplier = new Supplier("KFC Nepal", "987654321");
		product.setSupplier(supplier);
		productDAO.save(product);
		System.out.println("Products are saved");

//
		System.out.println("-----------All Products -----------");
		System.out.println(productDAO.getAllProducts());

		System.out.println("=====================");

		System.out.println("=====================");
		System.out.println(productDAO.getProductByProdNumber(4));

		System.out.println("=====================");
		System.out.println(productDAO.getProductByProdName("Haldiram Rasbari"));

		System.out.println("=====================");
		productDAO.removeProduct(3);
	}
}
