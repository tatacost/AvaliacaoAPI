package org.serratec.backend.avaliacao.repository;


import org.serratec.backend.avaliacao.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{

}
