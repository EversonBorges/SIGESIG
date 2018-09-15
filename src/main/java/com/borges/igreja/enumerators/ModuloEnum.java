package com.borges.igreja.enumerators;

import java.util.ArrayList;
import java.util.List;

public enum ModuloEnum {
	
Modulo_1("Modulo 1",1),
Modulo_2("Modulo 2",2),
Modulo_3("Modulo 3",3),
Modulo_4("Modulo 4",4),
Modulo_5("Modulo 5",5),
Modulo_6("Modulo 6",6);


private int valorModulo;
private String nomeModulo;

 ModuloEnum(String nome,int valor) {
	nomeModulo=nome;
	valorModulo=valor;
}

public int getValorModulo() {
	return valorModulo;
}

public String getNomeModulo() {
	return nomeModulo;
}

public static List<ModuloEnum> findAll(){
	ArrayList<ModuloEnum> lista = new ArrayList<ModuloEnum>();
	
	lista.add(ModuloEnum.Modulo_1);
	lista.add(ModuloEnum.Modulo_2);
	lista.add(ModuloEnum.Modulo_3);
	lista.add(ModuloEnum.Modulo_4);
	lista.add(ModuloEnum.Modulo_5);
	lista.add(ModuloEnum.Modulo_6);
	
	return lista;
}
}
