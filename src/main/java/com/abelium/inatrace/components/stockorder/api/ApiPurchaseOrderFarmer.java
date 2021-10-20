package com.abelium.inatrace.components.stockorder.api;

import com.abelium.inatrace.api.ApiBaseEntity;
import com.abelium.inatrace.components.codebook.semiproduct.api.ApiSemiProduct;
import com.abelium.inatrace.components.company.api.ApiUserCustomer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public class ApiPurchaseOrderFarmer extends ApiBaseEntity {

	@ApiModelProperty(value = "Purchase order identifier", position = 1)
	private String identifier;

	@ApiModelProperty(value = "Id of the person who has produced the entry.")
	private ApiUserCustomer producerUserCustomer;

	@ApiModelProperty(value = "Semi product")
	private ApiSemiProduct semiProduct;

	@ApiModelProperty(value = "Total quantity")
	private Integer totalQuantity;

	@ApiModelProperty(value = "Fulfilled quantity")
	public Integer fulfilledQuantity;

	@ApiModelProperty(value = "Available quantity")
	public Integer availableQuantity;

	@ApiModelProperty(value = "Price per unit")
	private BigDecimal pricePerUnit;

	@ApiModelProperty(value = "Tare")
	private BigDecimal tare;

	@ApiModelProperty(value = "Damaged price deduction")
	private BigDecimal damagedPriceDeduction;

	@ApiModelProperty(value = "Organic")
	private Boolean organic;

	@ApiModelProperty(value = "Women only")
	private Boolean womenShare;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ApiUserCustomer getProducerUserCustomer() {
		return producerUserCustomer;
	}

	public void setProducerUserCustomer(ApiUserCustomer producerUserCustomer) {
		this.producerUserCustomer = producerUserCustomer;
	}

	public ApiSemiProduct getSemiProduct() {
		return semiProduct;
	}

	public void setSemiProduct(ApiSemiProduct semiProduct) {
		this.semiProduct = semiProduct;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getFulfilledQuantity() {
		return fulfilledQuantity;
	}

	public void setFulfilledQuantity(Integer fulfilledQuantity) {
		this.fulfilledQuantity = fulfilledQuantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getTare() {
		return tare;
	}

	public void setTare(BigDecimal tare) {
		this.tare = tare;
	}

	public BigDecimal getDamagedPriceDeduction() {
		return damagedPriceDeduction;
	}

	public void setDamagedPriceDeduction(BigDecimal damagedPriceDeduction) {
		this.damagedPriceDeduction = damagedPriceDeduction;
	}

	public Boolean getOrganic() {
		return organic;
	}

	public void setOrganic(Boolean organic) {
		this.organic = organic;
	}

	public Boolean getWomenShare() {
		return womenShare;
	}

	public void setWomenShare(Boolean womenShare) {
		this.womenShare = womenShare;
	}
}
