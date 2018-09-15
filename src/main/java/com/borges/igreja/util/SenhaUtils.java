package com.borges.igreja.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
	/**
	* Gera um hash utilizando o BCrypt.
	*
	* @param senha
	* @return String
	*/
	public static String gerarBCrypt(String senha){
		if (senha ==null){
			return senha;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	/**
	 * VERIFICA SE A SENHA É VÁLIDA
	 * @param senha
	 * @param senhaEncoded
	 * @return boolean
	 */
	public static boolean senhaValida(String senha, String senhaEncoded){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senha,senhaEncoded);
	}
}
