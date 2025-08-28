package co.com.pragma.crediya.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
public record ResponseUserDTO(
        Long id,
        String names,
        String lastNames,
        LocalDate birthdate,
        String address,
        String phone,
        String email,
        BigDecimal baseSalary
) {
}
