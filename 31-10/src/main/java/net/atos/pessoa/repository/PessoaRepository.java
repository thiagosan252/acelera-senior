package net.atos.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
