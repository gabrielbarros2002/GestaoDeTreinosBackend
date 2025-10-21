package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.*;
import com.barros.gestao_de_treinos.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile({"test", "dev"})
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private TreinoExercicioRepository treinoExercicioRepository;

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() > 0) return;

        // 1. Criar usuário
        Usuario usuario1 = new Usuario(null, "Gabriel Barros", "gabriel.barros@email.com", "senha1234", LocalDate.of(2025, 10, 25));


        // 2. Criar grupos musculares
        GrupoMuscular grupoPeito = new GrupoMuscular(null, "Peito");
        GrupoMuscular grupoCostas = new GrupoMuscular(null, "Costas");
        GrupoMuscular grupoPernas = new GrupoMuscular(null, "Pernas");
        GrupoMuscular grupoOmbros = new GrupoMuscular(null, "Ombros");
        GrupoMuscular grupoBiceps = new GrupoMuscular(null, "Bíceps");
        GrupoMuscular grupoTriceps = new GrupoMuscular(null, "Tríceps");
        GrupoMuscular grupoGluteos = new GrupoMuscular(null, "Glúteos");
        GrupoMuscular grupoPanturrilhas = new GrupoMuscular(null, "Panturrilhas");
        GrupoMuscular grupoAbdomen = new GrupoMuscular(null, "Abdômen");
        GrupoMuscular grupoAntebracos = new GrupoMuscular(null, "Antebraços");

        grupoMuscularRepository.saveAll(Arrays.asList(grupoPeito, grupoCostas, grupoPernas, grupoOmbros, grupoBiceps, grupoTriceps,
                grupoGluteos, grupoPanturrilhas, grupoAbdomen, grupoAntebracos));


        // 3. Criar exercícios
        Exercicio supinoReto = new Exercicio(null, "Supino reto", "Exercício clássico para trabalhar o peitoral maior", grupoPeito);
        Exercicio crucifixoReto = new Exercicio(null, "Crucifixo reto", "Isolamento para o peitoral", grupoPeito);
        Exercicio supinoInclinadoComHalteres = new Exercicio(null, "Supino inclinado com halteres", "Trabalha a parte superior do peitoral", grupoPeito);
        Exercicio puxadaFrente = new Exercicio(null, "Puxada frente", "Trabalha o latíssimo do dorso", grupoCostas);
        Exercicio remadaCurvada = new Exercicio(null, "Remada curvada", "Exercício composto para costas", grupoCostas);
        Exercicio barraFixa = new Exercicio(null, "Barra fixa", "Exercício completo para desenvolvimento das costas", grupoCostas);
        Exercicio agachamentoLivre = new Exercicio(null, "Agachamento livre", "Trabalha quadríceps, glúteos e posteriores", grupoPernas);
        Exercicio cadeiraFlexora = new Exercicio(null, "Cadeira flexora", "Foca nos posteriores de coxa", grupoPernas);
        Exercicio legPress45 = new Exercicio(null, "Leg press 45°", "Exercício completo para membros inferiores", grupoPernas);
        Exercicio desenvolvimentoComHalteres = new Exercicio(null, "Desenvolvimento com halteres", "Fortalece os deltoides", grupoOmbros);
        Exercicio elevacaoLateral = new Exercicio(null, "Elevação lateral", "Isola a cabeça média do deltoide", grupoOmbros);
        Exercicio remadaAlta = new Exercicio(null, "Remada alta", "Trabalha os deltoides e trapézios", grupoOmbros);
        Exercicio roscaDireta = new Exercicio(null, "Rosca direta", "Isola o bíceps braquial", grupoBiceps);
        Exercicio roscaMartelo = new Exercicio(null, "Rosca martelo", "Trabalha o braquiorradial e o bíceps", grupoBiceps);
        Exercicio roscaConcentrada = new Exercicio(null, "Rosca concentrada", "Exercício de isolamento máximo para bíceps", grupoBiceps);
        Exercicio tricepsTesta = new Exercicio(null, "Tríceps testa", "Exercício para a cabeça longa do tríceps", grupoTriceps);
        Exercicio tricepsCorda = new Exercicio(null, "Tríceps corda", "Foco na cabeça lateral do tríceps", grupoTriceps);
        Exercicio mergulhoEntreBancos = new Exercicio(null, "Mergulho entre bancos", "Exercício com peso corporal para tríceps", grupoTriceps);
        Exercicio elevacaoPelvica = new Exercicio(null, "Elevação pélvica", "Trabalha os glúteos e posteriores", grupoGluteos);
        Exercicio gluteoNaPolia = new Exercicio(null, "Glúteo na polia", "Isolamento para glúteos", grupoGluteos);
        Exercicio afundoComPasso = new Exercicio(null, "Afundo com passo", "Exercício dinâmico para glúteos", grupoGluteos);
        Exercicio elevacaoPanturrilhasEmPe = new Exercicio(null, "Elevação de panturrilhas em pé", "Foco nos gastrocnêmios", grupoPanturrilhas);
        Exercicio panturrilhaNoLegPress = new Exercicio(null, "Panturrilha no leg press", "Variação para panturrilhas", grupoPanturrilhas);
        Exercicio panturrilhaSentado = new Exercicio(null, "Panturrilha sentado", "Trabalha o sóleo (porção profunda)", grupoPanturrilhas);
        Exercicio abdominalInfra = new Exercicio(null, "Abdominal infra", "Trabalha a parte inferior do abdômen", grupoAbdomen);
        Exercicio pranchaAbdominal = new Exercicio(null, "Prancha abdominal", "Trabalha toda a região do core", grupoAbdomen);
        Exercicio russianTwist = new Exercicio(null, "Russian twist", "Exercício para oblíquos e core", grupoAbdomen);
        Exercicio roscaPunho = new Exercicio(null, "Rosca punho", "Fortalece os músculos do antebraço", grupoAntebracos);
        Exercicio extensaoDePunho = new Exercicio(null, "Extensão de punho", "Isola os extensores do antebraço", grupoAntebracos);
        Exercicio apertaoDePegada = new Exercicio(null, "Apertão de pegada", "Exercício para fortalecimento geral do antebraço", grupoAntebracos);

        exercicioRepository.saveAll(Arrays.asList(supinoReto, crucifixoReto, supinoInclinadoComHalteres, puxadaFrente, remadaCurvada, barraFixa,
                agachamentoLivre, cadeiraFlexora, legPress45, desenvolvimentoComHalteres, elevacaoLateral, remadaAlta,
                roscaDireta, roscaMartelo, roscaConcentrada, tricepsTesta, tricepsCorda, mergulhoEntreBancos,
                elevacaoPelvica, gluteoNaPolia, afundoComPasso, elevacaoPanturrilhasEmPe, panturrilhaNoLegPress,
                panturrilhaSentado, abdominalInfra, pranchaAbdominal, russianTwist, roscaPunho, extensaoDePunho,
                apertaoDePegada));


        // 4. Criar treinos
        Treino treinoAvancadoA = new Treino(null, "Treino Avançado A - Peito/Tríceps", LocalDate.now());
        treinoAvancadoA.setExercicios(
                List.of(new TreinoExercicio(null, treinoAvancadoA, supinoReto, 1, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoA, roscaDireta, 2, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoA, crucifixoReto, 3, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoA, remadaCurvada, 4, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoA, tricepsTesta, 5, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoA, abdominalInfra, 6, 120, ""))
        );

        Treino treinoAvancadoB = new Treino(null, "Treino Avançado B - Costas/Bíceps", LocalDate.now());
        treinoAvancadoB.setExercicios(
                List.of(new TreinoExercicio(null, treinoAvancadoB, puxadaFrente, 1, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoB, roscaPunho, 2, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoB, remadaCurvada, 3, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoB, roscaConcentrada, 4, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoB, roscaMartelo, 5, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoB, panturrilhaSentado, 6, 120, ""))
        );

        Treino treinoAvancadoC = new Treino(null, "Treino Avançado C - Pernas/Ombros", LocalDate.now());
        treinoAvancadoC.setExercicios(
                List.of(new TreinoExercicio(null, treinoAvancadoC, agachamentoLivre, 1, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoC, remadaAlta, 2, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoC, cadeiraFlexora, 3, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoC, elevacaoLateral, 4, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoC, elevacaoPelvica, 5, 120, ""),
                        new TreinoExercicio(null, treinoAvancadoC, gluteoNaPolia, 6, 120, ""))
        );

        Treino treinoFullBodyIntensivo = new Treino(null, "Treino Full Body Intensivo", LocalDate.now());
        treinoFullBodyIntensivo.setExercicios(
                List.of(new TreinoExercicio(null, treinoFullBodyIntensivo, supinoReto, 1, 120, ""),
                        new TreinoExercicio(null, treinoFullBodyIntensivo, crucifixoReto, 2, 120, ""),
                        new TreinoExercicio(null, treinoFullBodyIntensivo, agachamentoLivre, 3, 120, ""),
                        new TreinoExercicio(null, treinoFullBodyIntensivo, cadeiraFlexora, 4, 120, ""),
                        new TreinoExercicio(null, treinoFullBodyIntensivo, tricepsCorda, 5, 120, ""),
                        new TreinoExercicio(null, treinoFullBodyIntensivo, abdominalInfra, 6, 120, ""))
        );

        Treino treinoForcaSuperior = new Treino(null, "Treino Força - Superior", LocalDate.now());
        treinoForcaSuperior.setExercicios(
                List.of(new TreinoExercicio(null, treinoForcaSuperior, supinoReto, 1, 120, ""),
                        new TreinoExercicio(null, treinoForcaSuperior, crucifixoReto, 2, 120, ""),
                        new TreinoExercicio(null, treinoForcaSuperior, elevacaoLateral, 3, 120, ""),
                        new TreinoExercicio(null, treinoForcaSuperior, remadaCurvada, 4, 120, ""),
                        new TreinoExercicio(null, treinoForcaSuperior, tricepsTesta, 5, 120, ""))
        );

        Treino treinoHipertrofiaInferior = new Treino(null, "Treino Hipertrofia - Inferior", LocalDate.now());
        treinoHipertrofiaInferior.setExercicios(
                List.of(new TreinoExercicio(null, treinoHipertrofiaInferior, agachamentoLivre, 1, 120, ""),
                        new TreinoExercicio(null, treinoHipertrofiaInferior, cadeiraFlexora, 2, 120, ""),
                        new TreinoExercicio(null, treinoHipertrofiaInferior, legPress45, 3, 120, ""),
                        new TreinoExercicio(null, treinoHipertrofiaInferior, tricepsCorda, 4, 120, ""),
                        new TreinoExercicio(null, treinoHipertrofiaInferior, afundoComPasso, 5, 120, ""),
                        new TreinoExercicio(null, treinoHipertrofiaInferior, elevacaoPanturrilhasEmPe, 6, 120, ""))
        );

        Treino treinoFuncionalCompleto = new Treino(null, "Treino Funcional Completo", LocalDate.now());
        treinoFuncionalCompleto.setExercicios(
                List.of(new TreinoExercicio(null, treinoFuncionalCompleto, agachamentoLivre, 1, 120, ""),
                        new TreinoExercicio(null, treinoFuncionalCompleto, tricepsCorda, 2, 120, ""),
                        new TreinoExercicio(null, treinoFuncionalCompleto, abdominalInfra, 3, 120, ""),
                        new TreinoExercicio(null, treinoFuncionalCompleto, roscaPunho, 4, 120, ""),
                        new TreinoExercicio(null, treinoFuncionalCompleto, roscaConcentrada, 5, 120, ""))
        );

        Treino treinoResistenciaMuscular = new Treino(null, "Treino Resistência Muscular", LocalDate.now());
        treinoResistenciaMuscular.setExercicios(
                List.of(new TreinoExercicio(null, treinoResistenciaMuscular, puxadaFrente, 1, 120, ""),
                        new TreinoExercicio(null, treinoResistenciaMuscular, supinoReto, 2, 120, ""),
                        new TreinoExercicio(null, treinoResistenciaMuscular, agachamentoLivre, 3, 120, ""),
                        new TreinoExercicio(null, treinoResistenciaMuscular, tricepsTesta, 4, 120, ""),
                        new TreinoExercicio(null, treinoResistenciaMuscular, abdominalInfra, 5, 120, ""))
        );

        Treino treinoDefinicaoABC = new Treino(null, "Treino Definição - ABC", LocalDate.now());
        treinoDefinicaoABC.setExercicios(
                List.of(new TreinoExercicio(null, treinoDefinicaoABC, supinoReto, 1, 120, ""),
                        new TreinoExercicio(null, treinoDefinicaoABC, crucifixoReto, 2, 120, ""),
                        new TreinoExercicio(null, treinoDefinicaoABC, agachamentoLivre, 3, 120, ""),
                        new TreinoExercicio(null, treinoDefinicaoABC, tricepsTesta, 4, 120, ""),
                        new TreinoExercicio(null, treinoDefinicaoABC, abdominalInfra, 5, 120, ""),
                        new TreinoExercicio(null, treinoDefinicaoABC, abdominalInfra, 6, 120, ""))
        );

        Treino treinoPreparatorioFisico = new Treino(null, "Treino Preparatório Físico", LocalDate.now());
        treinoPreparatorioFisico.setExercicios(
                List.of(new TreinoExercicio(null, treinoPreparatorioFisico, supinoReto, 1, 120, ""),
                        new TreinoExercicio(null, treinoPreparatorioFisico, crucifixoReto, 2, 120, ""),
                        new TreinoExercicio(null, treinoPreparatorioFisico, agachamentoLivre, 3, 120, ""),
                        new TreinoExercicio(null, treinoPreparatorioFisico, cadeiraFlexora, 4, 120, ""),
                        new TreinoExercicio(null, treinoPreparatorioFisico, abdominalInfra, 5, 120, ""),
                        new TreinoExercicio(null, treinoPreparatorioFisico, roscaPunho, 6, 120, ""))
        );

        treinoRepository.saveAll(Arrays.asList(treinoAvancadoA, treinoAvancadoB, treinoAvancadoC, treinoFullBodyIntensivo, treinoForcaSuperior,
                treinoHipertrofiaInferior, treinoFuncionalCompleto, treinoResistenciaMuscular, treinoDefinicaoABC, treinoPreparatorioFisico));

        System.out.println("Dados iniciais carregados com sucesso!");
    }
}
