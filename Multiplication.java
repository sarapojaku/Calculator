public class Multiplication extends Calculator {
    public Multiplication(double num1, double num2) {
    super(num1,num2);
    }

    @Override
    public double calculate() {
        return num1*num2;
    }
}
