package stulz.task.coding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(value="inventory")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Inventory {

	@Id
	private String id;
	private String articleId;
	private int quantity;
}
