package tech.buildrun.loans.controller.dto;

import java.util.List;

public record CustomerLoanResponse(String customer, List<LoanResponse> loans) {
}
