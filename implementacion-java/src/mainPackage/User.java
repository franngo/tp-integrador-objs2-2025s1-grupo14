import sample.Sample;

abstract public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    public Sample uploadSample(String photo, EVinchuca specie, Position location) {
        Sample sample = new Sample(photo, specie, this.getName(), location);
        //ahora hace la review inicial sobre la Sample que acaba de "subir" 
        this.review(sample, specie); //acá le estoy pasando un EVinchuca en vez de un Opinion Value. habría que ver cómo convertirlo a Op Val
        return sample;
    }

    public void review(Sample sample, OpinionValue opinion) {
        sample.addReview(opinion, this.getExpertise(), this.getName());  //acá, si no se puede agregar review, tira excepción y la review nunca se añade a la de esa Sample
        //creo que está mejor pasarle los parámetros, primero validar (con isValid) si se puede cargar una review para dicha muestra, y, si
        //se puede, ahí la generamos y la cargamos. Sino, estaríamos generando siempre una Review, pero en algunas ocasiones nos la van
        //a terminar descartando si no pasa la validación en Sample (lo digo xq en el anterior UML pasabamos una Review ya generada y, por
        //tanto, la validación se hacía sobre la Review ya generada, la cual podía terminar descartada.
    }

    abstract protected String getExpertise();
}