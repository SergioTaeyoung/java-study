package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		int count = 0;
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//1-1. 소켓 버퍼 사이즈 확인
			int recieveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			System.out.println(recieveBufferSize + ":" + sendBufferSize);
			
			//1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			
			//1-3. SO_NODELAY(Nagle Algorithm Off) // 기본적으로 Nagle 알고리즘은 ON
			socket.setTcpNoDelay(true);
			
			//1-4. SO_TIMEOUT
			socket.setSoTimeout(1000);	//1초보다 느리면 Sotimeout 예외 발생
			
			recieveBufferSize = socket.getReceiveBufferSize();
			sendBufferSize = socket.getSendBufferSize();
			System.out.println(recieveBufferSize + ":" + sendBufferSize);
						
			//2. 서버연결			
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client]connected");
			
			//3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. 쓰기

			String data = "Hello World";			
			os.write(data.getBytes("UTF-8"));
//			String data;
//			while(true) {
//				data = sc.nextLine();
//				os.write(data.getBytes("UTF-8"));
//				count++;
//				if(count == 3)
//					break;
//			}
			
			//5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount==-1) {
				System.out.println("closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client]recieve:" + data);
			
		} catch (SocketTimeoutException e) {	//IOExc 보다 자식이라 위에있어야함
			System.out.println("[client] time out");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(socket!=null && !socket.isClosed()) {
				socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
