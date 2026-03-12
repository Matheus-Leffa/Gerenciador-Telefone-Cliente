package matheusleffa.telefoneCliente.adapters.in.controller;

import matheusleffa.telefoneCliente.adapters.in.controller.dto.AddPhoneRequest;
import matheusleffa.telefoneCliente.adapters.in.controller.dto.CustomerResponse;
import matheusleffa.telefoneCliente.application.usecase.AddPhoneToCustomerUseCase;
import matheusleffa.telefoneCliente.application.usecase.CreateCustomerUseCase;
import matheusleffa.telefoneCliente.adapters.in.controller.dto.CreateCustomerRequest;
import matheusleffa.telefoneCliente.domain.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final AddPhoneToCustomerUseCase addPhoneToCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, AddPhoneToCustomerUseCase addPhoneToCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.addPhoneToCustomerUseCase = addPhoneToCustomerUseCase;
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request){
        Customer customer = createCustomerUseCase.execute(request);

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getCpf()
        );
    }

    @PostMapping("/{customerId}/phones")
    public void addPhone(@PathVariable UUID customerId, @RequestBody AddPhoneRequest request){
        addPhoneToCustomerUseCase.execute(customerId, request);
    }
}
