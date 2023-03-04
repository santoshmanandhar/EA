package app;

import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.AppointmentRepository;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	@Autowired
	AppointmentRepository appointmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Doctor doctor1 = new Doctor("Chirurg", "Frank", "Brown");
		Doctor doctor2 = new Doctor("Nurse", "Mary", "Jones");
		Doctor doctor3 = new Doctor("Nurse", "Anne", "Mary");


		Payment payment1 = new Payment("10-10-2008", 12.50);
		Payment payment2 = new Payment("11-10-2008", 45.00);
		Payment payment3 = new Payment("12-10-2008", 99.60);
		Payment payment4 = new Payment("13-10-2008", 55.80);
		Payment payment5 = new Payment("18-10-2008", 99.99);

		Patient patient1 = new Patient("Jerry Lewis", "34 4th avenue",
				"13221", "New York");
		Patient patient2 = new Patient("Frank Moore", "34 Mainstret",
				"13221", "New York");
		Patient patient3 = new Patient("Sam ruby", "105 N Street", "13221",
				"New York");
		Patient patient4 = new Patient("Johny Deep", "1000 N Street", "54552",
				"Fairfield");



		Appointment appointment1 = new Appointment("11-11-2008", patient1,
				payment1, doctor1);
		Appointment appointment2 = new Appointment("12-11-2008", patient2,
				payment2, doctor2);
		Appointment appointment3 = new Appointment("13-11-2008", patient3,
				payment3, doctor2);
		Appointment appointment4 = new Appointment("14-11-2008", patient1,
				payment4, doctor1);
		Appointment appointment5 = new Appointment("18-11-2008", patient4,
				payment5, doctor3);

		appointmentRepository.save(appointment1);
		appointmentRepository.save(appointment2);
		appointmentRepository.save(appointment3);
		appointmentRepository.save(appointment4);
		appointmentRepository.save(appointment5);

		//=================RETRIEVE INFORMATION ===========
		System.out.println();
		System.out.println("=========Appointment========");
		System.out.println(appointmentRepository.findAll());
		System.out.println();



	}


}
