package matheusleffa.telefoneCliente.application.usecase;

import matheusleffa.telefoneCliente.adapters.in.controller.dto.CreateCustomerRequest;
import matheusleffa.telefoneCliente.domain.exception.CpfAlreadyExistsException;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.ports.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;


    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(CreateCustomerRequest request){

        if(customerRepository.existsByCpf(request.cpf())){
            throw new CpfAlreadyExistsException(request.cpf());
        }

        Customer customer = new Customer(request.name(), request.cpf());

        return customerRepository.save(customer);
    }
}
