package ac1.poo.ac1poo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import ac1.poo.ac1poo.entities.Event;


public class EventDTO {
    private Long id;
    private String nome;
    private String local;
    private LocalDate dataInicial;
    private LocalTime horarioInicial;
    public EventDTO() {
	}

    public EventDTO(Long id, String nome, String local, LocalDate dataInicial, LocalTime horarioInicial ) {
       this.id=id;
       this.nome=nome;
       this.local=local;
       this.dataInicial=dataInicial;
       this.horarioInicial=horarioInicial;
	}

	public EventDTO(Event e) {
        this.id = e.getId();
        this.nome=e.getNome();
        this.local=e.getLocal();
        this.dataInicial=e.getDataInicial();
        this.horarioInicial=e.getHorarioInicial();
	}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }
    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }
  

}
