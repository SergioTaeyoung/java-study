package chats;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;

public class ChatClientThread extends Thread {
	private Socket socket;
	private String name;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatClientThread(Socket socket, String nickname) {
		this.socket = socket;
		this.name = nickname;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream 초기화 ( 기반스트림, 보조스트림 붙이기)
		 */

		/*
		 * 3. Thread 생성 작업
		 */
	}

	private void sendMessage() {
		String message = textField.getText();
		textField.setText("");
		textField.requestFocus();
		// 이걸 소켓으로 보내자

		// 소켓을 통해 메세지가 온 경우....(쓰레드에서 처리)
		textArea.append(name + ":" + message);
		textArea.append("\n");
	}

	@Override
	public void run() {
		try {
			// 4. IOStream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// name = br.readLine();

			while (true) {
				String data = br.readLine(); // 7. 데이터 읽기
				if (data == null) {
					System.out.println("채팅을 종료합니다.");
					break;
				}

				System.out.println(data);
				sendMessage();
			}

		} catch (SocketException e) {
			System.out.println("채팅을 종료합니다..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				System.out.println("채팅을 종료합니다.");
			}
		}
	}

}
