package spring.applicationevents.example;

public class SatyaEvent  {

	private String message;
	
	private int counter;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public SatyaEvent( String message, int counter) {
		this.message = message;
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "SatyaEvent [message=" + message + ", counter=" + counter + "]";
	}
	
	
}
