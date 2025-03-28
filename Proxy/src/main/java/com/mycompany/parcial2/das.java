package main.java.com.mycompany.parcial2;
import main.java.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.LDAPCertStoreParameters;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import netscape.javascript.JSObject;

@RestController
public class das {

    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static final String USER_AGENT = "Mozilla/5.0";
	public int index = 0;
	private static String[] servers = {
		"http://localhost:8083"
	};

	@GetMapping("/hello")
	public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello";
	}


    @GetMapping("/lucasseq")
    public String greeting(@RequestParam(value = "value", defaultValue = "0") String value) throws IOException {

        String url = "http://localhost:8083/lucasseq?value=" + value;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // The following invocation perform the connection implicitly before getting the
        // code
        int responseCode = con.getResponseCode();
        while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // in.close();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                // print result
                System.out.println(response.toString());
                return response.toString();
            } else {
                return "GET request not worked";
            }
        }

    }
    public String round(){
        String server = servers[index];
        System.out.println("trabajando con:" + server);
        index = (index+1) % servers.length;
        return server;
    }
}
