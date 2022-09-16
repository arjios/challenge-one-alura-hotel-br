package dao.util;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TesteCAlculoDiarias {

	public static void main(String[] args) {
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		 c1.set(Calendar.DAY_OF_MONTH, 30);
		 c1.set(Calendar.MONTH, 12);
		 c1.set(Calendar.YEAR, 2022);
		
		 
		 c2.set(Calendar.DAY_OF_MONTH, 2);
		 c2.set(Calendar.MONTH, 1);
		 c2.set(Calendar.YEAR, 2023);
		 
		 
		 System.out.println(TimeUnit.MILLISECONDS.toDays(c2.getTime().getTime() - c1.getTime().getTime()));
	}

}
