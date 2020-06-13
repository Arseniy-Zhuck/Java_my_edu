public class ComplexNumber {
    private final double im;
    private final double re;

    public ComplexNumber(double im, double re) {
        this.im = im;
        this.re = re;
    }


    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ComplexNumber)) return false;
        else {
            ComplexNumber complexNumber = (ComplexNumber) object;
            return ((this.getRe()==complexNumber.getRe())&&(this.getIm()==complexNumber.getIm()));
        }

    }
    @Override
    public int hashCode() {
        Double reDouble = getRe();
        Double imDouble = getIm();
        return reDouble.hashCode()+imDouble.hashCode();
    }

}
