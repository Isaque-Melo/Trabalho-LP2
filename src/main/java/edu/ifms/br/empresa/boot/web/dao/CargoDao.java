package edu.ifms.br.empresa.boot.web.dao;

import java.util.List;

import edu.ifms.br.empresa.domain.Cargo;

public interface CargoDao {
	
	void save(Cargo cargo);
	void update(Cargo cargo);
	void delete(Long id);
	Cargo findById(Long id);
	List<Cargo> findAll();
	

}
