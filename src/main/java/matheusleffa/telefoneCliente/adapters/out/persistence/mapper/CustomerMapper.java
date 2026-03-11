package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.domain.model.Customer;

public class CustomerMapper {

    public static CustomerEntity toEntity(Customer customer){
        return new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getCpf()
        );
    }

    public static Customer toDomain(CustomerEntity entity){
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getCpf()
        );
    }
}
