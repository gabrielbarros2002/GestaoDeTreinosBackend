package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.ExecucaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExecucaoTreinoRepository extends JpaRepository<ExecucaoTreino, Long> {

    List<ExecucaoTreino> findByUsuarioId(Long usuarioId);

}
