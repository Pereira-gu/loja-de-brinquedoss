package com.catalogo.loja.controller;

import com.catalogo.loja.model.Categoria;
import com.catalogo.loja.model.Item;
import com.catalogo.loja.model.Equipe;
import com.catalogo.loja.repository.CategoriaRepository;
import com.catalogo.loja.repository.ItemRepository;
import com.catalogo.loja.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") 
public class Controller {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/brinquedos")
    public List<Item> listar() {
        return repository.findAll();
    }

    @PostMapping("/brinquedos")
    public Item salvar(@RequestBody Item item) {
        return repository.save(item);
    }

    @PutMapping("/brinquedos/{id}")
    public Item editar(@PathVariable Long id, @RequestBody Item item) {
        item.setId(id);
        return repository.save(item);
    }

    @DeleteMapping("/brinquedos/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias(){return categoriaRepository.findAll(); }

    @PostMapping("/categorias")
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {return categoriaRepository.save(categoria);}

    @GetMapping("/equipe")
    public List<Equipe> listarEquipe() {
        return equipeRepository.findAll();
    }
}