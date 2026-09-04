package fiap.com.tdspo.mexpress.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotBlank String setor,
        @NotNull @DecimalMin(value = "0.01") BigDecimal tamanho,
        @NotNull @DecimalMin(value = "0.00") BigDecimal preco
) {
}
