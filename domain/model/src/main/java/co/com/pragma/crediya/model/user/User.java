package co.com.pragma.crediya.model.user;

import java.time.LocalDate;

public class User {
    private final Long id;
    private final String names;
    private final String lastNames;
    private final LocalDate birthdate;
    private final String address;
    private final String phone;
    private final Email email;
    private final BaseSalary baseSalary;

    private User(Long id, String names, String lastNames, LocalDate birthdate,
                 String address, String phone, Email email, BaseSalary baseSalary) {

        if (names == null || names.isBlank()) throw new IllegalArgumentException("The names are required");
        if (lastNames == null || lastNames.isBlank()) throw new IllegalArgumentException("The last names are required");

        this.id = id;
        this.names = names.trim();
        this.lastNames = lastNames.trim();
        this.birthdate = birthdate;
        this.address = address == null ? null : address.trim();
        this.phone = phone == null ? null : phone.trim();
        this.email = email;
        this.baseSalary = baseSalary;
    }
    public static User create(String names, String lastNames, LocalDate birthdate,
                              String address, String phone, Email email, BaseSalary baseSalary) {
        return new User(null, names, lastNames, birthdate, address, phone, email, baseSalary);
    }

    public User withId(Long id) { return new User(id, names, lastNames, birthdate, address, phone, email, baseSalary); }

    public Long getid() {
        return id;
    }

    public String getnames() {
        return names;
    }

    public String getlastNames() {
        return lastNames;
    }

    public LocalDate getbirthdate() {
        return birthdate;
    }

    public String getaddress() {
        return address;
    }

    public String getphone() {
        return phone;
    }

    public Email getemail() {
        return email;
    }

    public BaseSalary getbaseSalary() {
        return baseSalary;
    }
}
