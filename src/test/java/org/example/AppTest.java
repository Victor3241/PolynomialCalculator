package org.example;

import static org.junit.Assert.assertTrue;

import org.example.BusinessLogic.PolynomialControllerTest;
import org.example.Model.PolynomialTest;
import org.example.View.View;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        PolynomialTest polynomialTest = new PolynomialTest();
        polynomialTest.pos();
        polynomialTest.toStringTest();
        polynomialTest.max();
        polynomialTest.create();
        polynomialTest.onlyZero();
        PolynomialControllerTest polynomialControllerTest = new PolynomialControllerTest();
        polynomialControllerTest.add();
        polynomialControllerTest.substract();
        polynomialControllerTest.multiply();
        polynomialControllerTest.divide();
        polynomialControllerTest.remainder();
        polynomialControllerTest.derive();
        polynomialControllerTest.integrate();
    }
}
