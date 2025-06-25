package mainPackage;
import java.util.List;
import position.*;
import sample.*;
import java.util.stream.*;

import ar.edu.unq.poo2.tpintegrador.organizaciones.EventManager;

public class Region {
    private Position center;
    private double radius; //expresado en km
    private String name;
    private EventManager events;
    
    public Region(Position center, double radius, String name) {
    	this.center = center;
    	this.radius = radius;
    	this.name = name;
    }

    /*Para el cálculo, se verifica con cada Region de la lista si la distancia entre el centro de la Region actual
     * y el de la Region analizada es menor que la suma de sus radios.
     */
    public List<Region> checkOverlaps(List<Region> regions) {
    	return regions.stream().
    			filter((r) -> this.getCenter().getDistanceTo(r.getCenter(), new Kilometers()) < 
    					(this.getRadius() + r.getRadius())).
    			collect(Collectors.toList());
    }

    public List<Sample> getSamplesInRegion(List<Sample> samples) {
        return this.getCenter().getSamplesInRangeToMe(samples, this.getRadius(), new Kilometers());
    }

    public void notify(String eventType) {
    	events.notify(eventType, this);
    }
    
    public Position getCenter() {
    	return this.center;
    }
    
    public double getRadius() {
    	return this.radius;
    }
}