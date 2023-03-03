package app;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.DepartmentRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("repositories")
public class Application implements CommandLineRunner {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//=========PART A==========
		Department dept = new Department("IT");
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Santosh",dept));
		emp.add(new Employee("Arjun",dept));
		dept.setEmployee(emp);
		departmentRepository.save(dept);

		//RETRIEVE DEPARTMENT
		List<Department> departments = departmentRepository.findAll();
		for(Department department:departments){
			System.out.println(department.toString());
		}

		//=========PART B==========

		System.out.println("===========Save Book and Publisher=============");
		Book book = new Book("Into The Wild","Jon");
		book.setPublisher(new Publisher("Amazon"));
		bookRepository.save(book);
		book=new Book("Into Thin Air", "Karauke");
		bookRepository.save(book);

		//RETRIEVE BOOK
		System.out.println("=============RETRIEVING BOOKS AND AUTHROS=============");
		System.out.println(bookRepository.findAll());

		//=========PART C==========
		System.out.println("===========Flight and Passangers=============");
		Passenger passenger = new Passenger("Arjun");
		List<Flight> flightList = new ArrayList<>();
		flightList.add(new Flight("AB1234", "Des Moines", "Kathmandu", LocalDate.of(2022,12,12)));
		passenger.setFlightList(flightList);
		passengerRepository.save(passenger);

		System.out.println("=============RETRIEVING FLIGHT AND PASSANGERS=============");
		List<Passenger> passengers = passengerRepository.findAll();
		for(Passenger pass:passengers){
			System.out.println(pass.toString());
		}

		//=========PART D==========

		School school = new School("Jyoti HSBS");
		Student student = new Student("Santosh", "Manandhar");
		Map<Integer, Student> students = new HashMap<Integer, Student>();
		students.put(1,student);
		school.setStudents(students);
		schoolRepository.save(school);

		System.out.println("=============RETRIEVING FLIGHT AND PASSANGERS=============");
		System.out.println(schoolRepository.findAll());

	}
}
