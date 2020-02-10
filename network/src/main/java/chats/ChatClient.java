package chats;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChatClient {
	private static final String IP = "127.0.0.1";
	private static final int PORT = 9002;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		BufferedReader br = null;

		PrintWriter pw = null;

		socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(IP, PORT));
			System.out.println("서버 연결 완료!");

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			System.out.print("닉네임을 입력해주세요 : ");
			String nickname = scanner.nextLine();

			pw.println(nickname);
			pw.flush();

			System.out.println("채팅을 시작하세요");
			// Thread th = new Thread(new ChatClientThread(socket, nickname));
			// th.start();
			ChatClientThread th = new ChatClientThread(socket, nickname);
			// th.show();
			th.start();

			while (true) {
				// 5. 키보드 입력받기

				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					break;
				}
				pw.println(line); // 6. 데이터 쓰기
				pw.flush();

				String data = br.readLine(); // 7. 데이터 읽기
				if (data == null) {
					System.out.println("closed by server");
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			
		} finally {
			if (scanner != null)
				scanner.close();
		}

		if (socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
