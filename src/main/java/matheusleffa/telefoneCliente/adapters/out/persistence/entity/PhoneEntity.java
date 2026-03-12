package matheusleffa.telefoneCliente.adapters.out.persistence.entity;

import jakarta.persistence.*;
import matheusleffa.telefoneCliente.domain.model.PhoneType;

import java.util.UUID;

@Entity
@Table(name = "phones")
public class PhoneEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String countryCode;

    private String ddd;

    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
