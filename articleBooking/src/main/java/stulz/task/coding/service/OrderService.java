package stulz.task.coding.service;

import stulz.task.coding.dto.OrderRequest;
import stulz.task.coding.dto.OrderResponse;

public interface OrderService {

	public OrderResponse createOrder(OrderRequest orderRequest);
}
