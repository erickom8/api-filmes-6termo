package application.produtora;

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
@RequestMapping("/produtoras")
public class ProdutoraController {
    @Autowired
    private ProdutoraService produtoraService;

    @PostMapping
    public ProdutoraDTO insert(@RequestBody ProdutoraInsertDTO novoProdutora) {
        return produtoraService.insert(novoProdutora);
    }

    @GetMapping("/{id}")
    public ProdutoraDTO getOne(@PathVariable long id) {
        return produtoraService.getOne(id);
    }

    @GetMapping
    public Iterable<ProdutoraDTO> getAll() {
        return produtoraService.getAll();
    }

    @PutMapping("/{id}")
    public ProdutoraDTO update(@PathVariable long id, @RequestBody ProdutoraInsertDTO novosDados) {
        return produtoraService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        produtoraService.delete(id);
    }
}