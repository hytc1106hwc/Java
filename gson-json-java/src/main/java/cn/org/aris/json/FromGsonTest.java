package cn.org.aris.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This example illustrates the basic use of fromJson
 * @author Aris
 */
public class FromGsonTest {

	public static void main(String[] args) {
		try {
			// get inputstream from the file
			InputStream in = FromGsonTest.class.getResourceAsStream("/FromGson.json");
			
			// if the inputstream is null, exit
			if (in == null) {
				System.out.println("Did not find the file 'Server1.json' in the class path");
				return;
			}
			
			Reader reader = new InputStreamReader(in, "UTF-8");
			Gson gson = new GsonBuilder().create();
//			Person p = gson.fromJson(reader, Person.class);
//			System.out.println(p);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
