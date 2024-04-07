package tech.buildrun.loan.domain;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAllowed() {
        if (customer.isIncomeEqualOrLowerThan(3000.0)){
            return true;
        }

        return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLessThan(30)
                && customer.isFromLocation("SP");
    }

    public boolean isConsigmentLoanAllowed() {
        return customer.isIncomeEqualOrGreaterThan(5000.0);
    }

    public boolean isGuaranteedLoanAllowed() {
        if (customer.isIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }

        return customer.isIncomeBetween(3000.0, 5000.0)
                && customer.isAgeLessThan(30)
                && customer.isFromLocation("SP");
    }

    public Double getPersonalLoanInterestRate() {
        if (isPersonalLoanAllowed()) {
            return 4.;
        }
        throw new LoanNotAllowedException();
    }

    public Double getConsigmentLoanInterestRate() {
        if (isConsigmentLoanAllowed()) {
            return 2.;
        }
        throw new LoanNotAllowedException();
    }

    public Double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAllowed()) {
            return 3.;
        }
        throw new LoanNotAllowedException();
    }
}
