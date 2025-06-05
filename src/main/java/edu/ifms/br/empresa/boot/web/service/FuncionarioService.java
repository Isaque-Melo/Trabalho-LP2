package edu.ifms.br.empresa.boot.web.service;

import java.time.LocalDate;
import java.util.List;

import edu.ifms.br.empresa.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario cargo);
	void editar(Funcionario cargo);
	void excluir(Long id);
	Funcionario buscarPorId(Long id);
	List<Funcionario> buscarTodos();
	List<Funcionario> buscarPorNome(String nome);
	List<Funcionario> buscarPorCargo(Long id);
	List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);

}
