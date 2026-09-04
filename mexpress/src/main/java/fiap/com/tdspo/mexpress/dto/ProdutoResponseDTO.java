package fiap.com.tdspo.mexpress.dto;

import fiap.com.tdspo.mexpress.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDTO extends RepresentationModel<ProdutoResponseDTO> {
    private Long id;
    private String nome;
    private String tipo;
    private String setor;
    private BigDecimal tamanho;
    private BigDecimal preco;

    public void toProdutoDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.tipo = produto.getTipo();
        this.setor = produto.getSetor();
        this.tamanho = produto.getTamanho();
        this.preco = produto.getPreco();
    }
}
