package com.borges.igreja.util;

public class Message {
	
	private static String msgDeleteError = "Não é possivel Excluir ! Motivo dependência. ";

	private static String msgSucessoCadastrar = "Cadastrado com Sucesso !";
	
	private static String msgSucessoAdicionar= "Adicionado com Sucesso !";
	
	private static String msgDeleteSucesso = "Removido com Sucesso !";
	
	private static String msgEditado = "Editado com Sucesso !";
	
	private static String buscaCpf = "Dados já Cadastrados !";

	public static String getMsgEditado() {
		return msgEditado;
	}

	public static String getMsgDeleteSucesso() {
		return msgDeleteSucesso;
	}

	public static String getMsgDeleteError() {
		return msgDeleteError;
	}

	public static String getMsgSucessoCadastrar() {
		return msgSucessoCadastrar;
	}

	public static String getMsgSucessoAdicionar() {
		return msgSucessoAdicionar;
	}

	public static String getBuscaCpf() {
		return buscaCpf;
	}
	
}
