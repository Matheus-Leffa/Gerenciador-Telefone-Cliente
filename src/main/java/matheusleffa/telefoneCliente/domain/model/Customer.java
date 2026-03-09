package matheusleffa.telefoneCliente.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String cpf;
    private List<Phone> phones = new ArrayList<>();
}
