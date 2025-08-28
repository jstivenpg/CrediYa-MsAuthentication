package co.com.pragma.crediya.r2dbc.mapper;

import co.com.pragma.crediya.model.user.BaseSalary;
import co.com.pragma.crediya.model.user.Email;
import co.com.pragma.crediya.model.user.User;
import co.com.pragma.crediya.r2dbc.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    default UserEntity toEntity(User domain) {
        if (domain == null) return null;
        return UserEntity.builder()
                .id(domain.getid())
                .names(domain.getnames())
                .lastNames(domain.getlastNames())
                .birthdate(domain.getbirthdate())
                .address(domain.getaddress())
                .phone(domain.getphone())
                .email(domain.getemail() == null ? null : domain.getemail().email())
                .baseSalary(domain.getbaseSalary() == null ? null : domain.getbaseSalary().amount())
                .build();
    }
    default User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User created = User.create(
                entity.getNames(),
                entity.getLastNames(),
                entity.getBirthdate(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail() == null ? new Email(null) : new Email(entity.getEmail()),
                entity.getBaseSalary() == null ? new BaseSalary(null) : new BaseSalary(entity.getBaseSalary())
        );
        return entity.getId() == null ? created : created.withId(entity.getId());
    }
}
