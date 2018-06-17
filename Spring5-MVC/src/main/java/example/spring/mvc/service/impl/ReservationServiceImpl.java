package example.spring.mvc.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import example.spring.mvc.exception.ReservationNotAvailableException;
import example.spring.mvc.models.PeriodicReservation;
import example.spring.mvc.models.Player;
import example.spring.mvc.models.Reservation;
import example.spring.mvc.models.SportType;
import example.spring.mvc.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);

	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccer");
	private final List<Reservation> reservations = new ArrayList<Reservation>();

	@Override
	public List<Reservation> query(String courtName) {
		return reservations.stream().filter(reservation -> Objects.equals(reservation.getCourtName(), courtName)).collect(toList());
	}

	@PostConstruct
	public void init() {

		reservations.addAll(Arrays.asList(new Reservation("Tennis#1", new Date(2018, 10, 21), 16, new Player("Roger", "N/A"), TENNIS),
				new Reservation("Tennis#2", new Date(2018, 10, 12), 20, new Player("James", "N/A"), TENNIS)));

	}

	@Override
	public void makePeriodicReservation(PeriodicReservation periodicReservation) throws ReservationNotAvailableException {
		 LocalDate fromDate = periodicReservation.getFromDate();
		 while (fromDate.isBefore(periodicReservation.getToDate())) {
	            Reservation reservation = new Reservation();
	            reservation.setCourtName(periodicReservation.getCourtName());
	            reservation.setDate(new Date(fromDate.toString()));
	            reservation.setHour(periodicReservation.getHour());
	            reservation.setPlayer(periodicReservation.getPlayer());
	            make(reservation);
	            fromDate = fromDate.plusDays(periodicReservation.getPeriod());
	        }
	}

	@Override
	public void make(Reservation reservation) throws ReservationNotAvailableException {
		long count = reservations.stream().filter(made -> Objects.equals(made.getCourtName(), reservation.getCourtName()))
				.filter(made -> Objects.equals(made.getDate(), reservation.getDate())).
				filter(made -> made.getHour() == reservation.getHour()).count();
		if (count > 0) {
			throw new ReservationNotAvailableException(reservation.getCourtName(), reservation.getDate(), reservation.getHour());
		}
		else {
			reservations.add(reservation);
		}
	}

	@Override
	public List<SportType> getAllSportTypes() {
		return Arrays.asList(TENNIS, SOCCER);
	}

	@Override
	public SportType getSportType(int sportType) {
		
		switch (sportType) {
		case 1:
			return TENNIS;
		case 2:
			return SOCCER;
		default:
			return null;
		}
	}
}
