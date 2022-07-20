package br.com.challenge.gwsystems.deliverymanager.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="product")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double Weight;
	
	 @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	 private Set<DeliveryModel> delivery;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public Set<DeliveryModel> getDelivery() {
		return delivery;
	}

	public void setDelivery(Set<DeliveryModel> delivery) {
		this.delivery = delivery;
	}
	 
	 
}
