package example.spring.mvc.controller;

import static java.util.Collections.*;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.models.Reservation;
import example.spring.mvc.service.ReservationService;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(method=GET)
	public void setupForm() {
		
	}
	
	@RequestMapping(method=POST)
	public String submitForm(@RequestParam("courtName") String courtName,
			Model model) {
		List<Reservation> reservations = emptyList();
		if(isNotEmpty(courtName)) {
			reservations = reservationService.query(courtName);
		}
		model.addAttribute("reservations", reservations);
		
		return "reservationQuery";
	}
	
}

