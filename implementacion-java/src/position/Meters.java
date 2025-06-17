package position;

public class Meters implements MeasureUnit {
    @Override
    public int convert(int kms) {
        return kms * 1000;
    }
}