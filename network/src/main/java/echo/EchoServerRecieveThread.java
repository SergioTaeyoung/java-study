package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerRecieveThread extends Thread {
	private Socket socket;
	private String name;
	
	public EchoServerRecieveThread(Socket socket) {
		this.socket= socket;
	}
	
	@Override
	public void run() {		
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();

		EchoServer.Log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 4. IOStream 받아오기				
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);

			while (true) {
				// 5. 데이터 읽기
				String data = br.readLine();
				
				if(data == null) {
					EchoServer.Log("close by client");
					break;
				}					
				EchoServer.Log("recived:" + data);

				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			EchoServer.Log("[server] suddenly close by client");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				EchoServer.Log("suddenly closed by client");
			}
		}
	}
	

	
}
