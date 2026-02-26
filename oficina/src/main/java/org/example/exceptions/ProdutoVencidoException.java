package org.example.exceptions;

public class ProdutoVencidoException extends RuntimeException {
    public ProdutoVencidoException(String message) {
        super(message);
    }
}