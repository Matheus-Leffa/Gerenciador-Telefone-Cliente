package matheusleffa.telefoneCliente.domain.exception;

public class CpfAlreadyExistsException extends RuntimeException {
    public CpfAlreadyExistsException(String cpf) {
        super("Customer with CPF " + cpf + " already exists");
    }
}
