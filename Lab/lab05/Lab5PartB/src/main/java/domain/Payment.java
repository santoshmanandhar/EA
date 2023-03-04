package domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Payment {

	private String payDate;
	private double amount;

	public Payment() {
	}

	public Payment(String payDate, double amount) {
		this.payDate = payDate;
		this.amount = amount;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "'\n'Payment{" +
				"payDate='" + payDate + '\'' +
				", amount=" + amount +
				'}';
	}
}
