package org.example.Model;

import org.example.BusinessLogic.PolynomialController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public Map<Integer, Double> p;

    public Polynomial() {
        this.p = new HashMap<>();
    }

    /*
    public Polynomial(String text){
        if(text.equals("")){
            this.p = null;
            return;
        }
        Map<Integer,Double> coef = new HashMap<>();
        text = text.replace("*","");
        text = text.replace(" ","");
        String[] poly1Split = text.split("(?=[+-])");
        for(String term : poly1Split){
            String[] coefPower = term.split("x");
            coef.put(coefPower.length==1 || coefPower[1].equals("") ? 0 : Integer.parseInt(coefPower[1]),
                    Double.parseDouble(coefPower[0].equals("") || "+-".contains(coefPower[0]) ? coefPower[0] + "1" : coefPower[0]));
        }
        this.p = coef;
    }
    */

    public static int Pos(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'x')
                return i;
        }
        return -1;
    }

    public void Create(String text) {
        Scanner scanner = new Scanner(text);
        String word;
        double sign = 1;
        while (scanner.hasNext()) {
            word = scanner.next();
            if (!word.equals("-") && !word.equals("+")) {
                int pos = Pos(word);
                if (pos == 0) {
                    String power = word.substring(pos + 1);
                    this.p.put(Integer.parseInt(power), sign);
                } else if (pos == -1) {
                    this.p.put(0, sign * Double.parseDouble(word));
                } else {
                    String coeff = word.substring(0, pos - 1);
                    String power = word.substring(pos + 1);
                    this.p.put(Integer.parseInt(power), sign * Double.parseDouble(coeff));
                }
            } else if (word.equals("+")) {
                sign = 1;
            } else {
                sign = -1;
            }
        }
    }

    @Override
    public String toString() {
        String p = new String();
        for (Map.Entry<Integer, Double> entry : this.p.entrySet()) {
            if (entry.getValue() != 0) {
                if (entry.getKey() == 0) {
                    p = entry.getValue().toString() + " ";
                } else {
                    if (entry.getValue() > 0) {
                        p = p + "+ " + entry.getValue().toString() + "*x" + entry.getKey().toString() + " ";
                    } else {
                        String number = entry.getValue().toString();
                        number = number.substring(1);
                        p = p + "- " + number + "*x" + entry.getKey().toString() + " ";
                    }
                }
            }
        }
        return p;
    }

    public int max() {
        int maximum = 0;
        for (Map.Entry<Integer, Double> entry : this.p.entrySet()) {
            if (entry.getKey() > maximum && entry.getValue() != 0) {
                maximum = entry.getKey();
            }
        }
        return maximum;
    }

    public boolean onlyZero() {
        for (Map.Entry<Integer, Double> entry : this.p.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
