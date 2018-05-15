package example.spring.mvc.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import example.spring.mvc.models.PeriodicReservation;
import example.spring.mvc.models.Player;
import example.spring.mvc.service.ReservationService;

@Controller
@RequestMapping("/periodicReservationForm")
@SessionAttributes("reservation")
public class PeriodicReservationController {

	private Map<Integer, String> pageForms = new HashMap<Integer, String>(3);
	
	@Autowired
	private ReservationService reservationService;
	
	@PostConstruct
	public void initialize() {
		pageForms.put(0, "reservationCourtForm");
		pageForms.put(1, "reservationTimeForm");
		pageForms.put(2, "reservationPlayerForm");
	}
	
	@GetMapping
	public String setupForm(Model model) {
		PeriodicReservation periodicReservation = new PeriodicReservation();
		periodicReservation.setPlayer(new Player());
		model.addAttribute("reservation", periodicReservation);
		return "reservationCourtForm";
	}
	
	@PostMapping(params = {"_cancel"})
	public String cancelForm(@RequestParam("_page") int currentPage) {
		return pageForms.get(currentPage);
	}
	
	@PostMapping(params = {"_finish"})
	public String completeForm(
			@ModelAttribute("reservation") @Validated PeriodicReservation reservation,
			BindingResult result,
			SessionStatus status,
			@RequestParam("_page") int currentPage 
			) {
		
		if(!result.hasErrors()) {
			reservationService.makePeriodicReservation(reservation);
			status.setComplete();
			return "redirect:reservationSuccess";
		}
		else {
			return pageForms.get(currentPage);
		}
	}
	
	@PostMapping
	public String submitForm(HttpServletRequest request, @ModelAttribute("reservation") PeriodicReservation reservation, 
			BindingResult result, @RequestParam("_page") int currentPage) {
		
		int targetPage = getTargetPage(request, "_target", currentPage);
		
		if(targetPage < currentPage) {
			return pageForms.get(currentPage);
		}
		
		if(!result.hasErrors()) {
			return pageForms.get(targetPage);
		}
		else {
			return pageForms.get(currentPage);
		}
	}
	
	@ModelAttribute("periods")
	public Map<Integer, String> periods() {
		Map<Integer, String> periods = new HashMap<Integer, String>();
		periods.put(1, "Daily");
		periods.put(2, "Weekly");
		return periods;
	}

	
	
	private int getTargetPage(HttpServletRequest request, String paramPrefix, int currentPage) {
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
			String parameterName = paramNames.nextElement();
			if(parameterName.startsWith(paramPrefix)) {
				for(int i = 0; i < WebUtils.SUBMIT_IMAGE_SUFFIXES.length; i++) {
					String suffix = WebUtils.SUBMIT_IMAGE_SUFFIXES[i];
					if(parameterName.endsWith(suffix)) {
						parameterName = parameterName.substring(0, parameterName.length()-suffix.length());
					}
				}
				return Integer.parseInt(parameterName.substring(paramPrefix.length()));
			}
		}
		
		return currentPage;
	}
	
	
}
