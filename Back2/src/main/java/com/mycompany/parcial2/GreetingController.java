package com.mycompany.parcial2;

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

import netscape.javascript.JSObject;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/lucasseq")
	public String greeting(@RequestParam(value = "value", defaultValue = "0") String value) {
		lucasSeq l = new lucasSeq();
		int xx = Integer.valueOf(value);
		String result = l.listar(xx);
		return "{"
		+ "\"operation\" : \"Secuencia de lucas\" ,"
		+ "\"Input\" : \" " + value + "\" ,"
		+ "\"Output\" : \" " + result + "\" "
		+ "}";
	}
}
