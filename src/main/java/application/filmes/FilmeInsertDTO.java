package application.filmes;

import java.util.List;

public record FilmeInsertDTO(String titulo, long idGenero, List<Long> idsProdutoras) {
    
}
