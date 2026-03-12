package matheusleffa.telefoneCliente.application.usecase;

import matheusleffa.telefoneCliente.adapters.in.controller.dto.AddPhoneRequest;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.domain.exception.CustomerNotFoundException;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.model.Phone;
import matheusleffa.telefoneCliente.domain.ports.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddPhoneToCustomerUseCase {

    private final CustomerRepository customerRepository;

    public AddPhoneToCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(UUID customerId, AddPhoneRequest request){

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        Phone phone = new Phone(
                request.countryCode(),
                request.ddd(),
                request.number(),
                request.type()
        );

        customer.addPhone(phone);

        customerRepository.save(customer);
    }
}
