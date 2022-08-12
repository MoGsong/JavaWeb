package com.gxnu;
import java.io.IOException;
import java.net.*;

public class Test {
	public static ServerSocket ss= null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			ss = new ServerSocket(5678);
			Socket socket = ss.accept();
			
			System.out.println(socket.isConnected());
//			socket.getInputStream();
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			ss.close();
		}

	}

}

class AddOperation{
	public int add(int x, int y) {
		return x+y;
	}
}
