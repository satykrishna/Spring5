package example.spring.mvc.service;

import java.util.List;

import example.spring.mvc.exception.ReservationNotAvailableException;
import example.spring.mvc.models.PeriodicReservation;
import example.spring.mvc.models.Reservation;
import example.spring.mvc.models.SportType;

public interface ReservationService {
	
	public abstract List<Reservation> query(String courtName);

	public abstract void makePeriodicReservation(PeriodicReservation reservation)
	 throws ReservationNotAvailableException;

	public abstract void make(Reservation reservation) throws ReservationNotAvailableException;

	public abstract List<SportType> getAllSportTypes();
	
	public abstract SportType getSportType(int sportType);
}
