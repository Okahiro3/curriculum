package study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒");
		
		Date date = new Date();
		System.out.println(sdf1.format(date));
//		出力
	}

}
