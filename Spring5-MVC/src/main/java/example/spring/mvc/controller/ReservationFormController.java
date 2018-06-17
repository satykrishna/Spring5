package example.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import example.spring.mvc.models.Player;
import example.spring.mvc.models.Reservation;
import example.spring.mvc.models.SportType;
import example.spring.mvc.service.ReservationService;
import example.spring.mvc.validator.ReservationValidator;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController {
	
	@Autowired
	private  ReservationService reservationService;
	
	@Autowired
	private ReservationValidator reservationValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(reservationValidator);
	}
	
	@ModelAttribute("sportTypes")
	public List<SportType> populateSportTypes() {
		return reservationService.getAllSportTypes();
	}
	
	@GetMapping
	public void setupForm(Model model, @RequestParam(value = "userName", required = false) String userName) {
		Reservation reservation = new Reservation();
		reservation.setPlayer(new Player(userName, null));
		model.addAttribute("reservation", reservation);
		
	}
	
	@PostMapping
	public String submitForm(
			@ModelAttribute("reservation")  Reservation reservation,
			BindingResult bindingResult, SessionStatus status) {
		/*if(bindingResult.hasErrors()) {
			return "reservationForm";
		}*/
//		else {
			reservationService.make(reservation);
			status.setComplete();
//		}
		return "redirect:reservationSuccess";
	}
	

}
