package org.Spring.java8.util;

import java.util.function.Supplier;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AppLogger {

	public static void log(Logger logger, Level level, Supplier<String> messageFn) {
		if(logger.isEnabledFor(level)) {
			logger.log(level, messageFn.get());
		}
	}
	
}
