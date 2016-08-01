package cn.org.aris.json;

import java.lang.reflect.Type;

import cn.org.aris.json.utils.Utils;
import cn.org.aris.json.vo.Article;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FromGsonTest1 {
	public static void main(String[] args) {
		// 新建一个Gson对象
		Gson gson = new Gson();

		// 构建一个Article列表
		java.util.List<Article> articles = new java.util.LinkedList<Article>();
		articles.add(Utils.createArticle());
		articles.add(Utils.createArticle());

		// Java --> JSON
		Type objType = new TypeToken<java.util.List<Article>>() {
		}.getType();
		String json_with_generic = gson.toJson(articles, objType);

		// JSON --> Java
		@SuppressWarnings("rawtypes")
		java.util.List list = gson.fromJson(json_with_generic,
				java.util.List.class);
		System.out.println("fromJson: " + list);
		System.out.println("Class Type: " + list.get(0).getClass());

		// JSON --> Java "Get the actual type"
		Type type = new TypeToken<java.util.List<Article>>() {
		}.getType();
		list = gson.fromJson(json_with_generic, type);

		// for (int i = 0; i < list.size(); i++) {
		// Article arti = (Article) list.get(i);
		// System.out.println(arti.getTitle());
		// }

		System.out.println("fromJson: " + list);
		System.out.println("Class Type: " + list.get(0).getClass());
	}
}
