package domain;


import javax.persistence.*;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private int id;

	private String appdate;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Patient patient;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Doctor doctor;

	@Embedded
	private Payment payment;


	public Appointment() {
	}

	public Appointment(String appdate, Patient patient, Payment payment,
			Doctor doctor) {
		this.appdate = appdate;
		this.patient = patient;
		this.payment = payment;
		this.doctor = doctor;
	}


	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "'\n'Appointment{" +
				"id=" + id +
				", appdate='" + appdate + '\'' +
				", patient=" + patient +
				", doctor=" + doctor +
				", payment=" + payment +
				'}';
	}
}
