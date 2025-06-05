package edu.ifms.br.empresa.boot.web.service;

import java.util.List;

import edu.ifms.br.empresa.domain.Departamento;


public interface DepartamentoService {
	void salvar(Departamento cargo);
	void editar(Departamento cargo);
	void excluir(Long id);
	Departamento buscarPorId(Long id);
	List<Departamento> buscarTodos();

}
