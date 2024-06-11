package stulz.task.coding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private double totalOrderPrice;
	private double totalLogisticsPrice;
	private double totalPrice; 
}
