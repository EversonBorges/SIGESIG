package com.borges.igreja.enumerators;

public enum OperacaoSaida {
	
	ALUGUEL(1),
	AGUA(2),
	ENERGIA(3),
	OUTROS(4);
	
	public int valorOperacao;
	
	private OperacaoSaida(int valor) {
		valorOperacao=valor;
	}

}
