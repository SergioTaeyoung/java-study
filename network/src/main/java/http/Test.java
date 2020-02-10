package http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./webapp/error/404.html");
		byte[] body = null;
		try {
			body = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\r");
		System.out.println( ("HTTP1.1 404 File Not Found\r\n" ).getBytes());
		System.out.println("-----------------------------------------");
		int i =0;
		while(body!=null) {
			System.out.print((char)body[i]);
			i++;
		}
	}

}
