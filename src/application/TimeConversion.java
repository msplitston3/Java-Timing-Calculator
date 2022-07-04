package application;

public class TimeConversion {
	public static String addTimes(int h1, int m1, int s1, int ms1, int h2, int m2, int s2, int ms2) {
		int resultMSec = 0;
		int resultSec = 0;
		int resultMin = 0;
		int resultHour = 0;
		
		resultMSec += ms1 + ms2;
		if (resultMSec >= 1000) {
			resultSec++;
			resultMSec -= 1000;
		}
		resultSec += s1 + s2;
		if (resultSec >= 60) {
			resultMin++;
			resultSec -= 60;
		}
		resultMin += m1 + m2;
		if (resultMin >= 60) {
			resultHour++;
			resultMin -= 60;
		}
		resultHour += h1 + h2;
		
		return resultHour + ":" + ((resultMin < 10)? "0" + resultMin: resultMin)
				+ ":" + ((resultSec < 10)? "0" + resultSec : resultSec) + "." + ((resultMSec >= 100)? resultMSec : (resultMSec < 10)? "00" + resultMSec : "0" + resultMSec);
	}

	public static String subTimes(int h1, int m1, int s1, int ms1, int h2, int m2, int s2, int ms2) {
		int resultMSec = 0;
		int resultSec = 0;
		int resultMin = 0;
		int resultHour = 0;
		
		resultMSec += ms1 - ms2;
		if (resultMSec <0) {
			resultSec--;
			resultMSec += 1000;
		}
		resultSec += s1 - s2;
		if (resultSec < 0) {
			resultMin--;
			resultSec += 60;
		}
		resultMin += m1 - m2;
		if (resultMin < 0) {
			resultHour--;
			resultMin += 60;
		}
		resultHour += h1 - h2;
		
		return resultHour + ":" + ((resultMin < 10)? "0" + resultMin: resultMin)
				+ ":" + ((resultSec < 10)? "0" + resultSec : resultSec) + "." + ((resultMSec >= 100)? resultMSec : (resultMSec < 10)? "00" + resultMSec : "0" + resultMSec);
	}

}
