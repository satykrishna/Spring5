package example.spring.mvc.service;

import java.util.List;

import example.spring.mvc.models.Reservation;

public interface ReservationService {
	
	public abstract List<Reservation> query(String courtName);

}
