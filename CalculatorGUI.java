import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // --- Top panel for input ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBackground(new Color(230, 230, 250)); // light lavender

        inputPanel.add(new JLabel("Number 1:", SwingConstants.RIGHT));
        inputPanel.add(num1Field);
        inputPanel.add(new JLabel("Number 2:", SwingConstants.RIGHT));
        inputPanel.add(num2Field);
        inputPanel.add(new JLabel("Result:", SwingConstants.RIGHT));
        inputPanel.add(resultField);

        // --- Center panel for buttons ---
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("*");
        JButton divBtn = new JButton("/");

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        addBtn.setFont(buttonFont);
        subBtn.setFont(buttonFont);
        mulBtn.setFont(buttonFont);
        divBtn.setFont(buttonFont);

        addBtn.setBackground(new Color(173, 216, 230)); // light blue
        subBtn.setBackground(new Color(144, 238, 144)); // light green
        mulBtn.setBackground(new Color(255, 182, 193)); // light pink
        divBtn.setBackground(new Color(255, 255, 150)); // light yellow

        buttonPanel.add(addBtn);
        buttonPanel.add(subBtn);
        buttonPanel.add(mulBtn);
        buttonPanel.add(divBtn);

        // --- Add action listeners ---
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

        // --- Add panels to frame ---
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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

