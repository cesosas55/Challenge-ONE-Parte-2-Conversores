package main;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class TestGson {
	public static void main(String[] args) {
		AgenteMonetario test = new AgenteMonetario();
		Gson gj = new Gson();
		System.out.println(test.accessKey);
		System.out.println(gj.toJson(test));
	}

}