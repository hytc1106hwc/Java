package cn.org.aris.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import cn.org.aris.json.utils.Utils;
import cn.org.aris.json.vo.Article;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;


public class App 
{
    public static void main( String[] args )
    {
    	// 新建一个Gson对象
    	Gson gson = new Gson();

    	// 构建一个Article列表
    	java.util.List<Article> articles = new java.util.LinkedList<Article>();
    	articles.add(Utils.createArticle());
    	articles.add(Utils.createArticle());
    	
    	// Java --> JSON
    	String json_no_generic = gson.toJson(articles);
    	System.out.println("toJson: " + json_no_generic);
    	
    	// Java --> JSON
    	Type objType = new TypeToken<java.util.List<Article>>(){}.getType();
    	String json_with_generic = gson.toJson(articles, objType);
    	System.out.println("toJson: " + json_with_generic);
    	
    	// JSON --> System.Out
    	gson.toJson(json_no_generic, System.out);
    	
    	
    	//JSON --> File
    	Writer writer = null;
    	try {
    		writer = new FileWriter(new File("out.json"));
			gson.toJson(articles, writer);
			writer.close();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    	//JSON --> File(use try-with-resources)
    	try (Writer writer2 = new FileWriter(new File("out2.json"))) {
    		gson.toJson(articles, writer2);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	// use OutputStreamWriter
    	try (Writer writer3 =new OutputStreamWriter(
    			new FileOutputStream("out3.json"), Charset.forName("UTF-8")
    	)) {
    		gson.toJson(articles, writer3);
    	} catch (IOException e) {
			e.printStackTrace();
		}


    }
}