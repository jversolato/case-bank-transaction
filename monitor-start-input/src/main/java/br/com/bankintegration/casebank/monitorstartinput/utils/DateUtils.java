package br.com.bankintegration.casebank.monitorstartinput.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @todo Aqui será implementado uma classe util para formatacao de data 
 *
 */
public class DateUtils {

	private DateUtils() {

	}

	public static String dateToString(Date dt) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = null;

		formattedDate = df.format(dt);

		return formattedDate;
	}

}
