package tech.buildrun.loans.domain;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isConsigmentLoanAvailable() {
        return customer.isIncomeEqualOrGreaterThan(5000.0);
    }

    public boolean isGuaranteedLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getConsigmentLoanInterestRate() {
        if (isConsigmentLoanAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable() {
        if (customer.isIncomeEqualOrLowerThan(3000.0)) {
            return true;
        }

        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}
