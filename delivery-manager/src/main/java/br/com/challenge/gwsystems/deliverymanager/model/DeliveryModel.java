package br.com.challenge.gwsystems.deliverymanager.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delivery")
public class DeliveryModel {

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

	@Column
    private Date dateExit;
    
	@Column
    private Date dateDelivery;

	@Column
    private String status;

	@ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private ClientModel sender;

	@ManyToOne
    @JoinColumn(name = "addressee_id", nullable = false)
    private ClientModel addressee;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateExit() {
		return dateExit;
	}

	public void setDateExit(Date dateExit) {
		this.dateExit = dateExit;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClientModel getSender() {
		return sender;
	}

	public void setSender(ClientModel sender) {
		this.sender = sender;
	}

	public ClientModel getAddressee() {
		return addressee;
	}

	public void setAddressee(ClientModel addressee) {
		this.addressee = addressee;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
}
