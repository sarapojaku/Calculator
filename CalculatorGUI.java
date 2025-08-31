import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Components
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("*");
        JButton divBtn = new JButton("/");

        // Actions
        addBtn.addActionListener(e -> calculate(new Addition(getNum1(), getNum2())));
        subBtn.addActionListener(e -> calculate(new Subtraction(getNum1(), getNum2())));
        mulBtn.addActionListener(e -> calculate(new Multiplication(getNum1(), getNum2())));
        divBtn.addActionListener(e -> {
            try {
                calculate(new Division(getNum1(), getNum2()));
            } catch (Exception ex) {
                resultField.setText("Error: " + ex.getMessage());
            }
        });

        // Layout
        add(new JLabel("Number 1:"));
        add(num1Field);
        add(new JLabel("Number 2:"));
        add(num2Field);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);
        add(new JLabel("Result:"));
        add(resultField);

        setVisible(true);
    }

    private double getNum1() {
        return Double.parseDouble(num1Field.getText());
    }

    private double getNum2() {
        return Double.parseDouble(num2Field.getText());
    }

    private void calculate(Calculator calc) {
        try {
            resultField.setText(String.valueOf(calc.calculate()));
        } catch (Exception e) {
            resultField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
