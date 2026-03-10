package matheusleffa.telefoneCliente.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String cpf;
    private List<Phone> phones = new ArrayList<>();

    public Customer(String name, String cpf){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is required");
        }

        if(cpf == null || cpf.isBlank()){
            throw new IllegalArgumentException("CPF is required");
        }

        if(!cpf.matches("\\d+")){
            throw new IllegalArgumentException("CPF must contain only digits");
        }

        if(cpf.length() != 11) {
            throw new IllegalArgumentException("CPF must have 11 digits");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.phones = new ArrayList<>();
    }

    public void addPhone(Phone phone){
        if(phone == null){
            throw new IllegalArgumentException("Phone is required");
        }

        if(phones.contains(phone)){
            throw new IllegalStateException("This phone already exists");
        }

        phones.add(phone);
    }
}
