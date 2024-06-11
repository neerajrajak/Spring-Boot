package stulz.task.coding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "orderseq")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderNum {

	@Id
	private String id;

	public long seq;

	public OrderNum(long seq) {
		this.seq = seq;
	}
}
