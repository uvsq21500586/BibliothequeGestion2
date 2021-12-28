package operations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
	public static String dateFormat(Date date) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		return dateformat.format(date);
	}

}
