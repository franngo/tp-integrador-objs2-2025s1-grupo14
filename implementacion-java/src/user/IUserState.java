package user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public abstract class IUserState {
	
	public abstract String getExpertise();
	
	
	public abstract void statCheck(ChangeableUser user, List<LocalDate> samples, List<LocalDate> reviews);
	
	public double cantidadDeFechasEntreDias(List<LocalDate> dates, int days) {
		return dates.stream().filter(date -> this. estaFechaEntreDias(date, days)).count();
	}
	
	protected boolean estaFechaEntreDias(LocalDate date, int days) {
		return date.isBefore(LocalDate.now().plusDays(1)) && date.isAfter(LocalDate.now().minusDays(days));
	}
}
