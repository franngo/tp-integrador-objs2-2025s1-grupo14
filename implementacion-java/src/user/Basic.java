package user;


import Enums.EUserState;

public class Basic implements IUserState{

	@Override
	public EUserState getExpertise() {
		return EUserState.Basic;
	}

	@Override
	public void statCheck(User user) {
		if(user.cantidadDeFechasEntreDias(user.getSampleDates(), 30) > 10 && user.cantidadDeFechasEntreDias(user.getReviewsDates(), 30) > 20) {
			user.changeState(new Expert());
		
		}
	}


}
