package stulz.task.coding.service;

public interface InventoryService {

	public int getArticleQuantity(String articleId);
	
	public int updateInventoryCount(String articleId, int quantity);
}
