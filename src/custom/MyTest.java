package custom;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyTest {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream(new File(""));
		BufferedInputStream isb = new BufferedInputStream(new FileInputStream(new File("")));
		
		Properties prop = new Properties();
		
		FileReader fr = new FileReader(new File(""));
		
		prop.load(is);
		
	}

}
