package tech.buildrun.loan.service;

import org.springframework.stereotype.Service;
import tech.buildrun.loan.controller.dto.CustomerLoanRequest;
import tech.buildrun.loan.controller.dto.CustomerLoanResponse;
import tech.buildrun.loan.controller.dto.LoanResponse;
import tech.buildrun.loan.domain.Customer;
import tech.buildrun.loan.domain.Loan;
import tech.buildrun.loan.domain.LoanType;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkLoanAvailabity(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();

        var loan = new Loan(customer);

        List<LoanResponse> loansResponse = new ArrayList<>();

        if (loan.isPersonalLoanAllowed()) {
            loansResponse.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAllowed()) {
            loansResponse.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        if (loan.isConsigmentLoanAllowed()) {
            loansResponse.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loansResponse);
    }
}
