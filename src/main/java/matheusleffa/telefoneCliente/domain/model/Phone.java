package matheusleffa.telefoneCliente.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Phone {

    private UUID id;
    private String countryCode;
    private String ddd;
    private String number;
    private PhoneType type;

    public Phone(UUID id, String countryCode, String ddd, String number, PhoneType type) {

        if(countryCode == null || countryCode.isBlank()){
            throw new IllegalArgumentException("Country code is required");
        }

        if(ddd == null || ddd.isBlank()){
            throw new IllegalArgumentException("DDD is required");
        }

        if(number == null || number.isBlank()){
            throw new IllegalArgumentException("Number is required");
        }

        if(!number.matches("\\d+")){
            throw new IllegalArgumentException("Number must contain only digits");
        }

        if(type == null){
            throw new IllegalArgumentException("Type must be valid");
        }

        if(type == PhoneType.MOBILE){

            if(number.length() != 9){
                throw new IllegalArgumentException("Mobile number must have 9 digits");
            }

            if(number.charAt(0) != '9'){
                throw new IllegalArgumentException("Mobile number must start with 9");
            }
        }

        this.id = id; // pode ser null quando criado
        this.countryCode = countryCode;
        this.ddd = ddd;
        this.number = number;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
    }
}
