package application.generos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;
    
    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroInsertDTO novoGenero) {
        return generoService.insert(novoGenero);
    }

    @GetMapping
    public Iterable<GeneroDTO> getAll() {
        return generoService.getAll();
    }

    @GetMapping(("/{id}"))
    public GeneroDTO getOne(@PathVariable long id){
        return generoService.getOne(id);
    }

    @PutMapping("/{id}")
    public GeneroDTO update(@PathVariable long id, @RequestBody GeneroInsertDTO novosDados) {
        return generoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        generoService.delete(id);
    }

}
