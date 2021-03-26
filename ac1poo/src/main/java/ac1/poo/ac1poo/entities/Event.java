package ac1.poo.ac1poo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ac1.poo.ac1poo.dto.EventInsertDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "TB_EVENT")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Event implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String local;
    private LocalDate dataFinal;
    private LocalDate dataInicial;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private String email;
    public Event(EventInsertDTO insertDTO){
        this.nome = insertDTO.getNome();
        this.descricao = insertDTO.getDescricao();
        this.local = insertDTO.getLocal();
        this.dataFinal = LocalDate.parse(insertDTO.getDataFinal());
        this.dataInicial = LocalDate.parse(insertDTO.getDataInicial());
        this.horarioInicial = LocalTime.parse(insertDTO.getHorarioInicial());
        this.horarioFinal = LocalTime.parse(insertDTO.getHorarioFinal());
        this.email = insertDTO.getEmail();
    }
    
}
