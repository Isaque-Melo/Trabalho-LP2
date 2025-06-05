package edu.ifms.br.empresa.boot.web.service;

import java.util.List;

import edu.ifms.br.empresa.domain.Cargo;


public interface CargoService {

	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	void excluir(Long id);
	Cargo buscarPorId(Long id);
	List<Cargo> buscarTodos();
}
