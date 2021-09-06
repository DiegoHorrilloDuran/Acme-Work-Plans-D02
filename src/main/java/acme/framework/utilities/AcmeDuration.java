package acme.framework.utilities;

import java.util.Date;

public class AcmeDuration {
	
	private AcmeDuration() {
		
	}
	
	//This method find the period between two Dates in format [hours.minutes]
	public static Double getDuration(final Date eStart, final Date eEnd) {
		 
		 final long diff = Math.abs(eStart.getTime() - eEnd.getTime());
		 
		 final long periodMinutes = (diff/60)/1000;
		 return AcmeDuration.doPeriod(periodMinutes);
	 }
	
//	public static Double correctPeriod(final Double period) {
//		Double res = period;
//		if(res!=null) {
//			final Double dec = res - res.intValue();
//			if (dec >= .6) {
//				res = res + 1 - .6;
//			}
//		}
//
//		return res;
//	}
	
	public static Double doPeriod(final long period) {
		final Double res;
		final Double div = (double) period/60;
		final int entero = div.intValue();
		final Double decimal = (double)(period - (entero*60))/100;
		res = entero+decimal;

		return res;
	}
}
