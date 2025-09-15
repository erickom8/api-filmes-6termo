package application.elenco;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.elenco.artista.Artista;
import application.elenco.artista.ArtistaRepository;
import application.elenco.funcao.Funcao;
import application.elenco.funcao.FuncaoRepository;
import application.filmes.Filme;
import application.filmes.FilmeRepository;

@Service
public class ElencoService {
    @Autowired
    private ElencoRepository elencoRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private ArtistaRepository artistaRepository;
    @Autowired
    private FuncaoRepository funcaoRepository;
    
    public Iterable<ElencoDTO> getAll() {
        return elencoRepository.findAll().stream().map(ElencoDTO::new).toList();
    }

    public ElencoDTO insert(ElencoInsertDTO dados) {
        Optional<Filme> resultadoFilme = filmeRepository.findById(dados.idFilme());
        Optional<Artista> resultadoArtista = artistaRepository.findById(dados.idArtista());
        Optional<Funcao> resultadoFuncao = funcaoRepository.findById(dados.idFuncao());

        String mensagem = "Dados não encontrados: ";
        boolean isError = false;

        if(resultadoFilme.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Filme";
            isError = true;
        }
        if(resultadoArtista.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Artista";
            isError = true;
        }
        if(resultadoFuncao.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Função";
            isError = true;
        }
        if(isError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, mensagem
            );
        }

        Elenco novo = new Elenco();
        novo.setFilme(resultadoFilme.get());
        novo.setArtista(resultadoArtista.get());
        novo.setFuncao(resultadoFuncao.get());

        return new ElencoDTO(elencoRepository.save(novo));
    }

    public ElencoDTO update(long id, ElencoInsertDTO dados) {
        Optional<Elenco> resultadoElenco = elencoRepository.findById(id);
        if (resultadoElenco.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elenco não encontrado"
            );
        }
        Optional<Filme> resultadoFilme = filmeRepository.findById(dados.idFilme());
        Optional<Artista> resultadoArtista = artistaRepository.findById(dados.idArtista());
        Optional<Funcao> resultadoFuncao = funcaoRepository.findById(dados.idFuncao());

        String mensagem = "Dados não encontrados: ";
        boolean isError = false;

        if(resultadoFilme.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Filme";
            isError = true;
        }
        if(resultadoArtista.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Artista";
            isError = true;
        }
        if(resultadoFuncao.isEmpty()) {
            if(isError)
                mensagem += ", ";
            mensagem += "Função";
            isError = true;
        }
        if(isError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, mensagem
            );
        }

        resultadoElenco.get().setFilme(resultadoFilme.get());
        resultadoElenco.get().setArtista(resultadoArtista.get());
        resultadoElenco.get().setFuncao(resultadoFuncao.get());

        return new ElencoDTO(elencoRepository.save(resultadoElenco.get()));
    }

    public void delete(long id) {
        if(!elencoRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elenco não encontrado"
            );
        }

        elencoRepository.deleteById(id);
    }
}