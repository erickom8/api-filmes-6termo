package application.model;

import application.record.GeneroDTO;
import application.record.GeneroInsertDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Integer idade;

    public Genero(GeneroDTO dados) {
        this.setId(dados.id());
        this.setNome(dados.nome());
    }

    public Genero(GeneroInsertDTO dados) {
        this.setNome(dados.nome());
    }
}




