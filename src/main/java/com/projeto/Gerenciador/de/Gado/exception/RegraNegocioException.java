package com.projeto.Gerenciador.de.Gado.exception;

public class RegraNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegraNegocioException (String campo, String mensagem) {
		super("[\n  {\n    campo: "+ campo + ",\n    messagem: " + mensagem + "\n  }\n]");
	}
}
