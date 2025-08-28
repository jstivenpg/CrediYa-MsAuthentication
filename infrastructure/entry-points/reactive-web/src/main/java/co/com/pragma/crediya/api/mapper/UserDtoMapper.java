package co.com.pragma.crediya.api.mapper;

import co.com.pragma.crediya.api.dto.CreateUserDTO;
import co.com.pragma.crediya.api.dto.ResponseUserDTO;
import co.com.pragma.crediya.model.user.BaseSalary;
import co.com.pragma.crediya.model.user.Email;
import co.com.pragma.crediya.model.user.User;
import co.com.pragma.crediya.shared.mapper.BaseSalaryMapper;
import co.com.pragma.crediya.shared.mapper.DateMapper;
import co.com.pragma.crediya.shared.mapper.EmailMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
@Mapper(
        componentModel = "spring",
        uses = {
                EmailMapper.class,
                BaseSalaryMapper.class,
                DateMapper.class
        },
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {

    default User toModel(CreateUserDTO dto) {
        if (dto == null) return null;
        return User.create(
                dto.names(),
                dto.lastNames(),
                dto.birthdate(),
                dto.address(),
                dto.phone(),
                dto.email() == null ? null : new Email(dto.email()),
                dto.baseSalary() == null ? null : new BaseSalary(dto.baseSalary())
        );
    }
    @Mappings({
            @Mapping(target = "birthdate", source = "birthdate", qualifiedByName = "fromLocalDate"),
            @Mapping(target = "email", source = "email", qualifiedByName = "fromEmail"),
            @Mapping(target = "baseSalary", source = "baseSalary", qualifiedByName = "fromSalary")
    })
    ResponseUserDTO toResponse(User user);
}
