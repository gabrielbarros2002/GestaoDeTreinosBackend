package com.barros.gestao_de_treinos.repositories;

import com.barros.gestao_de_treinos.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}
