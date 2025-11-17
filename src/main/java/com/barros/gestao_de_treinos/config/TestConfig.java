package com.barros.gestao_de_treinos.config;

import com.barros.gestao_de_treinos.entities.*;
import com.barros.gestao_de_treinos.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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
    private ExecucaoTreinoRepository execucaoTreinoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() > 0) return;

        // 1. Criar usuário
        Usuario usuario1 = new Usuario(null, "Gabriel Barros", "gabriel.barros@email.com", "senha1234", LocalDate.of(2025, 10, 25));
        usuarioRepository.save(usuario1);


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

        // Treino avançado A - Peito/Tríceps
        Treino treinoAvancadoA = new Treino(null, "Treino Avançado A - Peito/Tríceps", LocalDate.now());

        TreinoExercicio treExeTreinoAvancadoA1 = new TreinoExercicio(null, treinoAvancadoA, supinoReto, 1, 120, "");
        treExeTreinoAvancadoA1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA1, 1, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoA1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA1, 2, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoA1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA1, 3, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoA1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA1, 4, 12, new BigDecimal("50.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA1);

        TreinoExercicio treExeTreinoAvancadoA2 = new TreinoExercicio(null, treinoAvancadoA, roscaDireta, 2, 120, "");
        treExeTreinoAvancadoA2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA2, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA2, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA2, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA2, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA2);

        TreinoExercicio treExeTreinoAvancadoA3 = new TreinoExercicio(null, treinoAvancadoA, crucifixoReto, 3, 120, "");
        treExeTreinoAvancadoA3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA3, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA3, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA3, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA3, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA3);

        TreinoExercicio treExeTreinoAvancadoA4 = new TreinoExercicio(null, treinoAvancadoA, remadaCurvada, 4, 120, "");
        treExeTreinoAvancadoA4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA4, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA4, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA4, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA4, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA4);

        TreinoExercicio treExeTreinoAvancadoA5 = new TreinoExercicio(null, treinoAvancadoA, tricepsTesta, 5, 120, "");
        treExeTreinoAvancadoA5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA5, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA5, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA5, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA5, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA5);

        TreinoExercicio treExeTreinoAvancadoA6 = new TreinoExercicio(null, treinoAvancadoA, abdominalInfra, 6, 120, "");
        treExeTreinoAvancadoA6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA6, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA6, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA6, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoA6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoA6, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoA.addExercicio(treExeTreinoAvancadoA6);


        // Treino Avançado B - Costas/Bíceps
        Treino treinoAvancadoB = new Treino(null, "Treino Avançado B - Costas/Bíceps", LocalDate.now());

        TreinoExercicio treExeTreinoAvancadoB1 = new TreinoExercicio(null, treinoAvancadoB, puxadaFrente, 1, 120, "");
        treExeTreinoAvancadoB1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB1, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB1, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB1, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB1, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB1);

        TreinoExercicio treExeTreinoAvancadoB2 = new TreinoExercicio(null, treinoAvancadoB, roscaPunho, 2, 120, "");
        treExeTreinoAvancadoB2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB2, 1, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB2, 2, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB2, 3, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB2, 4, 12, new BigDecimal("35.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB2);

        TreinoExercicio treExeTreinoAvancadoB3 = new TreinoExercicio(null, treinoAvancadoB, remadaCurvada, 3, 120, "");
        treExeTreinoAvancadoB3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB3, 1, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoB3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB3, 2, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoB3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB3, 3, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoB3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB3, 4, 12, new BigDecimal("45.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB3);

        TreinoExercicio treExeTreinoAvancadoB4 = new TreinoExercicio(null, treinoAvancadoB, roscaConcentrada, 4, 120, "");
        treExeTreinoAvancadoB4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB4, 1, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB4, 2, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB4, 3, 10, new BigDecimal("40.00")));
        treExeTreinoAvancadoB4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB4, 4, 10, new BigDecimal("40.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB4);

        TreinoExercicio treExeTreinoAvancadoB5 = new TreinoExercicio(null, treinoAvancadoB, roscaMartelo, 5, 120, "");
        treExeTreinoAvancadoB5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB5, 1, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB5, 2, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB5, 3, 12, new BigDecimal("35.00")));
        treExeTreinoAvancadoB5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB5, 4, 12, new BigDecimal("35.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB5);

        TreinoExercicio treExeTreinoAvancadoB6 = new TreinoExercicio(null, treinoAvancadoB, panturrilhaSentado, 6, 120, "");
        treExeTreinoAvancadoB6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB6, 1, 15, new BigDecimal("25.00")));
        treExeTreinoAvancadoB6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB6, 2, 15, new BigDecimal("25.00")));
        treExeTreinoAvancadoB6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB6, 3, 15, new BigDecimal("25.00")));
        treExeTreinoAvancadoB6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoB6, 4, 15, new BigDecimal("25.00")));
        treinoAvancadoB.addExercicio(treExeTreinoAvancadoB6);


        // Treino Avançado C - Pernas/Ombros
        Treino treinoAvancadoC = new Treino(null, "Treino Avançado C - Pernas/Ombros", LocalDate.now());

        TreinoExercicio treExeTreinoAvancadoC1 = new TreinoExercicio(null, treinoAvancadoC, agachamentoLivre, 1, 120, "");
        treExeTreinoAvancadoC1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC1, 1, 12, new BigDecimal("70.00")));
        treExeTreinoAvancadoC1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC1, 2, 12, new BigDecimal("70.00")));
        treExeTreinoAvancadoC1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC1, 3, 12, new BigDecimal("70.00")));
        treExeTreinoAvancadoC1.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC1, 4, 12, new BigDecimal("70.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC1);

        TreinoExercicio treExeTreinoAvancadoC2 = new TreinoExercicio(null, treinoAvancadoC, remadaAlta, 2, 120, "");
        treExeTreinoAvancadoC2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC2, 1, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC2, 2, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC2, 3, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC2.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC2, 4, 12, new BigDecimal("50.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC2);

        TreinoExercicio treExeTreinoAvancadoC3 = new TreinoExercicio(null, treinoAvancadoC, cadeiraFlexora, 3, 120, "");
        treExeTreinoAvancadoC3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC3, 1, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoC3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC3, 2, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoC3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC3, 3, 12, new BigDecimal("45.00")));
        treExeTreinoAvancadoC3.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC3, 4, 12, new BigDecimal("45.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC3);

        TreinoExercicio treExeTreinoAvancadoC4 = new TreinoExercicio(null, treinoAvancadoC, elevacaoLateral, 4, 120, "");
        treExeTreinoAvancadoC4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC4, 1, 12, new BigDecimal("20.00")));
        treExeTreinoAvancadoC4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC4, 2, 12, new BigDecimal("20.00")));
        treExeTreinoAvancadoC4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC4, 3, 12, new BigDecimal("20.00")));
        treExeTreinoAvancadoC4.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC4, 4, 12, new BigDecimal("20.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC4);

        TreinoExercicio treExeTreinoAvancadoC5 = new TreinoExercicio(null, treinoAvancadoC, elevacaoPelvica, 5, 120, "");
        treExeTreinoAvancadoC5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC5, 1, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC5, 2, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC5, 3, 12, new BigDecimal("50.00")));
        treExeTreinoAvancadoC5.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC5, 4, 12, new BigDecimal("50.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC5);

        TreinoExercicio treExeTreinoAvancadoC6 = new TreinoExercicio(null, treinoAvancadoC, gluteoNaPolia, 6, 120, "");
        treExeTreinoAvancadoC6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC6, 1, 12, new BigDecimal("40.00")));
        treExeTreinoAvancadoC6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC6, 2, 12, new BigDecimal("40.00")));
        treExeTreinoAvancadoC6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC6, 3, 12, new BigDecimal("40.00")));
        treExeTreinoAvancadoC6.addSerie(new ExercicioSerie(null, treExeTreinoAvancadoC6, 4, 12, new BigDecimal("40.00")));
        treinoAvancadoC.addExercicio(treExeTreinoAvancadoC6);


        // Treino Full Body Intensivo
        Treino treinoFullBodyIntensivo = new Treino(null, "Treino Full Body Intensivo", LocalDate.now());

        TreinoExercicio treExeTreinoFullBodyIntensivo1 = new TreinoExercicio(null, treinoFullBodyIntensivo, supinoReto, 1, 120, "");
        treExeTreinoFullBodyIntensivo1.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo1, 1, 12, new BigDecimal("60.00")));
        treExeTreinoFullBodyIntensivo1.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo1, 2, 12, new BigDecimal("60.00")));
        treExeTreinoFullBodyIntensivo1.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo1, 3, 12, new BigDecimal("60.00")));
        treExeTreinoFullBodyIntensivo1.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo1, 4, 12, new BigDecimal("60.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo1);

        TreinoExercicio treExeTreinoFullBodyIntensivo2 = new TreinoExercicio(null, treinoFullBodyIntensivo, crucifixoReto, 2, 120, "");
        treExeTreinoFullBodyIntensivo2.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo2, 1, 12, new BigDecimal("45.00")));
        treExeTreinoFullBodyIntensivo2.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo2, 2, 12, new BigDecimal("45.00")));
        treExeTreinoFullBodyIntensivo2.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo2, 3, 12, new BigDecimal("45.00")));
        treExeTreinoFullBodyIntensivo2.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo2, 4, 12, new BigDecimal("45.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo2);

        TreinoExercicio treExeTreinoFullBodyIntensivo3 = new TreinoExercicio(null, treinoFullBodyIntensivo, agachamentoLivre, 3, 120, "");
        treExeTreinoFullBodyIntensivo3.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo3, 1, 12, new BigDecimal("80.00")));
        treExeTreinoFullBodyIntensivo3.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo3, 2, 12, new BigDecimal("80.00")));
        treExeTreinoFullBodyIntensivo3.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo3, 3, 12, new BigDecimal("80.00")));
        treExeTreinoFullBodyIntensivo3.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo3, 4, 12, new BigDecimal("80.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo3);

        TreinoExercicio treExeTreinoFullBodyIntensivo4 = new TreinoExercicio(null, treinoFullBodyIntensivo, cadeiraFlexora, 4, 120, "");
        treExeTreinoFullBodyIntensivo4.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo4, 1, 12, new BigDecimal("50.00")));
        treExeTreinoFullBodyIntensivo4.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo4, 2, 12, new BigDecimal("50.00")));
        treExeTreinoFullBodyIntensivo4.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo4, 3, 12, new BigDecimal("50.00")));
        treExeTreinoFullBodyIntensivo4.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo4, 4, 12, new BigDecimal("50.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo4);

        TreinoExercicio treExeTreinoFullBodyIntensivo5 = new TreinoExercicio(null, treinoFullBodyIntensivo, tricepsCorda, 5, 120, "");
        treExeTreinoFullBodyIntensivo5.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo5, 1, 12, new BigDecimal("35.00")));
        treExeTreinoFullBodyIntensivo5.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo5, 2, 12, new BigDecimal("35.00")));
        treExeTreinoFullBodyIntensivo5.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo5, 3, 12, new BigDecimal("35.00")));
        treExeTreinoFullBodyIntensivo5.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo5, 4, 12, new BigDecimal("35.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo5);

        TreinoExercicio treExeTreinoFullBodyIntensivo6 = new TreinoExercicio(null, treinoFullBodyIntensivo, abdominalInfra, 6, 120, "");
        treExeTreinoFullBodyIntensivo6.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo6, 1, 15, new BigDecimal("20.00")));
        treExeTreinoFullBodyIntensivo6.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo6, 2, 15, new BigDecimal("20.00")));
        treExeTreinoFullBodyIntensivo6.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo6, 3, 15, new BigDecimal("20.00")));
        treExeTreinoFullBodyIntensivo6.addSerie(new ExercicioSerie(null, treExeTreinoFullBodyIntensivo6, 4, 15, new BigDecimal("20.00")));
        treinoFullBodyIntensivo.addExercicio(treExeTreinoFullBodyIntensivo6);


        // Treino Força Superior
        Treino treinoForcaSuperior = new Treino(null, "Treino Força - Superior", LocalDate.now());

        TreinoExercicio treExeTreinoForcaSuperior1 = new TreinoExercicio(null, treinoForcaSuperior, supinoReto, 1, 120, "");
        treExeTreinoForcaSuperior1.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior1, 1, 6, new BigDecimal("80.00")));
        treExeTreinoForcaSuperior1.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior1, 2, 6, new BigDecimal("80.00")));
        treExeTreinoForcaSuperior1.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior1, 3, 6, new BigDecimal("80.00")));
        treExeTreinoForcaSuperior1.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior1, 4, 6, new BigDecimal("80.00")));
        treinoForcaSuperior.addExercicio(treExeTreinoForcaSuperior1);

        TreinoExercicio treExeTreinoForcaSuperior2 = new TreinoExercicio(null, treinoForcaSuperior, crucifixoReto, 2, 120, "");
        treExeTreinoForcaSuperior2.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior2, 1, 8, new BigDecimal("45.00")));
        treExeTreinoForcaSuperior2.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior2, 2, 8, new BigDecimal("45.00")));
        treExeTreinoForcaSuperior2.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior2, 3, 8, new BigDecimal("45.00")));
        treExeTreinoForcaSuperior2.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior2, 4, 8, new BigDecimal("45.00")));
        treinoForcaSuperior.addExercicio(treExeTreinoForcaSuperior2);

        TreinoExercicio treExeTreinoForcaSuperior3 = new TreinoExercicio(null, treinoForcaSuperior, elevacaoLateral, 3, 120, "");
        treExeTreinoForcaSuperior3.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior3, 1, 12, new BigDecimal("18.00")));
        treExeTreinoForcaSuperior3.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior3, 2, 12, new BigDecimal("18.00")));
        treExeTreinoForcaSuperior3.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior3, 3, 12, new BigDecimal("18.00")));
        treExeTreinoForcaSuperior3.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior3, 4, 12, new BigDecimal("18.00")));
        treinoForcaSuperior.addExercicio(treExeTreinoForcaSuperior3);

        TreinoExercicio treExeTreinoForcaSuperior4 = new TreinoExercicio(null, treinoForcaSuperior, remadaCurvada, 4, 120, "");
        treExeTreinoForcaSuperior4.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior4, 1, 8, new BigDecimal("60.00")));
        treExeTreinoForcaSuperior4.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior4, 2, 8, new BigDecimal("60.00")));
        treExeTreinoForcaSuperior4.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior4, 3, 8, new BigDecimal("60.00")));
        treExeTreinoForcaSuperior4.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior4, 4, 8, new BigDecimal("60.00")));
        treinoForcaSuperior.addExercicio(treExeTreinoForcaSuperior4);

        TreinoExercicio treExeTreinoForcaSuperior5 = new TreinoExercicio(null, treinoForcaSuperior, tricepsTesta, 5, 120, "");
        treExeTreinoForcaSuperior5.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior5, 1, 10, new BigDecimal("40.00")));
        treExeTreinoForcaSuperior5.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior5, 2, 10, new BigDecimal("40.00")));
        treExeTreinoForcaSuperior5.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior5, 3, 10, new BigDecimal("40.00")));
        treExeTreinoForcaSuperior5.addSerie(new ExercicioSerie(null, treExeTreinoForcaSuperior5, 4, 10, new BigDecimal("40.00")));
        treinoForcaSuperior.addExercicio(treExeTreinoForcaSuperior5);


        // Treino Hipertrofia Inferior
        Treino treinoHipertrofiaInferior = new Treino(null, "Treino Hipertrofia - Inferior", LocalDate.now());

        TreinoExercicio treExeTreinoHipertrofiaInferior1 = new TreinoExercicio(null, treinoHipertrofiaInferior, agachamentoLivre, 1, 120, "");
        treExeTreinoHipertrofiaInferior1.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior1, 1, 10, new BigDecimal("90.00")));
        treExeTreinoHipertrofiaInferior1.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior1, 2, 10, new BigDecimal("90.00")));
        treExeTreinoHipertrofiaInferior1.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior1, 3, 10, new BigDecimal("90.00")));
        treExeTreinoHipertrofiaInferior1.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior1, 4, 10, new BigDecimal("90.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior1);

        TreinoExercicio treExeTreinoHipertrofiaInferior2 = new TreinoExercicio(null, treinoHipertrofiaInferior, cadeiraFlexora, 2, 120, "");
        treExeTreinoHipertrofiaInferior2.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior2, 1, 12, new BigDecimal("50.00")));
        treExeTreinoHipertrofiaInferior2.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior2, 2, 12, new BigDecimal("50.00")));
        treExeTreinoHipertrofiaInferior2.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior2, 3, 12, new BigDecimal("50.00")));
        treExeTreinoHipertrofiaInferior2.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior2, 4, 12, new BigDecimal("50.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior2);

        TreinoExercicio treExeTreinoHipertrofiaInferior3 = new TreinoExercicio(null, treinoHipertrofiaInferior, legPress45, 3, 120, "");
        treExeTreinoHipertrofiaInferior3.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior3, 1, 10, new BigDecimal("100.00")));
        treExeTreinoHipertrofiaInferior3.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior3, 2, 10, new BigDecimal("100.00")));
        treExeTreinoHipertrofiaInferior3.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior3, 3, 10, new BigDecimal("100.00")));
        treExeTreinoHipertrofiaInferior3.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior3, 4, 10, new BigDecimal("100.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior3);

        TreinoExercicio treExeTreinoHipertrofiaInferior4 = new TreinoExercicio(null, treinoHipertrofiaInferior, tricepsCorda, 4, 120, "");
        treExeTreinoHipertrofiaInferior4.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior4, 1, 12, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior4.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior4, 2, 12, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior4.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior4, 3, 12, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior4.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior4, 4, 12, new BigDecimal("40.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior4);

        TreinoExercicio treExeTreinoHipertrofiaInferior5 = new TreinoExercicio(null, treinoHipertrofiaInferior, afundoComPasso, 5, 120, "");
        treExeTreinoHipertrofiaInferior5.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior5, 1, 12, new BigDecimal("25.00")));
        treExeTreinoHipertrofiaInferior5.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior5, 2, 12, new BigDecimal("25.00")));
        treExeTreinoHipertrofiaInferior5.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior5, 3, 12, new BigDecimal("25.00")));
        treExeTreinoHipertrofiaInferior5.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior5, 4, 12, new BigDecimal("25.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior5);

        TreinoExercicio treExeTreinoHipertrofiaInferior6 = new TreinoExercicio(null, treinoHipertrofiaInferior, elevacaoPanturrilhasEmPe, 6, 120, "");
        treExeTreinoHipertrofiaInferior6.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior6, 1, 15, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior6.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior6, 2, 15, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior6.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior6, 3, 15, new BigDecimal("40.00")));
        treExeTreinoHipertrofiaInferior6.addSerie(new ExercicioSerie(null, treExeTreinoHipertrofiaInferior6, 4, 15, new BigDecimal("40.00")));
        treinoHipertrofiaInferior.addExercicio(treExeTreinoHipertrofiaInferior6);


        // Treino Funcional Completo
        Treino treinoFuncionalCompleto = new Treino(null, "Treino Funcional Completo", LocalDate.now());

        TreinoExercicio treExeTreinoFuncionalCompleto1 = new TreinoExercicio(null, treinoFuncionalCompleto, agachamentoLivre, 1, 120, "");
        treExeTreinoFuncionalCompleto1.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto1, 1, 15, new BigDecimal("80.00")));
        treExeTreinoFuncionalCompleto1.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto1, 2, 15, new BigDecimal("80.00")));
        treExeTreinoFuncionalCompleto1.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto1, 3, 15, new BigDecimal("80.00")));
        treExeTreinoFuncionalCompleto1.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto1, 4, 15, new BigDecimal("80.00")));
        treinoFuncionalCompleto.addExercicio(treExeTreinoFuncionalCompleto1);

        TreinoExercicio treExeTreinoFuncionalCompleto2 = new TreinoExercicio(null, treinoFuncionalCompleto, tricepsCorda, 2, 120, "");
        treExeTreinoFuncionalCompleto2.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto2, 1, 12, new BigDecimal("40.00")));
        treExeTreinoFuncionalCompleto2.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto2, 2, 12, new BigDecimal("40.00")));
        treExeTreinoFuncionalCompleto2.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto2, 3, 12, new BigDecimal("40.00")));
        treExeTreinoFuncionalCompleto2.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto2, 4, 12, new BigDecimal("40.00")));
        treinoFuncionalCompleto.addExercicio(treExeTreinoFuncionalCompleto2);

        TreinoExercicio treExeTreinoFuncionalCompleto3 = new TreinoExercicio(null, treinoFuncionalCompleto, abdominalInfra, 3, 120, "");
        treExeTreinoFuncionalCompleto3.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto3, 1, 15, new BigDecimal("20.00")));
        treExeTreinoFuncionalCompleto3.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto3, 2, 15, new BigDecimal("20.00")));
        treExeTreinoFuncionalCompleto3.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto3, 3, 15, new BigDecimal("20.00")));
        treExeTreinoFuncionalCompleto3.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto3, 4, 15, new BigDecimal("20.00")));
        treinoFuncionalCompleto.addExercicio(treExeTreinoFuncionalCompleto3);

        TreinoExercicio treExeTreinoFuncionalCompleto4 = new TreinoExercicio(null, treinoFuncionalCompleto, roscaPunho, 4, 120, "");
        treExeTreinoFuncionalCompleto4.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto4, 1, 15, new BigDecimal("15.00")));
        treExeTreinoFuncionalCompleto4.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto4, 2, 15, new BigDecimal("15.00")));
        treExeTreinoFuncionalCompleto4.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto4, 3, 15, new BigDecimal("15.00")));
        treExeTreinoFuncionalCompleto4.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto4, 4, 15, new BigDecimal("15.00")));
        treinoFuncionalCompleto.addExercicio(treExeTreinoFuncionalCompleto4);

        TreinoExercicio treExeTreinoFuncionalCompleto5 = new TreinoExercicio(null, treinoFuncionalCompleto, roscaConcentrada, 5, 120, "");
        treExeTreinoFuncionalCompleto5.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto5, 1, 10, new BigDecimal("35.00")));
        treExeTreinoFuncionalCompleto5.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto5, 2, 10, new BigDecimal("35.00")));
        treExeTreinoFuncionalCompleto5.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto5, 3, 10, new BigDecimal("35.00")));
        treExeTreinoFuncionalCompleto5.addSerie(new ExercicioSerie(null, treExeTreinoFuncionalCompleto5, 4, 10, new BigDecimal("35.00")));
        treinoFuncionalCompleto.addExercicio(treExeTreinoFuncionalCompleto5);


        // Treino Resistência Muscular
        Treino treinoResistenciaMuscular = new Treino(null, "Treino Resistência Muscular", LocalDate.now());

        TreinoExercicio treExeTreinoResistenciaMuscular1 = new TreinoExercicio(null, treinoResistenciaMuscular, puxadaFrente, 1, 120, "");
        treExeTreinoResistenciaMuscular1.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular1, 1, 12, new BigDecimal("45.00")));
        treExeTreinoResistenciaMuscular1.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular1, 2, 12, new BigDecimal("45.00")));
        treExeTreinoResistenciaMuscular1.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular1, 3, 12, new BigDecimal("45.00")));
        treExeTreinoResistenciaMuscular1.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular1, 4, 12, new BigDecimal("45.00")));
        treinoResistenciaMuscular.addExercicio(treExeTreinoResistenciaMuscular1);

        TreinoExercicio treExeTreinoResistenciaMuscular2 = new TreinoExercicio(null, treinoResistenciaMuscular, supinoReto, 2, 120, "");
        treExeTreinoResistenciaMuscular2.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular2, 1, 10, new BigDecimal("50.00")));
        treExeTreinoResistenciaMuscular2.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular2, 2, 10, new BigDecimal("50.00")));
        treExeTreinoResistenciaMuscular2.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular2, 3, 10, new BigDecimal("50.00")));
        treExeTreinoResistenciaMuscular2.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular2, 4, 10, new BigDecimal("50.00")));
        treinoResistenciaMuscular.addExercicio(treExeTreinoResistenciaMuscular2);

        TreinoExercicio treExeTreinoResistenciaMuscular3 = new TreinoExercicio(null, treinoResistenciaMuscular, agachamentoLivre, 3, 120, "");
        treExeTreinoResistenciaMuscular3.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular3, 1, 12, new BigDecimal("70.00")));
        treExeTreinoResistenciaMuscular3.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular3, 2, 12, new BigDecimal("70.00")));
        treExeTreinoResistenciaMuscular3.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular3, 3, 12, new BigDecimal("70.00")));
        treExeTreinoResistenciaMuscular3.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular3, 4, 12, new BigDecimal("70.00")));
        treinoResistenciaMuscular.addExercicio(treExeTreinoResistenciaMuscular3);

        TreinoExercicio treExeTreinoResistenciaMuscular4 = new TreinoExercicio(null, treinoResistenciaMuscular, tricepsTesta, 4, 120, "");
        treExeTreinoResistenciaMuscular4.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular4, 1, 12, new BigDecimal("35.00")));
        treExeTreinoResistenciaMuscular4.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular4, 2, 12, new BigDecimal("35.00")));
        treExeTreinoResistenciaMuscular4.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular4, 3, 12, new BigDecimal("35.00")));
        treExeTreinoResistenciaMuscular4.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular4, 4, 12, new BigDecimal("35.00")));
        treinoResistenciaMuscular.addExercicio(treExeTreinoResistenciaMuscular4);

        TreinoExercicio treExeTreinoResistenciaMuscular5 = new TreinoExercicio(null, treinoResistenciaMuscular, abdominalInfra, 5, 120, "");
        treExeTreinoResistenciaMuscular5.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular5, 1, 15, new BigDecimal("20.00")));
        treExeTreinoResistenciaMuscular5.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular5, 2, 15, new BigDecimal("20.00")));
        treExeTreinoResistenciaMuscular5.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular5, 3, 15, new BigDecimal("20.00")));
        treExeTreinoResistenciaMuscular5.addSerie(new ExercicioSerie(null, treExeTreinoResistenciaMuscular5, 4, 15, new BigDecimal("20.00")));
        treinoResistenciaMuscular.addExercicio(treExeTreinoResistenciaMuscular5);


        // Treino Definição - ABC
        Treino treinoDefinicaoABC = new Treino(null, "Treino Definição - ABC", LocalDate.now());

        TreinoExercicio treExeTreinoDefinicaoABC1 = new TreinoExercicio(null, treinoDefinicaoABC, supinoReto, 1, 120, "");
        treExeTreinoDefinicaoABC1.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC1, 1, 12, new BigDecimal("50.00")));
        treExeTreinoDefinicaoABC1.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC1, 2, 12, new BigDecimal("50.00")));
        treExeTreinoDefinicaoABC1.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC1, 3, 12, new BigDecimal("50.00")));
        treExeTreinoDefinicaoABC1.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC1, 4, 12, new BigDecimal("50.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC1);

        TreinoExercicio treExeTreinoDefinicaoABC2 = new TreinoExercicio(null, treinoDefinicaoABC, crucifixoReto, 2, 120, "");
        treExeTreinoDefinicaoABC2.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC2, 1, 12, new BigDecimal("40.00")));
        treExeTreinoDefinicaoABC2.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC2, 2, 12, new BigDecimal("40.00")));
        treExeTreinoDefinicaoABC2.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC2, 3, 12, new BigDecimal("40.00")));
        treExeTreinoDefinicaoABC2.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC2, 4, 12, new BigDecimal("40.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC2);

        TreinoExercicio treExeTreinoDefinicaoABC3 = new TreinoExercicio(null, treinoDefinicaoABC, agachamentoLivre, 3, 120, "");
        treExeTreinoDefinicaoABC3.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC3, 1, 12, new BigDecimal("70.00")));
        treExeTreinoDefinicaoABC3.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC3, 2, 12, new BigDecimal("70.00")));
        treExeTreinoDefinicaoABC3.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC3, 3, 12, new BigDecimal("70.00")));
        treExeTreinoDefinicaoABC3.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC3, 4, 12, new BigDecimal("70.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC3);

        TreinoExercicio treExeTreinoDefinicaoABC4 = new TreinoExercicio(null, treinoDefinicaoABC, tricepsTesta, 4, 120, "");
        treExeTreinoDefinicaoABC4.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC4, 1, 12, new BigDecimal("35.00")));
        treExeTreinoDefinicaoABC4.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC4, 2, 12, new BigDecimal("35.00")));
        treExeTreinoDefinicaoABC4.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC4, 3, 12, new BigDecimal("35.00")));
        treExeTreinoDefinicaoABC4.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC4, 4, 12, new BigDecimal("35.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC4);

        TreinoExercicio treExeTreinoDefinicaoABC5 = new TreinoExercicio(null, treinoDefinicaoABC, abdominalInfra, 5, 120, "");
        treExeTreinoDefinicaoABC5.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC5, 1, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC5.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC5, 2, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC5.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC5, 3, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC5.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC5, 4, 15, new BigDecimal("20.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC5);

        TreinoExercicio treExeTreinoDefinicaoABC6 = new TreinoExercicio(null, treinoDefinicaoABC, abdominalInfra, 6, 120, "");
        treExeTreinoDefinicaoABC6.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC6, 1, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC6.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC6, 2, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC6.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC6, 3, 15, new BigDecimal("20.00")));
        treExeTreinoDefinicaoABC6.addSerie(new ExercicioSerie(null, treExeTreinoDefinicaoABC6, 4, 15, new BigDecimal("20.00")));
        treinoDefinicaoABC.addExercicio(treExeTreinoDefinicaoABC6);


        // Treino Preparatório Físico
        Treino treinoPreparatorioFisico = new Treino(null, "Treino Preparatório Físico", LocalDate.now());

        TreinoExercicio treExeTreinoPreparatorioFisico1 = new TreinoExercicio(null, treinoPreparatorioFisico, supinoReto, 1, 120, "");
        treExeTreinoPreparatorioFisico1.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico1, 1, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico1.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico1, 2, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico1.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico1, 3, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico1.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico1, 4, 12, new BigDecimal("50.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico1);

        TreinoExercicio treExeTreinoPreparatorioFisico2 = new TreinoExercicio(null, treinoPreparatorioFisico, crucifixoReto, 2, 120, "");
        treExeTreinoPreparatorioFisico2.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico2, 1, 12, new BigDecimal("40.00")));
        treExeTreinoPreparatorioFisico2.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico2, 2, 12, new BigDecimal("40.00")));
        treExeTreinoPreparatorioFisico2.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico2, 3, 12, new BigDecimal("40.00")));
        treExeTreinoPreparatorioFisico2.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico2, 4, 12, new BigDecimal("40.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico2);

        TreinoExercicio treExeTreinoPreparatorioFisico3 = new TreinoExercicio(null, treinoPreparatorioFisico, agachamentoLivre, 3, 120, "");
        treExeTreinoPreparatorioFisico3.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico3, 1, 12, new BigDecimal("70.00")));
        treExeTreinoPreparatorioFisico3.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico3, 2, 12, new BigDecimal("70.00")));
        treExeTreinoPreparatorioFisico3.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico3, 3, 12, new BigDecimal("70.00")));
        treExeTreinoPreparatorioFisico3.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico3, 4, 12, new BigDecimal("70.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico3);

        TreinoExercicio treExeTreinoPreparatorioFisico4 = new TreinoExercicio(null, treinoPreparatorioFisico, cadeiraFlexora, 4, 120, "");
        treExeTreinoPreparatorioFisico4.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico4, 1, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico4.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico4, 2, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico4.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico4, 3, 12, new BigDecimal("50.00")));
        treExeTreinoPreparatorioFisico4.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico4, 4, 12, new BigDecimal("50.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico4);

        TreinoExercicio treExeTreinoPreparatorioFisico5 = new TreinoExercicio(null, treinoPreparatorioFisico, abdominalInfra, 5, 120, "");
        treExeTreinoPreparatorioFisico5.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico5, 1, 15, new BigDecimal("20.00")));
        treExeTreinoPreparatorioFisico5.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico5, 2, 15, new BigDecimal("20.00")));
        treExeTreinoPreparatorioFisico5.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico5, 3, 15, new BigDecimal("20.00")));
        treExeTreinoPreparatorioFisico5.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico5, 4, 15, new BigDecimal("20.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico5);

        TreinoExercicio treExeTreinoPreparatorioFisico6 = new TreinoExercicio(null, treinoPreparatorioFisico, roscaPunho, 6, 120, "");
        treExeTreinoPreparatorioFisico6.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico6, 1, 15, new BigDecimal("15.00")));
        treExeTreinoPreparatorioFisico6.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico6, 2, 15, new BigDecimal("15.00")));
        treExeTreinoPreparatorioFisico6.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico6, 3, 15, new BigDecimal("15.00")));
        treExeTreinoPreparatorioFisico6.addSerie(new ExercicioSerie(null, treExeTreinoPreparatorioFisico6, 4, 15, new BigDecimal("15.00")));
        treinoPreparatorioFisico.addExercicio(treExeTreinoPreparatorioFisico6);

        treinoRepository.saveAll(Arrays.asList(treinoAvancadoA, treinoAvancadoB, treinoAvancadoC, treinoFullBodyIntensivo, treinoForcaSuperior,
                treinoHipertrofiaInferior, treinoFuncionalCompleto, treinoResistenciaMuscular, treinoDefinicaoABC, treinoPreparatorioFisico));


        // Execuções de treino

        // Treino avançado A - Peito/Tríceps
        ExecucaoTreino execTreinoAvancadoA = new ExecucaoTreino(null, "Treino Avançado A - Peito/Tríceps", LocalDateTime.now());

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA1 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, supinoReto, 1, 120, "");
        execTreExeTreinoAvancadoA1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA1, 1, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoA1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA1, 2, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoA1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA1, 3, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoA1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA1, 4, 12, new BigDecimal("50.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA1);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA2 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, roscaDireta, 2, 120, "");
        execTreExeTreinoAvancadoA2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA2, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA2, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA2, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA2, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA2);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA3 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, crucifixoReto, 3, 120, "");
        execTreExeTreinoAvancadoA3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA3, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA3, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA3, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA3, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA3);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA4 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, remadaCurvada, 4, 120, "");
        execTreExeTreinoAvancadoA4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA4, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA4, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA4, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA4, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA4);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA5 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, tricepsTesta, 5, 120, "");
        execTreExeTreinoAvancadoA5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA5, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA5, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA5, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA5, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA5);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoA6 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoA, abdominalInfra, 6, 120, "");
        execTreExeTreinoAvancadoA6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA6, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA6, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA6, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoA6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoA6, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoA.addExercicio(execTreExeTreinoAvancadoA6);


        // Treino Avançado B - Costas/Bíceps
        ExecucaoTreino execTreinoAvancadoB = new ExecucaoTreino(null, "Treino Avançado B - Costas/Bíceps", LocalDateTime.now());

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB1 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, puxadaFrente, 1, 120, "");
        execTreExeTreinoAvancadoB1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB1, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB1, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB1, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB1, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB1);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB2 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, roscaPunho, 2, 120, "");
        execTreExeTreinoAvancadoB2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB2, 1, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB2, 2, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB2, 3, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB2, 4, 12, new BigDecimal("35.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB2);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB3 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, remadaCurvada, 3, 120, "");
        execTreExeTreinoAvancadoB3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB3, 1, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoB3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB3, 2, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoB3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB3, 3, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoB3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB3, 4, 12, new BigDecimal("45.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB3);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB4 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, roscaConcentrada, 4, 120, "");
        execTreExeTreinoAvancadoB4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB4, 1, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB4, 2, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB4, 3, 10, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoB4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB4, 4, 10, new BigDecimal("40.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB4);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB5 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, roscaMartelo, 5, 120, "");
        execTreExeTreinoAvancadoB5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB5, 1, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB5, 2, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB5, 3, 12, new BigDecimal("35.00")));
        execTreExeTreinoAvancadoB5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB5, 4, 12, new BigDecimal("35.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB5);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoB6 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoB, panturrilhaSentado, 6, 120, "");
        execTreExeTreinoAvancadoB6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB6, 1, 15, new BigDecimal("25.00")));
        execTreExeTreinoAvancadoB6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB6, 2, 15, new BigDecimal("25.00")));
        execTreExeTreinoAvancadoB6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB6, 3, 15, new BigDecimal("25.00")));
        execTreExeTreinoAvancadoB6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoB6, 4, 15, new BigDecimal("25.00")));
        execTreinoAvancadoB.addExercicio(execTreExeTreinoAvancadoB6);


        // Treino Avançado C - Pernas/Ombros
        ExecucaoTreino execTreinoAvancadoC = new ExecucaoTreino(null, "Treino Avançado C - Pernas/Ombros", LocalDateTime.now());

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC1 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, agachamentoLivre, 1, 120, "");
        execTreExeTreinoAvancadoC1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC1, 1, 12, new BigDecimal("70.00")));
        execTreExeTreinoAvancadoC1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC1, 2, 12, new BigDecimal("70.00")));
        execTreExeTreinoAvancadoC1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC1, 3, 12, new BigDecimal("70.00")));
        execTreExeTreinoAvancadoC1.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC1, 4, 12, new BigDecimal("70.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC1);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC2 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, remadaAlta, 2, 120, "");
        execTreExeTreinoAvancadoC2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC2, 1, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC2, 2, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC2, 3, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC2.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC2, 4, 12, new BigDecimal("50.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC2);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC3 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, cadeiraFlexora, 3, 120, "");
        execTreExeTreinoAvancadoC3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC3, 1, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoC3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC3, 2, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoC3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC3, 3, 12, new BigDecimal("45.00")));
        execTreExeTreinoAvancadoC3.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC3, 4, 12, new BigDecimal("45.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC3);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC4 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, elevacaoLateral, 4, 120, "");
        execTreExeTreinoAvancadoC4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC4, 1, 12, new BigDecimal("20.00")));
        execTreExeTreinoAvancadoC4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC4, 2, 12, new BigDecimal("20.00")));
        execTreExeTreinoAvancadoC4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC4, 3, 12, new BigDecimal("20.00")));
        execTreExeTreinoAvancadoC4.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC4, 4, 12, new BigDecimal("20.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC4);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC5 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, elevacaoPelvica, 5, 120, "");
        execTreExeTreinoAvancadoC5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC5, 1, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC5, 2, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC5, 3, 12, new BigDecimal("50.00")));
        execTreExeTreinoAvancadoC5.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC5, 4, 12, new BigDecimal("50.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC5);

        ExecucaoTreinoExercicio execTreExeTreinoAvancadoC6 = new ExecucaoTreinoExercicio(null, execTreinoAvancadoC, gluteoNaPolia, 6, 120, "");
        execTreExeTreinoAvancadoC6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC6, 1, 12, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoC6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC6, 2, 12, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoC6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC6, 3, 12, new BigDecimal("40.00")));
        execTreExeTreinoAvancadoC6.addSerie(new ExecucaoExercicioSerie(null, execTreExeTreinoAvancadoC6, 4, 12, new BigDecimal("40.00")));
        execTreinoAvancadoC.addExercicio(execTreExeTreinoAvancadoC6);

        execucaoTreinoRepository.saveAll(Arrays.asList(execTreinoAvancadoA, execTreinoAvancadoB, execTreinoAvancadoC));

        System.out.println("Dados iniciais carregados com sucesso!");
    }
}
