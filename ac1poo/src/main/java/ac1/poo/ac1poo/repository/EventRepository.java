package ac1.poo.ac1poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac1.poo.ac1poo.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    
}
