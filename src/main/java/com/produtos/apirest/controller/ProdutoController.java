package com.produtos.apirest.controller;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Método que lista todos os produtos
    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //Método que lista o produto pelo id
    @GetMapping("/produto/{id}")
    public Produto buscaProdutoId(@PathVariable long id) {
        return produtoRepository.findById(id);
    }

    //Método pra salvar um produto
    //@RequestBody tras a requisicão no Body
    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}