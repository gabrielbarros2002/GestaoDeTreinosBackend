package com.barros.gestao_de_treinos.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. Id = " + id);
    }
}
