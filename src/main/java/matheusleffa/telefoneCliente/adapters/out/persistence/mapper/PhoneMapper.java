package matheusleffa.telefoneCliente.adapters.out.persistence.mapper;

import matheusleffa.telefoneCliente.adapters.out.persistence.entity.CustomerEntity;
import matheusleffa.telefoneCliente.adapters.out.persistence.entity.PhoneEntity;
import matheusleffa.telefoneCliente.domain.model.Phone;

public class PhoneMapper {

    public static PhoneEntity toEntity(Phone phone, CustomerEntity customerEntity) {

        return new PhoneEntity(
                phone.getCountryCode(),
                phone.getDdd(),
                phone.getNumber(),
                phone.getType(),
                customerEntity
        );
    }

    public static Phone toDomain(PhoneEntity entity) {

        return new Phone(
                entity.getId(),
                entity.getCountryCode(),
                entity.getDdd(),
                entity.getNumber(),
                entity.getType()
        );
    }
}
