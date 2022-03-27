package com.abelium.inatrace.components.stockorder.api;

import io.swagger.annotations.ApiModelProperty;

/**
 * API model for QR code tag history (public Stock order data) used in B2C page.
 *
 * @author Pece Adjievski, Sunesis d.o.o.
 */
public class ApiQRTagPublic {

	@ApiModelProperty(value = "The QR code tag")
	private String qrTag;

	@ApiModelProperty(value = "The global (product) order of the Stock order")
	private String orderId;

	@ApiModelProperty(value = "The Producer name")
	private String producerName;

	private ApiHistoryTimeline historyTimeline;

	public String getQrTag() {
		return qrTag;
	}

	public void setQrTag(String qrTag) {
		this.qrTag = qrTag;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public ApiHistoryTimeline getHistoryTimeline() {
		return historyTimeline;
	}

	public void setHistoryTimeline(ApiHistoryTimeline historyTimeline) {
		this.historyTimeline = historyTimeline;
	}

}