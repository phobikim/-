package com.sist.exam05;

public class WriteArticleServiceImpl {
	private ArticleDao articleDao;

	public WriteArticleServiceImpl(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}
	
	public void execute() {
		articleDao.insert();
	}
	
}
