package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();	//컴퓨터 이름
			String hostAddress = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				
				System.out.println(address & 0x000000ff);
			}
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			System.out.println(Arrays.toString(addresses));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
