package custom;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainClass {

	public static void main(String[] args) throws SecurityException, IOException {

		Logger logger = Logger.getLogger(MainClass.class.getName());

		Handler fileHanler = new FileHandler("%h/mylog.log", false);
		fileHanler.setFormatter(new SimpleFormatter());
		fileHanler.setLevel(Level.ALL);
		
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		
		logger.addHandler(fileHanler);
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);
		
		logger.setLevel(Level.ALL);
		
		logger.info("Привет от Логгера!!!");
		logger.fine("Работает - 123");
		
		int a = 1;
		Thread.dumpStack();
		
	}

}
