package edu.ifms.br.empresa.boot.web.dao;

import java.util.List;


import edu.ifms.br.empresa.domain.Funcionario;
public interface FuncionarioDao {
	
	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	Funcionario findById(Long id);
	List<Funcionario> findAll();

}
