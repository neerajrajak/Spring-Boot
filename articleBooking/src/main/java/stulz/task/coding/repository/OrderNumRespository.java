package stulz.task.coding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import stulz.task.coding.entity.OrderNum;

@Repository
public interface OrderNumRespository extends MongoRepository<OrderNum, Object> {

	OrderNum findTopByOrderByIdDesc();

}
