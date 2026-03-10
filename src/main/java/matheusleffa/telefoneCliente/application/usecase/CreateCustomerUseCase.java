package matheusleffa.telefoneCliente.application.usecase;

import matheusleffa.telefoneCliente.application.usecase.dto.CreateCustomerRequest;
import matheusleffa.telefoneCliente.domain.exception.CpfAlreadyExistsException;
import matheusleffa.telefoneCliente.domain.model.Customer;
import matheusleffa.telefoneCliente.domain.ports.CustomerRepository;

public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;


    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(CreateCustomerRequest request){

        if(customerRepository.existsByCpf(request.cpf())){
            throw new CpfAlreadyExistsException(request.cpf());
        }

        Customer customer = new Customer(request.name(), request.cpf());

        customerRepository.save(customer);
    }
}
