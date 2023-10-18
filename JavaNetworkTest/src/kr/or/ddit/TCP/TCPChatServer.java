package kr.or.ddit.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPChatServer {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 준비 완료...");
			
			socket = server.accept();
			
			Sender sender = new Sender(socket);
			
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
