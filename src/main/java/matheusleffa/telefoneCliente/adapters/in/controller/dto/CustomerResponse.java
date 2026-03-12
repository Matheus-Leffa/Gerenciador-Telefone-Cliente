package matheusleffa.telefoneCliente.adapters.in.controller.dto;

import java.util.UUID;

public record CustomerResponse(UUID id, String name, String cpf) {
}
