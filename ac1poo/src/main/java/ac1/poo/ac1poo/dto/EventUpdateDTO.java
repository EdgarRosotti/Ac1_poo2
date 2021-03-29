package ac1.poo.ac1poo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventUpdateDTO {
    private LocalDate dataInicial;
    private LocalTime horarioInicial;
    private String email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
