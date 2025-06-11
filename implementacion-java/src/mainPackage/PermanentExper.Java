public class PermanentExpert extends User {

    public PermanentExpert (String name) {
        super(name);
    }

    @Override
    protected String getExpertise() {
        return "permanent expert";
    }
}