package stulz.task.coding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import stulz.task.coding.entity.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {

	Article findByArticleId(String articleId);

}