package cn.org.aris.json.utils;

import cn.org.aris.json.vo.Article;

public class Utils {
	public static Article createArticle() {

		Article article = new Article();

		article.setTitle("GSON - Java JSON Library");
		article.setUrl("http://1062593907.qzone.com");
		article.addCategory("Java");
		article.addTag("Java");
		article.addTag("GSON");
		article.addTag("JSON");

		return article;
	}
}
