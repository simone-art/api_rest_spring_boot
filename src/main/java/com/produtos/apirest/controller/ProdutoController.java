package com.produtos.apirest.controller;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
// ======================CrossOrigin=======================//
//Anotação que permite liberar todos os dominios da Api
//Ao colocar o * você autoriza que qualquer dominio acesse a sua API
//No origins você podería colocar o dominio da sua página se tivesse
// ======================CrossOrigin=======================//

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

    //Método pra deletar produto
    @DeleteMapping("/produto/")
    public String deletarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
        return "Produto deletado com sucesso";
    }

    //Método para atualizar um produto
    //@RequestBody permite receber o produto através do JSON
    @PutMapping("/produto")
    public String atualizarProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return "Produto atualizado com sucesso";

    }
}