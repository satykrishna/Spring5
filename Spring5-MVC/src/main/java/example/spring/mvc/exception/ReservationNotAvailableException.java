package example.spring.mvc.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservationNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String courtName;
	
	private LocalDateTime localDateTime;
	
	private int hour;

	public ReservationNotAvailableException(String courtname, Date date, int hour) {
		
		this.courtName = courtname;
		this.localDateTime = LocalDateTime.parse(date.toString());
		this.hour = hour;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
}
