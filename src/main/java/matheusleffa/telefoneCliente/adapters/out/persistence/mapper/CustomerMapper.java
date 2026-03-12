package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.PhoneEntity;
import matheusleffa.telefoneCliente.domain.model.Customer;

import java.util.List;

public class CustomerMapper {

    public static void updateEntity(Customer customer, CustomerEntity entity){

        entity.setName(customer.getName());
        entity.setCpf(customer.getCpf());

        entity.getPhones().clear();

        if(customer.getPhones() != null){
            customer.getPhones()
                    .stream()
                    .map(phone -> PhoneMapper.toEntity(phone, entity))
                    .forEach(entity.getPhones()::add);
        }
    }

    public static Customer toDomain(CustomerEntity entity){

        Customer customer = new Customer(
                entity.getId(),
                entity.getName(),
                entity.getCpf()
        );

        if(entity.getPhones() != null){
            entity.getPhones()
                    .stream()
                    .map(PhoneMapper::toDomain)
                    .forEach(customer::addPhone);
        }

        return customer;
    }
}
