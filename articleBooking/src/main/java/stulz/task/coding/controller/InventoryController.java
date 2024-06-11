package stulz.task.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import stulz.task.coding.constants.ArticleOrderConstants;
import stulz.task.coding.service.InventoryService;

@RestController
@RequestMapping("api/inventory")
@Slf4j
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@Tag(name = "GET", description = "API to get total quantity in stocks")
	@ApiResponses({
	       @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
	               schema = @Schema(implementation = Integer.class)) }),
	       @ApiResponse(responseCode = "404", description = ArticleOrderConstants.ARTICLE_NOT_FOUND,
	               content = @Content) })
	@GetMapping("/quantity/{articleId}")
	public ResponseEntity<Integer> getArticleQuantity(@PathVariable String articleId) {
		log.info("Inside getArticleQuantity controller");
			return new ResponseEntity<Integer>(inventoryService.getArticleQuantity(articleId), HttpStatus.OK);
	}
}
