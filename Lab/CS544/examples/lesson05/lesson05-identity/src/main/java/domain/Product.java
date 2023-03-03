package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@SequenceGenerator(name="productSeq", sequenceName="PRODUCT_SEQUENCE")
public class Product {

	@Id
//	@GeneratedValue(generator="productSeq")
	@GeneratedValue()
	private long id;
	private String name;

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}
}


