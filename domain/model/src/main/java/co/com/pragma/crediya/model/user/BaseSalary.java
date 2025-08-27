package co.com.pragma.crediya.model.user;

import java.math.BigDecimal;

public record BaseSalary(BigDecimal cantidad)
{
    private static final BigDecimal MIN = new BigDecimal("0");
    private static final BigDecimal MAX = new BigDecimal("15000000");
    public BaseSalary {
        if(cantidad == null) throw new IllegalArgumentException("The base salary is mandatory");
        if(cantidad.compareTo(MIN) < 0 || cantidad.compareTo(MAX) > 0 )
            throw new IllegalArgumentException(
                    "The base salary cannot be negative and the base salary cannot exceed 15,000,000"
            );
    }
}