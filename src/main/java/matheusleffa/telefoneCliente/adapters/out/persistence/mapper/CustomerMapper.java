package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.PhoneEntity;
import matheusleffa.telefoneCliente.domain.model.Customer;

import java.util.List;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {

        CustomerEntity entity = new CustomerEntity(
                customer.getName(),
                customer.getCpf()
        );

        if (customer.getPhones() != null) {
            customer.getPhones().forEach(phone ->
                    entity.getPhones().add(
                            PhoneMapper.toEntity(phone, entity)
                    )
            );
        }

        return entity;
    }

    public static void updateEntity(Customer customer, CustomerEntity entity) {

        entity.setName(customer.getName());
        entity.setCpf(customer.getCpf());

        entity.getPhones().clear();

        if (customer.getPhones() != null) {
            customer.getPhones().forEach(phone ->
                    entity.getPhones().add(
                            PhoneMapper.toEntity(phone, entity)
                    )
            );
        }
    }

    public static Customer toDomain(CustomerEntity entity) {

        Customer customer = new Customer(
                entity.getId(),
                entity.getName(),
                entity.getCpf()
        );

        if (entity.getPhones() != null) {
            entity.getPhones()
                    .stream()
                    .map(PhoneMapper::toDomain)
                    .forEach(customer::addPhone);
        }

        return customer;
    }
}
