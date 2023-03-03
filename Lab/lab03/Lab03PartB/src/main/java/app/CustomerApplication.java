package app;

import domain.Book;
import domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));



		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();



		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		//BOOK
		bookRepository.save((new Book("Into The Wild", "12345", "Jon KraKauerv", 120)));
		bookRepository.save((new Book("Into Thin Air", "58652", "Jon KraKauerv", 100)));
		bookRepository.save((new Book("Dev Das", "98651", "Sarat Chandra Chatopadhya", 200)));

		//FETCH ALL BOOKS
		System.out.println("Books found with findAll():");
		System.out.println("===========================");
		for (Book book : bookRepository.findAll()){
			System.out.println(book);
		}
		System.out.println();

		//FIND BOOK BY ID AND UPDATE BOOK
		System.out.println("Book updated with findById:");
		System.out.println("===========================");
		int bookID=6;
		Book book = bookRepository.findById(bookID).get();
		book.setISBN("001258");
		bookRepository.save(book);

		//DELETE THE BOOK THAT WAS UPDATED IN ABOVE STEP
		System.out.println("Book Deleted: ");
		System.out.println("===========================");
		bookRepository.deleteById(bookID);
		System.out.println("Book with ID: " + bookID + " deleted from database.");

		//FETCH ALL BOOKS AGAIN
		System.out.println("New Books found with findAll():");
		System.out.println("===========================");
		for (Book book1 : bookRepository.findAll()){
			System.out.println(book1);
		}



	}
}
