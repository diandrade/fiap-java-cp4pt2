package fiap.com.tdspo.mexpress.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoRequestDTO(@NotBlank String tipo) {
}
