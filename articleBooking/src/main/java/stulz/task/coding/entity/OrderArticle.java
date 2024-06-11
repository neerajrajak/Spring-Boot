package stulz.task.coding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(value="order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderArticle {
	
	@Id
	private String id;
	private String orderId;
	private String articleId;
	private int quantity;
	private String logisticProvider;
	private double totalOrderPrice;
	private double totalLogisticsPrice;
	private double totalPrice;
}
