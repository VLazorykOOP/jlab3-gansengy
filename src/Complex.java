public class Complex extends Pair {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        try {
            if (Double.isNaN(real) || Double.isNaN(imaginary)) {
                throw new IllegalArgumentException("Invalid input. Arguments cannot be NaN.");
            }
            if (Double.isInfinite(real) || Double.isInfinite(imaginary)) {
                throw new IllegalArgumentException("Invalid input. Arguments cannot be Infinite.");
            }
            this.real = real;
            this.imaginary = imaginary;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Pair add(Pair other) {
        Complex c = (Complex)other;
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    }

    public Pair subtract(Pair other) {
        Complex c = (Complex)other;
        return new Complex(this.real - c.real, this.imaginary - c.imaginary);
    }

    public Pair multiply(Pair other) {
        Complex c = (Complex)other;
        double real = this.real * c.real - this.imaginary * c.imaginary;
        double imaginary = this.real * c.imaginary + this.imaginary * c.real;
        return new Complex(real, imaginary);
    }

    public String toString() {
        return "(" + real + " + " + imaginary + " * i)";
    }

    public boolean equals(Object other) {
        if (other instanceof Complex) {
            Complex c = (Complex)other;
            return this.real == c.real && this.imaginary == c.imaginary;
        }
        return false;
    }
}

