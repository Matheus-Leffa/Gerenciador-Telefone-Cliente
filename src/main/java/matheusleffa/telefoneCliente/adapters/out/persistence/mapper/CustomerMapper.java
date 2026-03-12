package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.PhoneEntity;
import matheusleffa.telefoneCliente.domain.model.Customer;

import java.util.List;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer){

        CustomerEntity entity = new CustomerEntity(
                customer.getName(),
                customer.getCpf()
        );

        if(customer.getPhones() != null){
            List<PhoneEntity> phones = customer.getPhones()
                    .stream()
                    .map(phone -> PhoneMapper.toEntity(phone, entity))
                    .toList();

            entity.setPhones(phones);
        }

        return entity;
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
