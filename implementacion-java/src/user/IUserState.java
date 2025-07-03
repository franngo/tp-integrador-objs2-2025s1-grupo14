package user;

import Enums.EUserState;

public interface IUserState {
	
	public abstract EUserState getExpertise();
	
	public abstract void statCheck(User user);
	

}
