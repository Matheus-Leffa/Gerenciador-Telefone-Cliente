package matheusleffa.telefoneCliente.domain.ports;

import matheusleffa.telefoneCliente.domain.model.Customer;

public interface CustomerRepository {
    boolean existsByCpf(String cpf);

    void save(Customer customer);
}
