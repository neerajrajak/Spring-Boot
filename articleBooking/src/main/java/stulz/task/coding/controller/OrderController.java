package stulz.task.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import stulz.task.coding.constants.ArticleOrderConstants;
import stulz.task.coding.dto.OrderRequest;
import stulz.task.coding.dto.OrderResponse;
import stulz.task.coding.service.OrderService;

@RestController
@Slf4j
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Tag(name = "POST", description = "API to create order for given article.")
	@ApiResponses({
	       @ApiResponse(responseCode = "201", content = { @Content(mediaType = "application/json",
	               schema = @Schema(implementation = OrderResponse.class)) }),
	       @ApiResponse(responseCode = "404", description = ArticleOrderConstants.PRODUCT_NOT_AVAILABLE,
	               content = @Content) })
	@PostMapping("/create")
	public ResponseEntity<OrderResponse> createNewOrder(@RequestBody OrderRequest orderRequest) {
		log.info("Inside createNewOrder controller");
		OrderResponse orderResponse = orderService.createOrder(orderRequest);
		return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.CREATED); 
	}
	
}
