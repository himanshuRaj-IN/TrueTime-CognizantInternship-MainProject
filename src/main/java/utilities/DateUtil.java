package utilities;

import java.util.Date;

public class DateUtil {
	

		/************************ Get Time Stamp ************************/
		public static String getTimeStamp(){
			Date date = new Date();
			return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
		}
}
