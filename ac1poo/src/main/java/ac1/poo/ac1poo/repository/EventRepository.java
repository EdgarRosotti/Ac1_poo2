package ac1.poo.ac1poo.repository;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ac1.poo.ac1poo.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Query("SELECT c FROM Event c ")
    public Page<Event> find(Pageable pageRequest, String nome, String local, LocalDate dataInicial, String descricao);
    
}
