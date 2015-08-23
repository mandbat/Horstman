package custom;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

	public static void main(String[] args) throws SecurityException, IOException {

		Logger logger = Logger.getLogger(MainClass.class.getName());

		Handler myHandler = new FileHandler("%h/mylog.log", false);
		myHandler.setLevel(Level.ALL);
		
		Handler myHandler2 = new ConsoleHandler();
		myHandler2.setLevel(Level.ALL);
		
		logger.addHandler(myHandler);
		logger.addHandler(myHandler2);
		logger.setUseParentHandlers(false);
		
		logger.setLevel(Level.ALL);
		
		logger.info("Привет от Логгера!!!");
		logger.fine("Работает - 123");
		
	}

}
