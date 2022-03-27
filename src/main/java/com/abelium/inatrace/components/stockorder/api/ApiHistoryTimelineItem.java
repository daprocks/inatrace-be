package com.abelium.inatrace.components.stockorder.api;

import com.abelium.inatrace.tools.converters.SimpleDateConverter;
import com.abelium.inatrace.types.PublicTimelineIconType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

/**
 * API model representing single item (processing) in the QR tag history timeline.
 *
 * @author Pece Adjievski, Sunesis d.o.o.
 */
public class ApiHistoryTimelineItem {

	private String type;

	private String name;

	@JsonSerialize(converter = SimpleDateConverter.Serialize.class)
	@JsonDeserialize(using = SimpleDateConverter.Deserialize.class)
	private Instant date;

	private String location;

	private PublicTimelineIconType iconType;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public PublicTimelineIconType getIconType() {
		return iconType;
	}

	public void setIconType(PublicTimelineIconType iconType) {
		this.iconType = iconType;
	}

}