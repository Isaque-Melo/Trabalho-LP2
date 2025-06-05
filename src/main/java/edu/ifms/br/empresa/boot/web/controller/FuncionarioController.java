package edu.ifms.br.empresa.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.ModelMap;
import jakarta.validation.Valid;

import edu.ifms.br.empresa.boot.web.service.FuncionarioService;
import edu.ifms.br.empresa.boot.web.service.CargoService;
import edu.ifms.br.empresa.boot.web.service.DepartamentoService;
import edu.ifms.br.empresa.domain.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario, ModelMap model) {
        model.addAttribute("cargos", cargoService.buscarTodos());
        model.addAttribute("departamentos", departamentoService.buscarTodos());
        model.addAttribute("funcionario", funcionario);
        return "funcionario/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr,
            ModelMap model) {
        
        if (funcionario.getCargo() != null && funcionario.getCargo().getId() != null) {
            funcionario.setCargo(cargoService.buscarPorId(funcionario.getCargo().getId()));
        }
        if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
            funcionario.setDepartamento(departamentoService.buscarPorId(funcionario.getDepartamento().getId()));
        }
        if (result.hasErrors()) {
            model.addAttribute("cargos", cargoService.buscarTodos());
            model.addAttribute("departamentos", departamentoService.buscarTodos());
            return "funcionario/cadastro";
        }
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "funcionario/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        model.addAttribute("cargos", cargoService.buscarTodos());
        model.addAttribute("departamentos", departamentoService.buscarTodos());
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr,
            ModelMap model) {
        // Busca manual dos objetos pelo ID recebido
        if (funcionario.getCargo() != null && funcionario.getCargo().getId() != null) {
            funcionario.setCargo(cargoService.buscarPorId(funcionario.getCargo().getId()));
        }
        if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
            funcionario.setDepartamento(departamentoService.buscarPorId(funcionario.getDepartamento().getId()));
        }
        if (result.hasErrors()) {
            model.addAttribute("cargos", cargoService.buscarTodos());
            model.addAttribute("departamentos", departamentoService.buscarTodos());
            return "funcionario/cadastro";
        }
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionário editado com sucesso");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success", "Funcionário excluído com sucesso");
        return "redirect:/funcionarios/listar";
    }
}
