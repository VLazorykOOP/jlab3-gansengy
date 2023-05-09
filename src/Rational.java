public class Rational extends Pair {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
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

    public Pair add(Pair other) {
        Rational r = (Rational) other;
        int lcm = getLCM(this.denominator, r.denominator);
        int newNumerator = this.numerator * lcm / this.denominator + r.numerator * lcm / r.denominator;
        return simplify(new Rational(newNumerator, lcm));
    }

    public Pair subtract(Pair other) {
        Rational r = (Rational) other;
        int lcm = getLCM(this.denominator, r.denominator);
        int newNumerator = this.numerator * lcm / this.denominator - r.numerator * lcm / r.denominator;
        return simplify(new Rational(newNumerator, lcm));
    }

    public Pair multiply(Pair other) {
        Rational r = (Rational) other;
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return simplify(new Rational(newNumerator, newDenominator));
    }

    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    public boolean equals(Object other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            return this.numerator == r.numerator && this.denominator == r.denominator;
        }
        return false;
    }

    private int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return Math.abs(a * b) / gcd;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private Rational simplify(Rational rational) {
        int gcd = getGCD(rational.numerator, rational.denominator);
        return new Rational(rational.numerator / gcd, rational.denominator / gcd);
    }
}
