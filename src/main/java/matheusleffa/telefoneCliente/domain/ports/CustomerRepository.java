package matheusleffa.telefoneCliente.domain.ports;

import matheusleffa.telefoneCliente.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    boolean existsByCpf(String cpf);

    Customer save(Customer customer);

    Optional<Customer> findById(UUID id);
}
