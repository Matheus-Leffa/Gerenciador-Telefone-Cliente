package matheusleffa.telefoneCliente.adapters.out.persistence.entity;

import jakarta.persistence.*;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String cpf;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> phones = new ArrayList<>();

    public CustomerEntity(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    protected CustomerEntity(){

    }

    public void addPhone(PhoneEntity phone) {
        phones.add(phone);
        phone.setCustomer(this);
    }

    public void removePhone(PhoneEntity phone) {
        phones.remove(phone);
        phone.setCustomer(null);
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

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }
}
