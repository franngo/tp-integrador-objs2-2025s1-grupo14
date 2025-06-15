package user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Basic implements IUserState{

	@Override
	public String getExpertise() {
		// TODO Auto-generated method stub
		return "Basic";
	}

	@Override
	public void statCheck(ChangeableUser user, List<LocalDate> samples, List<LocalDate> reviews) {
		if(user.cantidadDeFechasEntreDias(samples, 30) > 10 && user.cantidadDeFechasEntreDias(reviews, 30) > 20) {
			
			user.setState(new Expert());
		
		}
	}


}
