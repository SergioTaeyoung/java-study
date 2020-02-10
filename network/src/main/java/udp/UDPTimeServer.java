package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			// 1. socket 생성
			socket = new DatagramSocket(PORT);

			while (true) {
				// 2. data 수신
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
				String dateData = format.format(new Date());

				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); // blocking

				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String msg = new String(data, 0, length, "UTF-8");

				if ("".equals(msg)) {

					// 3. 데이터 송신
					byte[] sendData = dateData.getBytes("UTF-8");
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
							receivePacket.getAddress(), receivePacket.getPort());
					socket.send(sendPacket);
					System.out.println("클라이언트에 서버시간을 전송하였습니다.");
				}
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
