public class Complex1 implements Pair1 {
    private double real;
    private double imaginary;

    public Complex1(double real, double imaginary) {
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

    public Pair1 add(Pair1 other) {
        Complex1 c = (Complex1)other;
        return new Complex1(this.real + c.real, this.imaginary + c.imaginary);
    }

    public Pair1 subtract(Pair1 other) {
        Complex1 c = (Complex1)other;
        return new Complex1(this.real - c.real, this.imaginary - c.imaginary);
    }

    public Pair1 multiply(Pair1 other) {
        Complex1 c = (Complex1)other;
        double real = this.real * c.real - this.imaginary * c.imaginary;
        double imaginary = this.real * c.imaginary + this.imaginary * c.real;
        return new Complex1(real, imaginary);
    }

    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }

    public boolean equals(Object other) {
        if (other instanceof Complex1) {
            Complex1 c = (Complex1)other;
            return this.real == c.real && this.imaginary == c.imaginary;
        }
        return false;
    }
}