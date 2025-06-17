package mainPackage;
import java.util.List;
import position.*;
import sample.*;

public class Region {
    private Position center;
    private double radius; //expresado en km
    private String name;

    public List<Region> checkOverlaps(List<Region> regions) {

    }

    public List<Sample> getSamplesIn(List<Sample> samples) {
        return this.center.getSamplesIn(samples, radius, new Kilometers());
    }

    //public void notify(String eventType);
}