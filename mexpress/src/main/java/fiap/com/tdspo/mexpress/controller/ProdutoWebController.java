package fiap.com.tdspo.mexpress.controller;

import fiap.com.tdspo.mexpress.dto.ProdutoRequestDTO;
import fiap.com.tdspo.mexpress.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mercado/web")
@RequiredArgsConstructor
public class ProdutoWebController {

    private final ProdutoService service;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("produtos", service.listar());

        return "index";
    }
    @PostMapping
    public String criar(@Valid @ModelAttribute ProdutoRequestDTO dados) {

        service.criar(dados);

        return "redirect:/mercado/web";
    }
    @PostMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable Long id,
            @Valid @ModelAttribute ProdutoRequestDTO dados) {

        service.atualizar(id, dados);

        return "redirect:/mercado/web";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {

        service.deletar(id);

        return "redirect:/mercado/web";
    }
}