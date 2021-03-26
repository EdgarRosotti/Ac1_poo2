package ac1.poo.ac1poo.dto;



import lombok.Data;
@Data
public class EventInsertDTO {
    private String nome;
    private String descricao;
    private String local;
    private String dataFinal;
    private String dataInicial;
    private String horarioInicial;
    private String horarioFinal;
    private String email;
}
