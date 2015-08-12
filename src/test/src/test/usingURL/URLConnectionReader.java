package test.usingURL;

import java.net.*;
import java.util.*;
import java.io.*;

public class URLConnectionReader {

	public static void main(String[] args) throws Exception {
		String urlString = "";
		// urlString="http://localhost:8080/ServletSample/TestServlet.do";
		urlString = "http://localhost:8080/ServletSample2.5/TryServlet.do";

		// 範例1.
		// URL url = new URL(urlString);
		// URLConnection urlConn = url.openConnection();
		// BufferedReader inBR = new BufferedReader(new
		// InputStreamReader(urlConn.getInputStream()));
		// String inputLine;
		// while ((inputLine = inBR.readLine()) != null) {
		// System.out.println(inputLine);
		// }
		// inBR.close();

		// 範例2.
		try {

			// URL url = new
			// URL("http://192.168.1.101:8080/javaworld/servlet/HelloJavaWorld");
			URL url = new URL(urlString);

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					conn.getOutputStream()));
			out.write("name=java world\r\n");
			out.write("address=opq");
			out.write("&pwd=888");
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			String response;
			while ((response = in.readLine()) != null) {
				System.out.println(response);
			}
			in.close();
		} catch (MalformedURLException ex) {
			// a real program would need to handle this exception
			ex.printStackTrace();
		} catch (IOException ex) {
			// a real program would need to handle this exception
			ex.printStackTrace();
		}

	}
}
