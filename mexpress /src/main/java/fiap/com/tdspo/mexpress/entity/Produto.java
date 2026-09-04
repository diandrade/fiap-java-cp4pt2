package fiap.com.tdspo.mexpress.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String setor;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tamanho;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal preco;
}
