package stulz.task.coding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	private String articleId;
	private int quantity;
	private String logisticsOpted;
}
