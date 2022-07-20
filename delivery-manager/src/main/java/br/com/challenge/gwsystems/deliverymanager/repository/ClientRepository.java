package br.com.challenge.gwsystems.deliverymanager.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.challenge.gwsystems.deliverymanager.model.ClientModel;

public interface ClientRepository extends CrudRepository<ClientModel, Long> {

}
