package stulz.task.coding.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import stulz.task.coding.constants.ArticleOrderConstants;
import stulz.task.coding.entity.Inventory;
import stulz.task.coding.exception.ArticleNotFoundException;
import stulz.task.coding.repository.InventoryRepository;
import stulz.task.coding.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public int getArticleQuantity(String articleId) {
		
		Inventory inventory = inventoryRepository.findByArticleId(articleId);
		if(inventory != null) {
			if(inventory.getQuantity() > 0)
				return inventory.getQuantity();
			else 
				return 0;
		} else {
			throw new ArticleNotFoundException(ArticleOrderConstants.ARTICLE_NOT_FOUND);
		}
	}

	@Override
	public int updateInventoryCount(String articleId, int quantity) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("articleId").is(articleId));
		Update updateDefination = new Update();
		updateDefination.set("quantity", quantity);
		Inventory inventory = mongoTemplate.findAndModify(query, updateDefination,
				Inventory.class);
		return inventory.getQuantity();
	}

}
