package tech.buildrun.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertTrue(loan.isGuaranteedLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
            doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsigmentLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k() {

            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertTrue(loan.isConsigmentLoanAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsEqualTo4K() {

            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertFalse(loan.isConsigmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {

        @Test
        void shouldTheInterestRateBe4() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {

        @Test
        void shouldTheInterestRateBe3() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsigmentLoanInterestRate {

        @Test
        void shouldTheInterestRateBe2() {

            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertEquals(2.0, loan.getConsigmentLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {

            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertThrows(LoanNotAvailableException.class, () -> loan.getConsigmentLoanInterestRate());
        }
    }

}