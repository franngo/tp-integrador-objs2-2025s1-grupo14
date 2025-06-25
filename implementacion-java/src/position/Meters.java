package position;

public class Meters implements MeasureUnit {
    @Override
    public double convert(double kms) {
        return kms * 1000;
    }
}