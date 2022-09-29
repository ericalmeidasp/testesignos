package org.example;

public class SignoNaoEncontradoException extends RuntimeException {
    public SignoNaoEncontradoException() {
        this("Signo não encontrado");
    }

    public SignoNaoEncontradoException(String message) {
        super(message);
    }
}
