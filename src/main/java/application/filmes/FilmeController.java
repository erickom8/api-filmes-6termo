package application.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    FilmeService filmeService;

    @GetMapping
    public Iterable<FilmeDTO> getAll(){
        return this.filmeService.getAll();
    }

    @PostMapping
    public FilmeDTO insert(@RequestBody FilmeInsertDTO novoFilme) {
        return this.filmeService.insert(novoFilme);
    }

    @PutMapping("/{id}")
    public FilmeDTO update(@PathVariable long id, @RequestBody FilmeInsertDTO novosDadosFilme) {
        return this.filmeService.update(id, novosDadosFilme);
    }

    // @GetMapping("/{id}")
    
}
