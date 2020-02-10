package chats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;

public class ChatServerThread extends Thread {

	private Socket socket;
	private String name;
	List<Writer> listWriters;
	String user_id;
	HashMap<String, ObjectOutputStream> hm;

	public ChatServerThread(Socket socket, List<Writer> listWriters, HashMap hm) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.hm = hm;
	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;

	}

	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();

		System.out.println("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 4. IOStream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			//ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			// 닉네임
			name = br.readLine();
//			synchronized (hm) {
//				hm.put(user_id, oos);
//			}
			doJoin(name, pw);

			while (true) {
				// 5. 데이터 읽기

				String data = br.readLine();

				if (data == null) {
					doQuit(name);
					break;
				}
//				if(data.indexOf("/to")>-1)
//					sendMsg(data);

				broadcast(this.name + ":" + data);

				System.out.println(name + ":" + data);
				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			doQuit(name);
			// hm.remove(name);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				System.out.println("suddenly closed by client");
			}
		}
	}

	private void doJoin(String name, Writer writer) {
		this.name = name;
		broadcast(name + "님이 입장하였습니다.");
		System.out.println(name + "님이 입장하였습니다.");
		addWriter(writer);

	}

	private void doQuit(String name) {
		this.name = name;
		broadcast(name + "님이 퇴장하셨습니다.");
		System.out.println(name + "님이 퇴장하셨습니다.");

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	public void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer wirter : listWriters) {
				PrintWriter printWriter = (PrintWriter) wirter;
				printWriter.println(data);

				printWriter.flush();
			}
		}
	}

	public void sendMsg(String data) {
		int begin = data.indexOf("") + 1;
		int end = data.indexOf("", begin);

		if (end != -1) {
			String id = data.substring(begin, end);
			String msg = data.substring(end + 1);
			ObjectOutputStream oos = hm.get(id);

			try {
				if (oos != null) {
					oos.writeObject(id + "님이 귓속말을 보냈습니다 :" + msg);
					oos.flush();
				}
			} catch (IOException e) {
			}

		}
	}

}
