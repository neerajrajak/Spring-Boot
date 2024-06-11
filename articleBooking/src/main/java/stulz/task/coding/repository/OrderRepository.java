package stulz.task.coding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import stulz.task.coding.entity.OrderArticle;

@Repository
public interface OrderRepository extends MongoRepository<OrderArticle, String> {
	
}
