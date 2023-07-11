package org.example.Model;

import org.junit.Test;

import static org.example.Model.Polynomial.Pos;
import static org.junit.Assert.*;

public class PolynomialTest {

    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();
    String polynomial1 = "x2 + 2*x1 + 1";
    String polynomial2 = "x2 - 2*x1 + 1";


    @Test
    public void toStringTest() {
        p1 = new Polynomial();
        p1.p.put(2, 1.0);
        p1.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        String pol = "1.0 + 2.0*x1 + 1.0*x2 ";
        assertEquals(pol, p1.toString());
    }

    @Test
    public void pos() {
        String monomial = "234*x34";
        assertEquals(4, Pos(monomial));
        monomial = "2341*x4351";
        assertEquals(5, Pos(monomial));
    }

    @Test
    public void create() {
        p1 = new Polynomial();
        p1.p.put(2, 1.0);
        p1.p.put(1, 2.0);
        p1.p.put(0, 1.0);
        Polynomial aux = new Polynomial();
        aux.Create(polynomial1);
        assertEquals(p1.toString(), aux.toString());
        p1.p.put(3, -1.0);
        String polynomialMinus = "1.0 + 2.0*x1 + 1.0*x2 - 1*x3";
        aux = new Polynomial();
        aux.Create(polynomialMinus);
        assertEquals(p1.toString(), aux.toString());
    }

    @Test
    public void max() {
        p1 = new Polynomial();
        p1.p.put(5, 2.0);
        assertEquals(5, p1.max());
        p1.p.put(6, 4.0);
        assertEquals(6, p1.max());
        p1.p.put(7, 3.0);
        assertEquals(7, p1.max());
    }

    @Test
    public void onlyZero() {
        p1 = new Polynomial();
        p1.p.put(0, 0.0);
        p1.p.put(1, 0.0);
        p1.p.put(2, 0.0);
        p1.p.put(3, 0.0);
        assertEquals(true, p1.onlyZero());
        p1.p.put(4, 1.0);
        assertEquals(false, p1.onlyZero());
    }
}