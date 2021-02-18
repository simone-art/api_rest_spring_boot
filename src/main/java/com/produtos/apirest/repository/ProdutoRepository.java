package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

//Passa como parámetros a entidade e o Id
//O JpaRepository tem vários métodos que fazem as persistência de dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
