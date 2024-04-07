package tech.buildrun.loans.controller.dto;

import tech.buildrun.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
