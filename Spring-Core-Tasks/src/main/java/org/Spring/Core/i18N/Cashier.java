package org.Spring.Core.i18N;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.Spring.Core.Scope.ShoppingCart;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Cashier {

	private static final Logger logger = Logger.getLogger(Cashier.class);

	private String fileName;
	private String path;
	private BufferedWriter bufferedWriter;

	@Autowired
	private MessageSource messageSource;

	public void checkout(ShoppingCart cart) throws IOException {
		String alert = messageSource.getMessage("alert.inventory.checkout", new Object[] { cart.getItems(), new Date() }, Locale.US);
		logger.info(alert);
		bufferedWriter.write(alert);
		bufferedWriter.flush();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	@PostConstruct
	public void openFile() throws IOException {
		
		path = "/home/satya/Desktop/advJava/spring5/Spring5-Series/logs";
		fileName = "spring-core.log";
		
		File targetDir  =  new File(path);
		
		if(!targetDir.exists()) {
			targetDir.mkdir();
		}
		
		File checkoutFile = new File(path, fileName);
		
		if(!checkoutFile.exists()){
			checkoutFile.createNewFile();
		}
		
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(checkoutFile, true)));
	}

	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}

	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}
	
	@PreDestroy
	public void closeFile() throws IOException {
		bufferedWriter.close();
	}

}
