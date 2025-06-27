package user;

import java.time.LocalDate;
import java.util.List;

import Enums.EUserState;

public interface IUserState {
	
	public abstract EUserState getExpertise();
	
	public abstract void statCheck(User user);
	

}
