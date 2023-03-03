package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstname(String name);

    @Query("select c from Customer c where c.address.city= :city")
    List<Customer> findCustomerByCity(@Param("city") String city);
    @Query("select c from Customer c JOIN c.creditcards cr where cr.number= :ccnumber ")
    List<Customer> findCustomerByCreditcard(@Param("ccnumber") String ccnumber);
}
