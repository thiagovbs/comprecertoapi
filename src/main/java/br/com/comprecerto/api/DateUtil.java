package br.com.comprecerto.api;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static Date converteLocalDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
