package matheusleffa.telefoneCliente.adapters.out.persistence.repository;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByCpf(String cpf);
}
