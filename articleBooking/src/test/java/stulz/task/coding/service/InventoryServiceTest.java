package stulz.task.coding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import stulz.task.coding.entity.Inventory;
import stulz.task.coding.exception.ArticleNotFoundException;
import stulz.task.coding.repository.InventoryRepository;
import stulz.task.coding.serviceimpl.InventoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

	@InjectMocks
    private InventoryServiceImpl inventoryService;
	
	@Mock
	private MongoTemplate mongoTemplate;
	
	@Mock
	private InventoryRepository inventoryRepository;
	
	@Test
	public void test_InventoryAvailable() throws ArticleNotFoundException {
		
		String articleId = "ART101";
		
		Inventory inventory = new Inventory();
		inventory.setArticleId(articleId);
		inventory.setQuantity(35);
		
		when(inventoryRepository.findByArticleId(articleId)).thenReturn(inventory);
		
		int quantity = inventoryService.getArticleQuantity(articleId);
		
		assertEquals(35, quantity);
		
	}
}
