package tech.buildrun.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.buildrun.loans.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(9000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrLowerThan(8000.0));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeEqualOrGreaterThan(8000.0));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin() {
            var customer = CustomerFactory.build(5000.0);

            assertTrue(customer.isIncomeBetween(5000.0, 8000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax() {
            var customer = CustomerFactory.build(8000.0);

            assertTrue(customer.isIncomeBetween(5000.0, 8000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            var customer = CustomerFactory.build(5000.0);

            assertFalse(customer.isIncomeBetween(3000.0, 4500.0));
        }

    }

    @Nested
    class isAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(25);

            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(22));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }

    }

    @Nested
    class isFromLocation {

        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            var customer = CustomerFactory.build("SP");

            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            var customer = CustomerFactory.build("SP");

            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}