package org.example.BusinessLogic;

import org.example.Model.Polynomial;

import java.util.Map;

public class PolynomialController {

    public static Polynomial Add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.p.entrySet()) {
            result.p.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Double> entry : p2.p.entrySet()) {
            if (result.p.get(entry.getKey()) == null) {
                result.p.put(entry.getKey(), entry.getValue());
            } else {
                result.p.put(entry.getKey(), result.p.get(entry.getKey()) + entry.getValue());
            }
        }
        return result;
    }

    public static Polynomial Subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.p.entrySet()) {
            result.p.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Double> entry : p2.p.entrySet()) {
            if (result.p.get(entry.getKey()) == null) {
                result.p.put(entry.getKey(), -1 * entry.getValue());
            } else {
                result.p.put(entry.getKey(), result.p.get(entry.getKey()) - entry.getValue());
            }
        }
        return result;
    }

    public static Polynomial Multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.p.entrySet())
            for (Map.Entry<Integer, Double> entry1 : p2.p.entrySet()) {
                if (result.p.get(entry.getKey() + entry1.getKey()) == null) {
                    result.p.put(entry.getKey() + entry1.getKey(), entry.getValue() * entry1.getValue());
                } else {
                    result.p.put(entry.getKey() + entry1.getKey(), result.p.get(entry.getKey() + entry1.getKey()) + entry.getValue() * entry1.getValue());
                }
            }
        return result;
    }

    public static Polynomial Divide(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        int size1 = p1.max();
        int size2 = p2.max();
        if (size1 >= size2) {
            for (int i = 0; i <= size1 - size2; i++) {
                Polynomial temp = new Polynomial();
                Integer power1 = p1.max();
                Integer power2 = p2.max();
                if (power1 - power2 >= 0) {
                    double coeff = p1.p.get(power1) / p2.p.get(power2);
                    Polynomial mono = new Polynomial();
                    mono.p.put(power1 - power2, coeff);
                    temp = Multiply(p2, mono);
                    p1 = Subtract(p1, temp);
                    if (result.p.size() != 0) {
                        result = Add(result, mono);
                    } else result = mono;
                }
            }
        } else {
            result = p1;
        }
        return result;
    }

    public static Polynomial Remainder(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        int size1 = p1.max();
        int size2 = p2.max();
        if (size1 >= size2) {
            for (int i = 0; i <= size1 - size2; i++) {
                Polynomial temp = new Polynomial();
                Integer power1 = p1.max();
                Integer power2 = p2.max();
                if (power1 - power2 >= 0) {
                    double coeff = p1.p.get(power1) / p2.p.get(power2);
                    Polynomial mono = new Polynomial();
                    mono.p.put(power1 - power2, coeff);
                    temp = Multiply(p2, mono);
                    p1 = Subtract(p1, temp);
                    if (result.p.size() != 0) {
                        result = Add(result, mono);
                    } else result = mono;
                }
            }
        } else {
            result = p1;
        }
        return p1;
    }

    public static Polynomial Derive(Polynomial p1) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.p.entrySet()) {
            if (entry.getKey() > 0) {
                result.p.put(entry.getKey() - 1, entry.getValue() * entry.getKey());
            }
        }
        return result;
    }

    public static Polynomial Integrate(Polynomial p1) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.p.entrySet()) {
            result.p.put(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
        }
        return result;
    }
}
