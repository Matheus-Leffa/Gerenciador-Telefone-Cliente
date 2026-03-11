package matheusleffa.telefoneCliente.adapters.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import matheusleffa.telefoneCliente.domain.model.Customer;

import java.util.UUID;

@Entity
public class CustomerEntity {

    @Id
    private UUID id;

    private String name;

    private String cpf;

    public CustomerEntity(UUID id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    protected CustomerEntity(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
