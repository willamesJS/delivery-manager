package br.com.challenge.gwsystems.deliverymanager.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.challenge.gwsystems.deliverymanager.model.ProductModel;

public interface ProductRepository  extends CrudRepository<ProductModel, Long> {
}
