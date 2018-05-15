package example.spring.mvc.controller.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import example.spring.mvc.exception.ReservationNotAvailableException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(ReservationNotAvailableException.class)
	public String handle(ReservationNotAvailableException e) {
		return "reservationNotAvailable";
	}
	
	@ExceptionHandler(Exception.class) 
	public String handleDefaultException(Exception e) {
		return "error";
	}
}
