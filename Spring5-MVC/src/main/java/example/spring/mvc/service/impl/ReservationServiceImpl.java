package example.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.*;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import example.spring.mvc.models.Player;
import example.spring.mvc.models.Reservation;
import example.spring.mvc.models.SportType;
import example.spring.mvc.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);

	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccer");
	private final List<Reservation> reservations = new ArrayList<>();

	@Override
	public List<Reservation> query(String courtName) {
		return reservations.stream().filter(reservation-> Objects.equals(reservation.getCourtName(), courtName))
				.collect(toList());
	}

	@PostConstruct
	public void init() {

		reservations.addAll(Arrays.asList(new Reservation("Tennis#1", new Date(2018, 10, 21), 16, new Player("Roger", "N/A"), TENNIS),
				new Reservation("Tennis#2", new Date(2018, 10, 12), 20, new Player("James", "N/A"), TENNIS)));

	}
}