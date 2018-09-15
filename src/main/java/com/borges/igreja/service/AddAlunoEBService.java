package com.borges.igreja.service;

import java.util.List;


import com.borges.igreja.model.AddAlunoEB;
import com.borges.igreja.model.EscolaBiblica;


public interface AddAlunoEBService {
	
	List<AddAlunoEB> listAluno(EscolaBiblica escolaBiblica);	
}
