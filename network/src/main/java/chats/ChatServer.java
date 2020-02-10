package chats;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatServer {
	private static String IP = "127.0.0.1";
	private static int PORT = 9002;
	
	public static void main(String[] args) {
		Socket socket = null;				//클라이언트와 통신하는 소켓
		ServerSocket serverSocket = null;	
		List<Writer> listWriters = new ArrayList<Writer>();
		HashMap<String, ObjectOutputStream> hm;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP,PORT));
			System.out.println("연결 대기중...");
			
			hm = new HashMap<String, ObjectOutputStream>();
			
			while(true) {
				
				socket = serverSocket.accept();				
				new ChatServerThread(socket, listWriters).start();
				if((InetSocketAddress) socket.getRemoteSocketAddress() != null){
					System.out.println("연결 완료!");
				}
			}
			
			
		}catch (SocketException e) {
				System.out.println("서버종료");
			
		
		} catch (IOException e) {
				System.out.println("error : " + e);
				e.printStackTrace();
		}
		

	}
	
	
}
