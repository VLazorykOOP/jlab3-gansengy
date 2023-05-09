public class Rational1 implements Pair1 {
    private int numerator;
    private int denominator;
    public Rational1(int numerator, int denominator) {
        try {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero");
            }
            this.numerator = numerator;
            this.denominator = denominator;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Pair1 add(Pair1 other) {
        Rational1 r = (Rational1)other;
        int lcm = getLCM(this.denominator, r.denominator);
        int newNumerator = this.numerator * lcm / this.denominator + r.numerator * lcm / r.denominator;
        return new Rational1(newNumerator, lcm);
    }

    public Pair1 subtract(Pair1 other) {
        Rational1 r = (Rational1)other;
        int lcm = getLCM(this.denominator, r.denominator);
        int newNumerator = this.numerator * lcm / this.denominator - r.numerator * lcm / r.denominator;
        return new Rational1(newNumerator, lcm);
    }

    public Pair1 multiply(Pair1 other) {
        Rational1 r = (Rational1)other;
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Rational1(newNumerator, newDenominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Object other) {
        if (other instanceof Rational1) {
            Rational1 r = (Rational1)other;
            return this.numerator == r.numerator && this.denominator == r.denominator;
        }
        return false;
    }

    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
