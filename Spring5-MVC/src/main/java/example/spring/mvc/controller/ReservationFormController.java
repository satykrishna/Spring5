package example.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import example.spring.mvc.models.Reservation;
import example.spring.mvc.service.ReservationService;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {
	
	@Autowired
	private  ReservationService reservationService;
	
	@GetMapping
	public void setupForm(Model model ) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
	}
	
	@PostMapping
	public String submitForm(
			@ModelAttribute("reservation") Reservation reservation,
			BindingResult bindingResult, SessionStatus status) {
		reservationService.make(reservation);
		return "redirect:reservationSuccess";
	}
	

}
