package matheusleffa.telefoneCliente.domain.model;

import java.util.Objects;

public class Phone {
    private String countryCode;
    private String ddd;
    private String number;
    private PhoneType type;

    public Phone(String countryCode, String ddd, String number, PhoneType type) {
        if(countryCode == null || countryCode.isBlank()) {
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
            char firstDigit = number.charAt(0);

            if(number.length() != 9){
                throw new IllegalArgumentException("Mobile number must have 9 digits");
            }
            if(firstDigit != '9'){
                throw new IllegalArgumentException("Mobile number must starts with 9");
            }

        }

        this.countryCode = countryCode;
        this.ddd = ddd;
        this.number = number;
        this.type = type;
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

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null){
            return false;
        }

        if(!(o instanceof Phone)){
            return false;
        }

        Phone other = (Phone) o;

        return Objects.equals(countryCode, other.countryCode)
                && Objects.equals(ddd, other.ddd)
                && Objects.equals(number, other.number);

    }

    @Override
    public int hashCode(){
        return Objects.hash(countryCode, ddd, number);
    }


}
