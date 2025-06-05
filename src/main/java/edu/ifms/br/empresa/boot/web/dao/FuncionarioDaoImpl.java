package edu.ifms.br.empresa.boot.web.dao;

import org.springframework.stereotype.Repository;
import edu.ifms.br.empresa.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long>
    implements FuncionarioDao {

}
