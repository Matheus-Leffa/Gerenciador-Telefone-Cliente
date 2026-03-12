package matheusleffa.telefoneCliente.application.usecase;

import matheusleffa.telefoneCliente.domain.exception.CustomerNotFoundException;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.ports.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemovePhoneFromCustomerUseCase {

    private final CustomerRepository customerRepository;

    public RemovePhoneFromCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(UUID customerId, UUID phoneId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        customer.removePhone(phoneId);

        customerRepository.save(customer);
    }
}
