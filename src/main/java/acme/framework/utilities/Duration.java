package acme.framework.utilities;

import java.util.Date;

public class Duration {
	
	private Duration() {
		
	}
	
	public static Double getDuration(final Date eStart, final Date eEnd) {
		 Double res = null;
		 
		 final int days = eEnd.getDay() - eStart.getDay();
		 final int hours = (eEnd.getHours() - eStart.getHours()) + (days * 24);
		 int minutes = eEnd.getMinutes() - eStart.getMinutes();
		 if(minutes<0) {
			 minutes = 60 + minutes;
		 }
		 if(minutes<10) {
			 res = Double.valueOf(hours + ".0" + minutes);
		 } else {
			 res = Double.valueOf(hours + "." + minutes);
		 }
		 return Duration.correctPeriod(res);
	 }
	
	public static Double correctPeriod(final Double period) {
		Double res = period;
		if(res!=null) {
			final Double dec = res - res.intValue();
			if (dec >= .6) {
				res = res + 1 - .6;
			}
		}

		return res;
	}
}
