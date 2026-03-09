package matheusleffa.telefoneCliente.domain.model;

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
}
