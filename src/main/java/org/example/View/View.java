package org.example.View;

import org.example.BusinessLogic.PolynomialController;
import org.example.EmptyFieldException;
import org.example.Model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton deriveButton;
    private JButton integrateButton;
    private JButton help;
    private JTextField textFirst;
    private JLabel firstP;
    private JTextField textSecond;
    private JLabel secondP;
    private JTextField textResult;
    private JLabel result;
    private JPanel helpPanel;

    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel window;

    public View() {
        addButton = new JButton("ADD");
        addButton.setBackground(new Color(235,235,235));
        substractButton = new JButton("SUBSTRACT");
        substractButton.setBackground(new Color(235,235,235));
        divideButton = new JButton("DIVIDE");
        divideButton.setBackground(new Color(235,235,235));
        multiplyButton = new JButton("MULTIPLY");
        multiplyButton.setBackground(new Color(235,235,235));
        deriveButton = new JButton("DERIVE");
        deriveButton.setBackground(new Color(235,235,235));
        integrateButton = new JButton("INTEGRATE");
        integrateButton.setBackground(new Color(235,235,235));
        help = new JButton("HELP");
        help.setBackground(new Color(235,235,235));

        textFirst = new JTextField("");
        textFirst.setBackground(new Color(230, 255, 255));
        textSecond = new JTextField("");
        textSecond.setBackground(new Color(230, 255, 255));
        textResult = new JTextField();
        textResult.setBackground(new Color(230, 255, 255));
        firstP = new JLabel("First Polynomial:");
        secondP = new JLabel("Second Polynomial:");
        result = new JLabel("Result:");

        textPanel = new JPanel(new GridLayout(6, 1));
        textPanel.setBackground(new Color(255, 255, 255));
        buttonPanel = new JPanel(new GridLayout(3, 2));
        window = new JPanel(new GridLayout(2, 1));

        helpPanel = new JPanel(new GridLayout(1, 2));
        helpPanel.setBackground(new Color(255, 255, 255));
        helpPanel.add(firstP);
        helpPanel.add(help);
        textPanel.add(helpPanel);
        textPanel.add(textFirst);
        textPanel.add(secondP);
        textPanel.add(textSecond);
        textPanel.add(result);
        textPanel.add(textResult);

        buttonPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("") || textSecond.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    Polynomial polynomial1 = new Polynomial();
                    polynomial1.Create(textFirst.getText());
                    Polynomial polynomial2 = new Polynomial();
                    polynomial2.Create(textSecond.getText());
                    Polynomial add = new Polynomial();
                    add = PolynomialController.Add(polynomial1, polynomial2);
                    textResult.setText(add.toString());

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(substractButton);
        substractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("") || textSecond.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    Polynomial polynomial1 = new Polynomial();
                    polynomial1.Create(textFirst.getText());
                    Polynomial polynomial2 = new Polynomial();
                    polynomial2.Create(textSecond.getText());
                    Polynomial substract = new Polynomial();
                    substract = PolynomialController.Subtract(polynomial1, polynomial2);
                    textResult.setText(substract.toString());

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(multiplyButton);
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("") || textSecond.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    Polynomial polynomial1 = new Polynomial();
                    polynomial1.Create(textFirst.getText());
                    Polynomial polynomial2 = new Polynomial();
                    polynomial2.Create(textSecond.getText());
                    Polynomial multiply = new Polynomial();
                    multiply = PolynomialController.Multiply(polynomial1, polynomial2);
                    textResult.setText(multiply.toString());

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(divideButton);
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("") || textSecond.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    else {
                        Polynomial polynomial1 = new Polynomial();
                        polynomial1.Create(textFirst.getText());
                        Polynomial polynomial2 = new Polynomial();
                        polynomial2.Create(textSecond.getText());
                        Polynomial divide = new Polynomial();
                        divide = PolynomialController.Divide(polynomial1, polynomial2);
                        textResult.setText(divide.toString());
                        Polynomial remainder = new Polynomial();
                        remainder = PolynomialController.Remainder(polynomial1, polynomial2);
                        if (!remainder.onlyZero()) {
                            textResult.setText(textResult.getText() + " Remainder:" + remainder.toString());
                        }
                    }

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(deriveButton);
        deriveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    Polynomial polynomial1 = new Polynomial();
                    polynomial1.Create(textFirst.getText());
                    Polynomial derive = new Polynomial();
                    derive = PolynomialController.Derive(polynomial1);
                    textResult.setText(derive.toString());
                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(integrateButton);
        integrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textFirst.getText().equals("")) {
                        throw new EmptyFieldException("Empty Field!");
                    }
                    Polynomial polynomial1 = new Polynomial();
                    polynomial1.Create(textFirst.getText());
                    Polynomial integral = new Polynomial();
                    integral = PolynomialController.Integrate(polynomial1);
                    textResult.setText(integral.toString() + "+ c");

                } catch (EmptyFieldException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "EMPTY FIELD!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Help helpWindow = new Help();
                dispose();
            }
        });
        window.add(textPanel);
        window.add(buttonPanel);

        this.add(window);

        setTitle("Calculator");
        setSize(480, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
