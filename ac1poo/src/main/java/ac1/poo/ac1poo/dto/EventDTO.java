package ac1.poo.ac1poo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import ac1.poo.ac1poo.entities.Event;
import lombok.Data;

@Data
public class EventDTO {
    private Long id;
    private String nome;
    private String local;
    private LocalDate dataFinal;
    private LocalDate dataInicial;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private String email;
    public EventDTO(Event evento){
        this.nome = evento.getNome();
        this.local = evento.getLocal();
        this.dataFinal = evento.getDataFinal();
        this.dataInicial = evento.getDataInicial();
        this.horarioInicial = evento.getHorarioInicial();
        this.horarioFinal = evento.getHorarioFinal();
        this.email = evento.getEmail();
    }
	public EventDTO(Long id2, String nome2, String local2, LocalDate dataFinal2, LocalDate dataInicial2,
			LocalTime horarioInicial2, LocalTime horarioFinal2, String email2) {
	}
}
