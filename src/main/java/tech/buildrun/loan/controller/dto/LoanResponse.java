package tech.buildrun.loan.controller.dto;

import tech.buildrun.loan.domain.LoanType;

public record LoanResponse(LoanType type, double interestRate) {
}
