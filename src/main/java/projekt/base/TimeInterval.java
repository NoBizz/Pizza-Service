package projekt.base;

import java.time.*;

public class TimeInterval {
	
	private final LocalDateTime start;
	private final LocalDateTime end;
	
	/**
	 * Public constructor of this class initializing the start and end field
	 * representing the start and end points of some time frame.
	 * @param start the starting point, initializing {@code start}
	 * @param end the end point, initializing {@code end}
	 */
	public TimeInterval(LocalDateTime start, LocalDateTime end) {
		if(start == null) throw new NullPointerException("start");
		if(end == null) throw new NullPointerException("end");
		if(start.isAfter(end)) throw new IllegalArgumentException("Start "+start.toString()+" is after end "+end.toString());
		else {
			this.start = start;
			this.end = end;
			
		}
	}

	/**
	 * 
	 * @return get the start of this time interval
	 */
	public LocalDateTime getStart() {
		return start;
	}

	/**
	 * 
	 * @return the end of this time interval
	 */
	public LocalDateTime getEnd() {
		return end;
	}
	
	/**
	 * 
	 * @return the duration of the time interval spanning [start, end)
	 */
	public Duration getDuration() {
		return (Duration.between(start, end));
	}
	
}
