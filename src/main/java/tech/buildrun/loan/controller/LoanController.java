package tech.buildrun.loan.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.loan.controller.dto.CustomerLoanRequest;
import tech.buildrun.loan.controller.dto.CustomerLoanResponse;
import tech.buildrun.loan.service.LoanService;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest) {

        var loanResponse = loanService.checkLoanAvailabity(loanRequest);

        return ResponseEntity.ok(loanResponse);
    }
}
