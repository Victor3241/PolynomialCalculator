package org.example.BusinessLogic;

import org.example.Model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialControllerTest {

    Polynomial p1;
    Polynomial p2;
    Polynomial res;

    @Test
    public void add() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        res = new Polynomial();
        p1.p.put(2, 1.0);
        p2.p.put(3, 3.0);
        p1.p.put(1, 2.0);
        p2.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        p2.p.put(0, 5.0);
        res = PolynomialController.Add(p1, p2);
        assertEquals("6.0 + 4.0*x1 + 1.0*x2 + 3.0*x3 ", res.toString());
    }

    @Test
    public void substract() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        res = new Polynomial();
        p1.p.put(2, 1.0);
        p2.p.put(3, 3.0);
        p1.p.put(1, 2.0);
        p2.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        p2.p.put(0, 5.0);
        res = PolynomialController.Subtract(p2, p1);
        assertEquals("4.0 - 1.0*x2 + 3.0*x3 ", res.toString());
    }

    @Test
    public void multiply() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        res = new Polynomial();
        p1.p.put(2, 1.0);
        p2.p.put(3, 3.0);
        p1.p.put(1, 2.0);
        p2.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        p2.p.put(0, 5.0);
        res = PolynomialController.Multiply(p1, p2);
        assertEquals("5.0 + 12.0*x1 + 9.0*x2 + 5.0*x3 + 6.0*x4 + 3.0*x5 ", res.toString());
    }

    @Test
    public void divide() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        res = new Polynomial();
        p1.p.put(2, 1.0);
        p1.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        p2.p.put(1, 1.0);
        p2.p.put(0, 1.0);
        res = PolynomialController.Divide(p1, p2);
        assertEquals("1.0 + 1.0*x1 ", res.toString());
        res = new Polynomial();
        res = PolynomialController.Divide(p2, p1);
        assertEquals(p2.toString(), res.toString());
    }

    @Test
    public void remainder() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        res = new Polynomial();
        p1.Create("x3 + x2 + 2*x1 + 1");
        p2.Create("x2 + 1");
        res = PolynomialController.Remainder(p1, p2);
        assertEquals("+ 1.0*x1 ", res.toString());
        res = new Polynomial();
        res = PolynomialController.Remainder(p2, p1);
        assertEquals(p2.toString(), res.toString());
    }

    @Test
    public void derive() {
        p1 = new Polynomial();
        p1.Create("x3 + x2 + 2*x1 + 1");
        res = PolynomialController.Derive(p1);
        assertEquals("2.0 + 2.0*x1 + 3.0*x2 ", res.toString());
    }

    @Test
    public void integrate() {
        p1 = new Polynomial();
        p1.Create("x3 + x2 + 2*x1 + 1");
        res = PolynomialController.Integrate(p1);
        assertEquals("+ 1.0*x1 + 1.0*x2 + 0.3333333333333333*x3 + 0.25*x4 ", res.toString());
    }
}