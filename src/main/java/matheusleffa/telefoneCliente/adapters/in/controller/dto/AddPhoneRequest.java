package matheusleffa.telefoneCliente.adapters.in.controller.dto;

import matheusleffa.telefoneCliente.domain.model.PhoneType;

public record AddPhoneRequest(String countryCode, String ddd, String number, PhoneType type) {
}
