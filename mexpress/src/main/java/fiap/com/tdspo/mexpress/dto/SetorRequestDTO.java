package fiap.com.tdspo.mexpress.dto;

import jakarta.validation.constraints.NotBlank;

public record SetorRequestDTO(@NotBlank String setor) {
}
