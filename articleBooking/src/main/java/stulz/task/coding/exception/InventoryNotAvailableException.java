package stulz.task.coding.exception;

public class InventoryNotAvailableException extends RuntimeException {
	public InventoryNotAvailableException(String message){
        super(message);
    }
}
