package co.com.pragma.crediya.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
public record CreateUserDTO(
        String names,
        String lastNames,
        String email,
        LocalDate birthdate,
        String address,
        String phone,
        BigDecimal baseSalary
) {
}
