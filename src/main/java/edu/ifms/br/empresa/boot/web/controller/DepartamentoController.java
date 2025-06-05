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

import edu.ifms.br.empresa.boot.web.service.DepartamentoService;
import edu.ifms.br.empresa.domain.Departamento;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "departamento/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "departamento/cadastro";
        }
        departamentoService.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento inserido com sucesso");
        // Redireciona para a lista atualizada após salvar
        return "redirect:/departamentos/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", departamentoService.buscarTodos());
        return "departamento/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("departamento", departamentoService.buscarPorId(id));
        return "departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr,
            ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("departamento", departamento);
            return "departamento/cadastro";
        }
        departamentoService.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso");
        // Redireciona para a lista atualizada após editar
        return "redirect:/departamentos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        departamentoService.excluir(id);
        attr.addFlashAttribute("success", "Departamento excluído com sucesso");
        return "redirect:/departamentos/listar";
    }
}
