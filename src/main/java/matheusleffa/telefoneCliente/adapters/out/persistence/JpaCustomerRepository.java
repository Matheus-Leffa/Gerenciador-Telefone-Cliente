package matheusleffa.telefoneCliente.adapters.out.persistence;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.mapper.CustomerMapper;
import matheusleffa.telefoneCliente.adapters.out.persistence.repository.SpringDataCustomerRepository;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.ports.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    private final SpringDataCustomerRepository repository;

    public JpaCustomerRepository(SpringDataCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public Customer save(Customer customer) {

        CustomerEntity entity;

        if (customer.getId() == null) {
            entity = CustomerMapper.toEntity(customer);
        } else {

            entity = repository.findById(customer.getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            CustomerMapper.updateEntity(customer, entity);
        }

        CustomerEntity saved = repository.save(entity);

        return CustomerMapper.toDomain(saved);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id)
                .map(CustomerMapper::toDomain);
    }
}
