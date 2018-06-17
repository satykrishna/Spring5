package example.spring.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import example.spring.mvc.models.Reservation;

import static org.springframework.validation.ValidationUtils.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Reservation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		rejectIfEmpty(errors, "courtName", "required.courtName", "Court Name is required");
		rejectIfEmpty(errors, "date", "required.date", "Date is required");
		rejectIfEmpty(errors, "hour", "required.hour", "hour is required");
		rejectIfEmptyOrWhitespace(errors, "player.name", "required.playerName", "player name is required");
		rejectIfEmpty(errors, "sportType", "required.sportType", "sport type is required" );
		
		Reservation reservation = (Reservation)target;
		
		Date d = reservation.getDate();
		
		LocalDate date = LocalDate.parse(d.toString());
		
		int hour = reservation.getHour();
		
		if(date != null ) {
			if(date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				if(hour < 8 || hour > 22) {
					errors.reject("invalid.holidayHour", "Invalid Holiday Hour");
				}
			}else {
				if(hour < 9 || hour > 21 ) {
					errors.reject("invalid.weekdayHour", "Invalid weekday hour");
				}
			}
		}
		
		
	}

}
