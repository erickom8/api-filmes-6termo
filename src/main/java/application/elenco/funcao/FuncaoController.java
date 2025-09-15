package application.elenco.funcao;

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
@RequestMapping("/funcoes")
public class FuncaoController {
    @Autowired
    private FuncaoService funcaoService;

    @PostMapping
    public FuncaoDTO insert(@RequestBody FuncaoInsertDTO novoFuncao) {
        return funcaoService.insert(novoFuncao);
    }

    @GetMapping("/{id}")
    public FuncaoDTO getOne(@PathVariable long id) {
        return funcaoService.getOne(id);
    }

    @GetMapping
    public Iterable<FuncaoDTO> getAll() {
        return funcaoService.getAll();
    }

    @PutMapping("/{id}")
    public FuncaoDTO update(@PathVariable long id, @RequestBody FuncaoInsertDTO novosDados) {
        return funcaoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        funcaoService.delete(id);
    }
}