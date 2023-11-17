package com.abelium.inatrace.db.entities.codebook;

import com.abelium.inatrace.db.base.CodebookBaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Codebook entity for measuring unit types.
 *
 * @author Pece Adjievski, Sunesis d.o.o.
 */
@Entity
public class MeasureUnitType extends CodebookBaseEntity {

	private BigDecimal weight;
	private int Quantity;
	private Boolean AggregateByWeight;

	@ManyToOne
	private MeasureUnitType underlyingMeasurementUnitType;

	public MeasureUnitType() {
		super();
	}

	public MeasureUnitType(String code, String label, BigDecimal weight) {
		super(code, label);
		this.weight = weight;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public MeasureUnitType getUnderlyingMeasurementUnitType() {
		return underlyingMeasurementUnitType;
	}

	public void setUnderlyingMeasurementUnitType(MeasureUnitType underlyingMeasurementUnitType) {
		this.underlyingMeasurementUnitType = underlyingMeasurementUnitType;
	}
	
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Boolean getAggregateByWeight() {
		return AggregateByWeight;
	}

	public void setAggregateByWeight(Boolean aggregateByWeight) {
		AggregateByWeight = aggregateByWeight;
	}
	
	
}
