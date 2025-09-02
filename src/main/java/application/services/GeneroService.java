package application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Genero;
import application.record.GeneroDTO;
import application.record.GeneroInsertDTO;
import application.repository.GeneroRepository;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepo;

    public Iterable<GeneroDTO> getAll(){
        return generoRepo.findAll().stream().map(GeneroDTO::new).toList();
    
    }

    public GeneroDTO getOne(long id) {
        Optional<Genero> resultado = generoRepo.findById(id); 

        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero não encontrado"
            );
        }
        return new GeneroDTO(resultado.get());
    }

    public GeneroDTO insert(GeneroInsertDTO dados) {
        return new GeneroDTO(generoRepo.save(new Genero(dados)));
    }
    
    public GeneroDTO update(long id, GeneroInsertDTO novosDados){
        Optional<Genero> resultado = generoRepo.findById(id);

        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero não encontrado"
            );
        }

        Genero generoExistente = resultado.get();

        if (novosDados.nome() != null) {
            generoExistente.setNome(novosDados.nome());
        }

        return new GeneroDTO(generoRepo.save(generoExistente));
    }

    public void delete(long id) {
        if(!generoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero não encontrado"
            );
        }
        
        generoRepo.deleteById(id);
    }
}
