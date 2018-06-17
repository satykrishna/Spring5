package example.spring.mvc.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import example.spring.mvc.models.SportType;
import example.spring.mvc.service.ReservationService;

public class SportTypeConverter implements Converter<String, SportType> {

	@Autowired
	private ReservationService reservationService;
	
	public SportTypeConverter(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@Override
	public SportType convert(String source) {
		int sportTypeId = Integer.parseInt(source);
		SportType sportType = reservationService.getSportType(sportTypeId);
		return sportType;
	}

}
