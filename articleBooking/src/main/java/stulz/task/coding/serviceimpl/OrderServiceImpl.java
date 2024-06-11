package stulz.task.coding.serviceimpl;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import stulz.task.coding.constants.ArticleOrderConstants;
import stulz.task.coding.dto.OrderRequest;
import stulz.task.coding.dto.OrderResponse;
import stulz.task.coding.entity.Article;
import stulz.task.coding.entity.OrderArticle;
import stulz.task.coding.entity.OrderNum;
import stulz.task.coding.exception.ArticleNotFoundException;
import stulz.task.coding.exception.InventoryNotAvailableException;
import stulz.task.coding.repository.OrderNumRespository;
import stulz.task.coding.repository.OrderRepository;
import stulz.task.coding.service.ArticleService;
import stulz.task.coding.service.InventoryService;
import stulz.task.coding.service.OrderService;



@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderNumRespository orderNumRespository;

	@Value("${logistics.cheap}")
	private int cheapLogistics;

	@Value("${logistics.fast}")
	private int fastLogistics;
	
	@Override
	@Transactional
	public OrderResponse createOrder(OrderRequest orderRequest) {
		log.info("Inside createOrder Service");
		int totalArticleAvailable = inventoryService.getArticleQuantity(orderRequest.getArticleId());

		if (orderRequest.getQuantity() > totalArticleAvailable) {
			throw new InventoryNotAvailableException(ArticleOrderConstants.PRODUCT_NOT_AVAILABLE);
		} else {

			Article article = articleService.getArticle(orderRequest.getArticleId());
			OrderResponse orderResponse = calculateOrderPrice(orderRequest, article);
			
			log.info("OrderResponse: ", orderResponse);
			
			OrderArticle orderArticle = new OrderArticle();
			orderArticle.setOrderId(getNextOrderId());
			orderArticle.setArticleId(orderRequest.getArticleId());
			orderArticle.setQuantity(orderRequest.getQuantity());
			orderArticle.setLogisticProvider(orderRequest.getLogisticsOpted());
			orderArticle.setTotalOrderPrice(orderResponse.getTotalOrderPrice());
			orderArticle.setTotalLogisticsPrice(orderResponse.getTotalLogisticsPrice());
			orderArticle.setTotalPrice(orderResponse.getTotalPrice());
			orderRepository.save(orderArticle);
			
			log.info("CreatedOrder: ", orderArticle.toString()); 
			
			int updatedQuantity = inventoryService.updateInventoryCount(orderArticle.getArticleId(),(totalArticleAvailable - orderArticle.getQuantity()));
			
			log.info("Updated quantity for Article "+ article.getArticleTitle() + " is: "+updatedQuantity);
			
			return orderResponse;
		}
	}

	private OrderResponse calculateOrderPrice(OrderRequest orderRequest, Article article) {
		log.info("Inside calculateOrderPrice");
		OrderResponse orderResponse = null;
		if (article != null) {
			var orderPrice = article.getPrice() * orderRequest.getQuantity();
			int logisticPrice = orderRequest.getLogisticsOpted().equals(ArticleOrderConstants.FAST_LOGISTIC)
					? fastLogistics
					: cheapLogistics;
			var totalPrice = orderPrice + logisticPrice;
			
			orderResponse = new OrderResponse(orderPrice, logisticPrice, totalPrice);
		} else {
			throw new ArticleNotFoundException(ArticleOrderConstants.ARTICLE_NOT_FOUND);
		}

		return orderResponse;
	}
	
	public String getNextOrderId() {
		OrderNum last = orderNumRespository.findTopByOrderByIdDesc();

		if (Objects.isNull(last) || Objects.isNull(last.seq)) {
			last = new OrderNum(0);
		}

		OrderNum next = new OrderNum(last.seq + 1);
		orderNumRespository.save(next);
		long latestSeq =  next.seq;
		return StringUtils.leftPad(String.valueOf(latestSeq), 4, "0");
	}

}
