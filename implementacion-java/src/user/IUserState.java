package user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IUserState {
	
	public abstract String getExpertise();
	
	public abstract void statCheck(ChangeableUser user, List<LocalDate> samples, List<LocalDate> reviews);
	

}
