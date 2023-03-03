package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@SequenceGenerator(name="paymentSeq", sequenceName="PAYMENT_SEQUENCE")
public class Payment {

	@Id
//	@GeneratedValue(generator="paymentSeq")
	@GeneratedValue()
	private long id;
	private double amount;

	public Payment() {
	}

	public Payment(double amount) {
		this.amount = amount;
	}
}



