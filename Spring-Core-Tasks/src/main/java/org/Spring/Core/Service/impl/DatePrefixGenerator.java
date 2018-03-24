package org.Spring.Core.Service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.Spring.Core.Service.PrefixGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {
	
	private static DateFormat format = new SimpleDateFormat("yyyyMMdd");

	@Override
	public String getPrefix() {
		return format.format(new Date());
	}

}
