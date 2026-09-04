package fiap.com.tdspo.mexpress.dto;

import jakarta.validation.constraints.NotBlank;

public record NomeRequestDTO(@NotBlank String nome) {
}
