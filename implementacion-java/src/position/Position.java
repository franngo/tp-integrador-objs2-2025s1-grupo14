package position;
import java.util.List;
import java.util.stream.*;

import mainPackage.App;
import mainPackage.Region;
import sample.*;

public class Position {
    private double latitude; //expresada en grados decimales
    private double longitude; //expresada en grados decimales
    
    //prueba
    private App system;
    
    public Position(double latitude, double longitude, App system) {
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.system = system;
    }

    //1.
    /*Aclaración: Debido al pequeño márgen de error del cálculo, se decide redondear la cifra al entero más cercano.
     * Por tanto, se retorna un int en vez de un double.
     */
    public double getDistanceTo(Position position, MeasureUnit mu) {   
        int radioTierraEnKm = 6371; //radio promedio de la Tierra en km
        //Se utiliza la fórmula del semiverseno para calcular la distancia entre dos coordenadas geográficas expresadas en grados decimales.
        //d = R * 2 * arcsin(√(sin²((lat2 - lat1)/2) + cos(lat1) * cos(lat2) * sin²((lon2 - lon1)/2)))
        //(se requiere que ambas latitudes y longitudes se conviertan a radianes)
        //la fórmula devuelve la distancia en kilómetros. Si se desea la distancia en metros, se la debe convertir antes de retornarla
        double lat1 = Math.toRadians(this.getLatitude());
        double lon1 = Math.toRadians(this.getLongitude());
        double lat2 = Math.toRadians(position.getLatitude());
        double lon2 = Math.toRadians(position.getLongitude());
        double difLat = lat2 - lat1;
        double difLon = lon2 - lon1;

        double paraRaizTerm1= Math.pow(Math.sin(difLat / 2), 2);
        double paraRaizTerm2= Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(difLon / 2), 2);
        double paraRaiz = paraRaizTerm1 + paraRaizTerm2;
        /*En vez de calcular el arcoseno sobre la raíz (como en la fórmula), se usa un equivalente en el que se utiliza el arcotangente con
        signo de ambos valores ( arctan2(paraRaiz, √1-paraRaiz ) debido que mejora la estabilidad numérica.
        En vez de Math.asin(Math.sqrt(paraRaiz)), se realiza Math.atan2(Math.sqrt(paraRaiz), Math.sqrt(1 - paraRaiz)), que es equivalente 
        por identidad trigonométrica. Esta operación (Math.atan2(y,x)) calcula el ángulo cuya tangente es y / x considerando el signo de 
        y y x para determinar el cuadrante correcto.      
        */
        double anguloCentral = 2 * Math.atan2(Math.sqrt(paraRaiz), Math.sqrt(1 - paraRaiz)); //ángulo central entre las 2 coordenadas geográficas
        double distanciaEnKm = radioTierraEnKm * anguloCentral;
        
        int entero = (int) Math.round(distanciaEnKm);
        return mu.convert(entero);
    }

    //2.
    public List<Position> positionsInRangeToMe(List<Position> positions, double radius, MeasureUnit mu) {
    	return positions.stream().
    			filter((p) -> this.getDistanceTo(p, mu) <= radius).
    			collect(Collectors.toList());
    }

    //el punto 3 del apartado Ubicación del pdf me da a entender que Sample tiene que tener un comportamiento que 
    //le delega a su position
    /*
    public class Sample() {
    	...
    	public List<Sample> getSamplesInRange(List<Sample> samples, double radius, MeasureUnit mu) {
        	return this.location.getSamplesIn(samples, radius, mu);
    	}
    }
    */
    
    public List<Sample> getSamplesInRangeToMe(List<Sample> samples, double radius, MeasureUnit mu) {
    	return samples.stream().
    			filter((s) -> this.getDistanceTo(s.getLocation(), mu) <= radius).
    			collect(Collectors.toList());
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
    
    public List<Region> getRegions(App system){
    	return system.getRegions().stream().filter(r -> r.isPosInside(this)).toList();
    }
    
    public App getApp() {
    	return system;
    }
}
