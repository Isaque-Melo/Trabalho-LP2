package edu.ifms.br.empresa.boot.web.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ifms.br.empresa.boot.web.dao.FuncionarioDao;
import edu.ifms.br.empresa.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;

	@Override
	public void salvar(Funcionario cargo) {
		dao.save(cargo);

	}

	@Override
	public void editar(Funcionario cargo) {
		dao.update(cargo);

	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorCargo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		return null;
	}

}
