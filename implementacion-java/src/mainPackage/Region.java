package mainPackage;
import java.util.ArrayList;
import java.util.List;
import position.*;
import sample.*;
import java.util.stream.*;

import ar.edu.unq.poo2.tpintegrador.organizaciones.EventManager;

public class Region {
    private Position center;
    private double radius; //expresado en km
    private String name;
    private List<Sample> samples = new ArrayList<Sample>();
    private EventManager events;
    
    
    public Region(Position center, double radius, String name, EventManager events) {
    	this.center = center;
    	this.radius = radius;
    	this.name = name;
    	this.events = events;
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

    public void addSample(Sample sample) {
    	if(this.isPosInside(sample.getLocation())) {
    		samples.add(sample);
    	}
    }
    
    public List<Sample> getSamples() {
    	return samples;
    }
    
    
    public void notify(String eventType, Sample sample) {
    	events.notify(eventType, sample, this);
    }
    
    public Position getCenter() {
    	return this.center;
    }
    
    public double getRadius() {
    	return this.radius;
    }
 
    public boolean isPosInside(Position position) {
    	double distanciaKm = position.getDistanceTo(center, new Kilometers());
        double radioKm = this.getRadius();
       // System.out.println("Distancia (km): " + distanciaKm + " | Radio (km): " + radioKm);
        return distanciaKm <= radioKm;
    
    }
}