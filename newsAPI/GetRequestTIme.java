package newsAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetRequestTIme {
	
	public String getRequestTime(){
		
		/**
		* Request 시간 출력 코드
		*
		*/
		Calendar cal = Calendar.getInstance();
		java.util.Date date = cal.getTime();
		String requestTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
		
		return requestTime;
		
	}
	

}
