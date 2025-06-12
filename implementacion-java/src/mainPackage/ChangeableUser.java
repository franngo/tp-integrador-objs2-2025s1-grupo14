import sample.Sample;

public class ChangeableUser extends User {
    private IUserState expertLevel;
    private List<Date> uploadedSamplesDates = new ArrayList();  //esto es para el cálculo statCheck(), para ver si cambió de nivel
    private List<Date> uploadedReviewsDates = new ArrayList();  //esto es para el cálculo statCheck(), para ver si cambió de nivel

    public ChangeableUser (String name) {
        super(name);
    }

    @Override
    public Sample uploadSample(String photo, EVinchuca specie, Position location) {
        super(photo, specie, location);
        uploadedSamplesDates.add(new Date()); //hay que cargar la Date actual
    }

    @Override
    public void review(Sample sample, OpinionValue opinion) {
        this.statCheck(); //para ver si se tiene que actualizar el state
        super(sample, opinion);
        uploadedReviewsDates.add(new Date()); //hay que cargar la Date actual
    }

    @Override
    protected String getExpertise() {
        return expertLevel.getExpertise(); //si es Basic retornará "basic user" y si es Expert retornará "expert user"
    }

    private void statCheck() {
        expertLevel.statCheck(this, uploadedSamplesDates, uploadedReviewsDates);
        //cambia o no cambia dependiendo de si las 20 reviews más reciente son todas hechas en los últimos nosecuantos días y las 10 
        //samples más recientes son todas hechas también en los últimos nosecuantos días.
    }
}