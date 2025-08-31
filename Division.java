public class Division extends Calculator {
    public Division(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calculate() {
        if (num2 ==0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return num1/num2;
    }
    
}
