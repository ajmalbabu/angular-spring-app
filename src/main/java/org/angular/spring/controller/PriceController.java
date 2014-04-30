package org.angular.spring.controller;

import java.net.URI;
import java.util.List;

import org.angular.spring.example.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping("/pricelist")
public class PriceController {

	@Autowired
	DummyPriceRepository priceRepository;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Price> list() {

		log("Reached price controller -> query the price list...");

		log(priceRepository.getPriceList());

		return priceRepository.getPriceList();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Price find(@PathVariable("id") Integer id) {
		return priceRepository.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePrice(@PathVariable("id") Integer id,
			@RequestBody Price price) {
		log("Put price called for price: " + price);
		priceRepository.update(price);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public HttpEntity<?> create(@RequestBody Price price,
			@Value("#{request.requestURL}") StringBuffer parentUri) {
		log("create price called for price: " + price);
		price = priceRepository.save(price);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(childLocation(parentUri, price.getName()));
		return new HttpEntity<Object>(headers);
	}

	private URI childLocation(StringBuffer parentUri, Object childId) {
		UriTemplate uri = new UriTemplate(parentUri.append("/{childId}")
				.toString());
		return uri.expand(childId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		log("Delete called for id: " + id);
		priceRepository.delete(id);
	}

	@RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
	public @ResponseBody
	void removeAllPrices() {
		log("Delete all called");
		priceRepository.deleteAll();
	}

	@RequestMapping("/layout")
	public String getInitialPage() {
		return "pricelist/layout";
	}

	private void log(Object data) {
		System.out.println(data);
	}
}
