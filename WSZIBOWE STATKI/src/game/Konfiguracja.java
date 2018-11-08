package game;

import java.io.*;
import java.util.LinkedList;

public class Konfiguracja {
	
	private static Konfiguracja instance = null;

	public static Konfiguracja getInstance() {
		if (instance == null) instance = new Konfiguracja();
		return instance;
	}	

	private String host = "127.0.0.1";

	private int port = 8008;
	
	private String fileName = "statki.ini";

	public Konfiguracja() {		
		odczyt();
	}

	private void odczyt() {
		LinkedList<String> lines = new LinkedList<String>();

		try {			
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = reader.readLine();				
				if (line == null) {
					reader.close();
					break;
				}
				
				if (!line.startsWith("#")) {
					lines.add(line);
				}
			}
		} catch (IOException e) {
		}

		while (!lines.isEmpty()) {
			String s = (String) lines.getFirst();
			lines.removeFirst();
			int idx = s.indexOf('=');
			if (idx != -1) {
				String key = s.substring(0, idx).trim();
				String value = s.substring(idx + 1).trim();

				if (key.compareToIgnoreCase("host") == 0) {
					setHost(value);
				} else if (key.compareToIgnoreCase("port") == 0) {
					try {
						int x = Integer.parseInt(value);
						setPort(x);
					} catch (NumberFormatException ex) {
					}
				}
			}
		}
	}

	public void zapisz() {
		
		try {
			PrintWriter writer;
			writer = new PrintWriter(new BufferedWriter(
					new FileWriter(fileName)));
			writer.print("host=");
			writer.println(getHost());
			writer.print("port=");
			writer.println(getPort());

			writer.close();
		} catch (IOException e) {
		}
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}
}
