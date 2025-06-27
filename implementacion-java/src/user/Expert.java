package user;



import Enums.*;

public class Expert implements IUserState{

	@Override
	public EUserState getExpertise() {
		return EUserState.Expert;
	}

	@Override
	public void statCheck(User user) {
		if(user.cantidadDeFechasEntreDias(user.getSampleDates(), 30) < 10 || user.cantidadDeFechasEntreDias(user.getReviewsDates(), 30) < 20) {		
			user.changeState(new Basic());
		
		}
	}


}
