package edu.ifms.br.empresa.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import edu.ifms.br.empresa.boot.web.service.CargoService;
import edu.ifms.br.empresa.boot.web.service.DepartamentoService;
import edu.ifms.br.empresa.domain.Cargo;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo, ModelMap model) {
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		model.addAttribute("cargo", cargo);
		return "cargo/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result,
			RedirectAttributes attr, ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("departamentos", departamentoService.buscarTodos());
			model.addAttribute("cargo", cargo);
			return "cargo/cadastro";
		}

		cargoService.salvar(cargo);

		attr.addFlashAttribute("success", "Cargo inserido com sucesso");

		return "redirect:/cargos/listar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "cargo/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		model.addAttribute("departamentos", departamentoService.buscarTodos());
		return "cargo/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("departamentos", departamentoService.buscarTodos());
			return "cargo/cadastro";
		}
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Cargo editado com sucesso");
		return "redirect:/cargos/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		cargoService.excluir(id);
		attr.addFlashAttribute("success", "Cargo excluído com sucesso");
		return "redirect:/cargos/listar";
	}

}
