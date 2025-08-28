package co.com.pragma.crediya.model.user;

import java.math.BigDecimal;

public record BaseSalary(BigDecimal amount)
{
    private static final BigDecimal MIN = new BigDecimal("0");
    private static final BigDecimal MAX = new BigDecimal("15000000");
    public BaseSalary {
        if(amount == null) throw new IllegalArgumentException("The base salary is mandatory");
        if(amount.compareTo(MIN) < 0 || amount.compareTo(MAX) > 0 )
            throw new IllegalArgumentException(
                    "The base salary cannot be negative and the base salary cannot exceed 15,000,000"
            );
    }
}