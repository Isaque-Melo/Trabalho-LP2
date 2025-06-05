package edu.ifms.br.empresa.boot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ifms.br.empresa.boot.web.dao.DepartamentoDao;
import edu.ifms.br.empresa.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;

	@Override
	public void salvar(Departamento departamento) {
		if (departamento.getId() != null) {
			dao.update(departamento);
		} else {
			dao.save(departamento);
		}
	}

	@Override
	public void editar(Departamento cargo) {
		dao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

}
