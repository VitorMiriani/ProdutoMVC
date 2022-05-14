package br.com.fiap.appproduto.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.appproduto.produto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

 

}

