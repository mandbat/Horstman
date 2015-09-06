package custom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(8189);
		Socket incoming = ss.accept();

		OutputStream outStream = incoming.getOutputStream();
		
		PrintWriter out = new PrintWriter(outStream, true);
		out.println("Yahooo!!!");
	
	}

}
