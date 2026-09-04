package fiap.com.tdspo.mexpress.service;

import fiap.com.tdspo.mexpress.dto.ProdutoRequestDTO;
import fiap.com.tdspo.mexpress.entity.Produto;
import fiap.com.tdspo.mexpress.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criar(ProdutoRequestDTO dados) {
        Produto produto = Produto.builder()
                .nome(dados.nome())
                .tipo(dados.tipo())
                .setor(dados.setor())
                .tamanho(dados.tamanho())
                .preco(dados.preco())
                .build();
        return produtoRepository.save(produto);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto atualizar(Long id, ProdutoRequestDTO dados) {
        Produto produto = buscarPorId(id);
        produto.setNome(dados.nome());
        produto.setTipo(dados.tipo());
        produto.setSetor(dados.setor());
        produto.setTamanho(dados.tamanho());
        produto.setPreco(dados.preco());
        return produtoRepository.save(produto);
    }

    public Produto atualizarNome(Long id, String nome) {
        Produto produto = buscarPorId(id);
        produto.setNome(nome);
        return produtoRepository.save(produto);
    }

    public Produto atualizarTipo(Long id, String tipo) {
        Produto produto = buscarPorId(id);
        produto.setTipo(tipo);
        return produtoRepository.save(produto);
    }

    public Produto atualizarSetor(Long id, String setor) {
        Produto produto = buscarPorId(id);
        produto.setSetor(setor);
        return produtoRepository.save(produto);
    }

    public Produto atualizarTamanho(Long id, BigDecimal tamanho) {
        Produto produto = buscarPorId(id);
        produto.setTamanho(tamanho);
        return produtoRepository.save(produto);
    }

    public Produto atualizarPreco(Long id, BigDecimal preco) {
        Produto produto = buscarPorId(id);
        produto.setPreco(preco);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.delete(buscarPorId(id));
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto nao encontrado: " + id));
    }
}
