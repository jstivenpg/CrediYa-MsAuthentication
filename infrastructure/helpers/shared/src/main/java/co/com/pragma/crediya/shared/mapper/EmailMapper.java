package co.com.pragma.crediya.shared.mapper;

import co.com.pragma.crediya.model.user.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    @Named("toEmail")
    default Email toEmail(String email) {return new Email(email);}

    @Named("fromEmail")
    default String fromEmail(Email email) { return email == null ? null : email.email(); }

}