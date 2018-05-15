package example.spring.mvc.service;

import java.util.List;

import example.spring.mvc.exception.ReservationNotAvailableException;
import example.spring.mvc.models.PeriodicReservation;
import example.spring.mvc.models.Reservation;

public interface ReservationService {
	
	public abstract List<Reservation> query(String courtName);

	public abstract void makePeriodicReservation(PeriodicReservation reservation)
	 throws ReservationNotAvailableException;

	public abstract void make(Reservation reservation) throws ReservationNotAvailableException;

}
