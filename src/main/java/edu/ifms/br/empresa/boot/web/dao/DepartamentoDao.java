package edu.ifms.br.empresa.boot.web.dao;

import java.util.List;

import edu.ifms.br.empresa.domain.Departamento;

public interface DepartamentoDao {

	void save(Departamento departamento);
	void update(Departamento departamento);
	void delete(Long id);
	Departamento findById(Long id);
	List<Departamento> findAll();
}
