package stulz.task.coding.exception;

public class ArticleNotFoundException extends RuntimeException{
	public ArticleNotFoundException(String message){
        super(message);
    }
}
