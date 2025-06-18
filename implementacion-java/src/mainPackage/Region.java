package mainPackage;
import java.util.List;
import position.*;
import sample.*;

public class Region {
    private Position center;
    private double radius; //expresado en km
    private String name;
    
    public Region(Position center, double radius, String name) {
    	this.center = center;
    	this.radius = radius;
    	this.name = name;
    }

    public List<Region> checkOverlaps(List<Region> regions) {

    }

    public List<Sample> getSamplesInRegion(List<Sample> samples) {
        return this.getCenter().getSamplesInRangeToMe(samples, this.getRadius(), new Kilometers());
    }

    //public void notify(String eventType);
    
    public Position getCenter() {
    	return this.center;
    }
    
    public double getRadius() {
    	return this.radius;
    }
}