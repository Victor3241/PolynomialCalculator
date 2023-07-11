package org.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JFrame {
    private JTextArea polynomials;
    private JTextArea addButton;
    private JButton back;
    private JPanel textPanel;
    private String write = "Writting polynomials needs to follow certain rules:\n" +
            "Every monomial has to be written like this [coefficient]*x[power]\n" +
            "Between monomials there has to be either a + or a -.\n" +
            "For any button to work the polynomials have to be valid.";
    private String buttons = "When any button is pressed the polynomial from the first\n" +
            "text field and the polynomial from the second text field will be\n" +
            "added, subtracted, multiplied, divided or the first polynomial will be\n" +
            "derived or integrated and their result will be shown in the\n" +
            "result text field.";

    public Help(){
        polynomials = new JTextArea(write);
        addButton = new JTextArea(buttons);

        back = new JButton("BACK");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View view = new View();
                dispose();
            }
        });

        textPanel = new JPanel(new GridLayout(3, 1));
        textPanel.add(polynomials);
        textPanel.add(addButton);
        textPanel.add(back);

        this.add(textPanel);

        setTitle("Help Window");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
