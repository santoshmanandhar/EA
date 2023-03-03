package repositories;

import entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
