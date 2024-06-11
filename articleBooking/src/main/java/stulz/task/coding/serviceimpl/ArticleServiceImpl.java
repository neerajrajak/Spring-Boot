package stulz.task.coding.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stulz.task.coding.entity.Article;
import stulz.task.coding.repository.ArticleRepository;
import stulz.task.coding.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public Article getArticle(String articleId) {
		return articleRepository.findByArticleId(articleId);
	}

	
}
