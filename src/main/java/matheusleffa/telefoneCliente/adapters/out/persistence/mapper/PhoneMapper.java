package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.PhoneEntity;
import matheusleffa.telefoneCliente.domain.model.Phone;

public class PhoneMapper {

    public static PhoneEntity toEntity(Phone phone, CustomerEntity customerEntity) {
        PhoneEntity entity = new PhoneEntity();
        entity.setCountryCode(phone.getCountryCode());
        entity.setDdd(phone.getDdd());
        entity.setNumber(phone.getNumber());
        entity.setType(phone.getType());
        entity.setCustomer(customerEntity);
        return entity;
    }

    public static Phone toDomain(PhoneEntity entity) {
        return new Phone(
                entity.getCountryCode(),
                entity.getDdd(),
                entity.getNumber(),
                entity.getType()
        );
    }
}
