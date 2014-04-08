package org.angular.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.angular.spring.example.model.Price;
import org.angular.spring.example.model.Tier;
import org.springframework.stereotype.Component;

@Component
public class DummyPriceRepository {
	private Map<Integer, Price> priceList = new HashMap<Integer, Price>();

	public DummyPriceRepository() {
		List<Tier> tl = new ArrayList<Tier>();
		tl.add(new Tier("Tier-1", "Value1"));
		tl.add(new Tier("Tier-2", "Value2"));
		Price price = new Price("price-list - 10", tl);
		price.setId(nextId());
		priceList.put(price.getId(), price);

		tl = new ArrayList<Tier>();
		tl.add(new Tier("Tier-3", "Value3"));
		tl.add(new Tier("Tier-4", "Value4"));
		price = new Price("price-list - 2", tl);
		price.setId(nextId());
		priceList.put(price.getId(), price);
	}

	Price findById(Integer id) {
		return priceList.get(id);
	}

	public List<Price> getPriceList() {
		return new ArrayList<Price>(priceList.values());

	}

	public Price save(Price price) {
		if (price.getId() == null) {
			price.setId(nextId());
		}
		priceList.put(price.getId(), price);

		return price;
	}

	private Integer nextId() {
		if (priceList.isEmpty()) {
			return 1;
		} else {
			return Collections.max(priceList.keySet()) + 1;
		}
	}

	public void deleteAll() {
		priceList.clear();
		
	}

	public void delete(Integer id) {
		priceList.remove(id);
		
	}

	public void update(Price price) {
		priceList.remove(price.getId());
		priceList.put(price.getId(), price);
		
	}
}
