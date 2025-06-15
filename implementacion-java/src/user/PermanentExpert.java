package user;

import mainPackage.App;

public class PermanentExpert extends User {

    public PermanentExpert (String name, App system) {
        super(name, system);
        state = new Expert();
    }

    @Override
    public String getExpertise() {
        return state.getExpertise();
    }

	@Override
	protected void uploadedReviewsDates() {
		
	}
}