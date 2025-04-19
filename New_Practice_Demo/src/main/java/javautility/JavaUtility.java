package javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int randomNumber(int num) {
		Random random = new Random();
		int nextInt = random.nextInt(num);
		
		return nextInt;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dobj);
		
		
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		
		return reqDate;
	}

}
