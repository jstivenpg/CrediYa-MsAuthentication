package co.com.pragma.crediya.shared.mapper;

import co.com.pragma.crediya.model.user.BaseSalary;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.math.BigDecimal;
@Mapper(componentModel = "spring")
public interface BaseSalaryMapper {
    @Named("toSalary")
    default BaseSalary toSalary(BigDecimal amount) { return new BaseSalary(amount); }
    @Named("fromSalary")
    default BigDecimal fromSalary(BaseSalary baseSalary) { return baseSalary == null ? null : baseSalary.amount(); }
}
