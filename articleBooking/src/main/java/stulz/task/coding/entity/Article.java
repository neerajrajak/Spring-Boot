package stulz.task.coding.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(value="article")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Article {

	@Id
	private String id;
	private String articleId;
	private String articleTitle;
	private String articleAuthor;
	private double price;
}
