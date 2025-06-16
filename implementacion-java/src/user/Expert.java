package user;

import java.time.LocalDate;
import java.util.List;

public class Expert implements IUserState{

	@Override
	public String getExpertise() {
		return "Expert";
	}

	@Override
	public void statCheck(ChangeableUser user, List<LocalDate> samples, List<LocalDate> reviews) {
		if(user.cantidadDeFechasEntreDias(samples, 30) < 10 || user.cantidadDeFechasEntreDias(reviews, 30) < 20) {		
			user.setState(new Basic());
		
		}
	}


}
