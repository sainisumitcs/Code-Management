import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger LOGGER = LogManager.getRootLogger();

	public static void main(String[] args) {
		
		String date1 = "20371010000010";
		LOGGER.trace("This is first message for test");
		
		LOGGER.info("Formated Date [" + getISODate2(date1) + "]");

	}

	public static String getISODate2(String date1) {
		// DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ssZ");
		DateFormat dft = new SimpleDateFormat("YYYYMMddHHmmss");
		DateFormat df = new SimpleDateFormat("YYYYMMdd'T'HH:mm:ssZ");
		Date formatedDate = null;
		try {
			formatedDate = dft.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nowAsString = df.format(formatedDate);
		return nowAsString;

	}

}
