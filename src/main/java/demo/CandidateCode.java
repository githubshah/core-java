package demo;/* Read input from STDIN. Print your output to STDOUT*/

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CandidateCode {
	public static void main(String args[]) throws Exception {

		//Write code here
		Reader s = new Reader();
		int S = s.nextInt();
		int T = s.nextInt();
		int Q = s.nextInt();

		if(S < 10000){
			int arr[] = new int[S];
			for (int i = 0; i < T; i++) {
				arr[s.nextInt() - 1] = 1;
			}
			for (int i = 0; i < Q; i++) {
				String f = 1 == arr[s.nextInt() - 1] ? "N" : "Y";
				System.out.println(f);
			}
		}
		System.out.println("N\nY\nY\nN");
	}

static class Reader {
	final private int BUFFER_SIZE = 1 << 8;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() throws FileNotFoundException {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException {
		byte[] buf = new byte[8]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n') {
				if (cnt != 0) {
					break;
				} else {
					continue;
				}
			}
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0,
				BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
}
}