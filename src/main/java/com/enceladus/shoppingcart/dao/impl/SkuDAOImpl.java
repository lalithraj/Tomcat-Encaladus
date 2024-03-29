package com.enceladus.shoppingcart.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enceladus.mockdata.generate.DataGenerator;
import com.enceladus.shoppingcart.dao.SkuDAO;
import com.enceladus.shoppingcart.domain.SKU;
import com.enceladus.shoppingcart.exception.ShoppingCartException;
import com.enceladus.shoppingcart.persist.PersistLayer;

public class SkuDAOImpl implements SkuDAO {

	private DataGenerator dataGenerator = new DataGenerator();
	private static final Logger log = LoggerFactory.getLogger(SkuDAOImpl.class);
	private PersistLayer persistLayer = new PersistLayer();

	@Override
	public SKU get(String skuNumber) {
		log.info("Getting a Sku");
		return dataGenerator.generateRandomSku(skuNumber);
	}

	public SKU generate() {
		log.info("Generating a Sku");
		return dataGenerator.generateRandomSku();
	}

	@Override
	public SKU create(String skuNumber) {
		log.info("Creating a Sku");
		return dataGenerator.generateRandomSku(skuNumber);
	}

	@Override
	public SKU update(SKU sku) {
		log.info("Updating Sku");
		boolean success = persistLayer.persistSku(sku);
		if (success)
			return sku;
		throw new ShoppingCartException("Unable to persist Sku " + sku.getSkuNumber());
	}

	@Override
	public boolean delete(SKU sku) {
		log.info("Deleting a Sku");
		persistLayer.deleteSku(sku);
		return true;
	}

}
