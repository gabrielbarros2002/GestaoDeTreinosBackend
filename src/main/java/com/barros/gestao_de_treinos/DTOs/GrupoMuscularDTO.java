package com.barros.gestao_de_treinos.DTOs;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class GrupoMuscularDTO {

    private Long id;
    private String nome;

    public GrupoMuscularDTO() {
        iniciarAtributosEmBranco(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
