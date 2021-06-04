package com.sist.exam10;

public class WriteArticleServiceImpl {
	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public void execute() {
		articleDao.insert();
	}
	
}
