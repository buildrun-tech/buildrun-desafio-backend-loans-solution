package tech.buildrun.loan.domain;

import tech.buildrun.loan.controller.dto.CustomerLoanRequest;

public class Customer {

    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrGreaterThan(Double value) {
        return income >= value;
    }

    public boolean isIncomeEqualOrLowerThan(Double value) {
        return income >= value;
    }

    public boolean isIncomeBetween(Double minValue, Double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean isAgeLessThan(int value) {
        return age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
