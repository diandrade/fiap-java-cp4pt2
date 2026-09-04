package fiap.com.tdspo.mexpress.controller;

import fiap.com.tdspo.mexpress.dto.*;
import fiap.com.tdspo.mexpress.entity.Produto;
import fiap.com.tdspo.mexpress.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mercado")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(
            @PathVariable Long id) {

        Produto produto = service.buscarPorId(id);

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoRequestDTO dados) {
        Produto produto = service.criar(dados);
        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        URI URIlocation = linkTo(methodOn(ProdutoController.class)
                .buscarPorId(produto.getId())).toUri();

        return ResponseEntity.created(URIlocation).body(dto);
    }


    @PatchMapping("/{id}/nome")
    public ResponseEntity<ProdutoResponseDTO> atualizarNome(
            @PathVariable Long id,
            @Valid @RequestBody NomeRequestDTO dados) {

        Produto produto = service.atualizarNome(id, dados.nome());

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }


    @PatchMapping("/{id}/tipo")
    public ResponseEntity<ProdutoResponseDTO> atualizarTipo(
            @PathVariable Long id,
            @Valid @RequestBody TipoRequestDTO dados) {

        Produto produto = service.atualizarTipo(id, dados.tipo());

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }


    @PatchMapping("/{id}/setor")
    public ResponseEntity<ProdutoResponseDTO> atualizarSetor(
            @PathVariable Long id,
            @Valid @RequestBody SetorRequestDTO dados) {

        Produto produto = service.atualizarSetor(id, dados.setor());

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}/tamanho")
    public ResponseEntity<ProdutoResponseDTO> atualizarTamanho(
            @PathVariable Long id,
            @Valid @RequestBody TamanhoRequestDTO dados) {

        Produto produto = service.atualizarTamanho(id, dados.tamanho());

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }


    @PatchMapping("/{id}/preco")
    public ResponseEntity<ProdutoResponseDTO> atualizarPreco(
            @PathVariable Long id,
            @Valid @RequestBody PrecoRequestDTO dados) {

        Produto produto = service.atualizarPreco(id, dados.preco());

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dados) {

        Produto produto = service.atualizar(id, dados);

        ProdutoResponseDTO dto = resposta(produto);

        adicionarLinks(dto, produto.getId());

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Produto> produtos = service.listar();
        List<ProdutoResponseDTO> resposta = produtos.stream()
                .map(this::resposta)
                .peek(dto -> adicionarLinks(dto, dto.getId()))
                .toList();

        return ResponseEntity.ok(resposta);
    }

    private ProdutoResponseDTO resposta(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.toProdutoDto(produto);
        return dto;
    }

    private void adicionarLinks(ProdutoResponseDTO dto, Long id) {


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .buscarPorId(id)
                ).withSelfRel()
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizar(id, null)
                ).withRel("atualizar")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizarNome(id, null)
                ).withRel("atualizar-nome")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizarTipo(id, null)
                ).withRel("atualizar-tipo")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizarSetor(id, null)
                ).withRel("atualizar-setor")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizarTamanho(id, null)
                ).withRel("atualizar-tamanho")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .atualizarPreco(id, null)
                ).withRel("atualizar-preco")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .deletar(id)
                ).withRel("deletar")
        );


        dto.add(
                linkTo(
                        methodOn(ProdutoController.class)
                                .listar()
                ).withRel("produtos")
        );
    }
}
