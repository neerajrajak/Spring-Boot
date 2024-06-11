package stulz.task.coding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import stulz.task.coding.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

	Inventory findByArticleId(String articleId);
}
