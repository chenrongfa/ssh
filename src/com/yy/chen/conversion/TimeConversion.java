package com.yy.chen.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;





import org.apache.struts2.util.StrutsTypeConverter;



public class TimeConversion extends StrutsTypeConverter {
  private SimpleDateFormat fm= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		if(Date.class == arg2){
			try {
			return	(Date)fm.parse(arg1[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		return fm.format(arg1);
	}

}
