package com.abelium.inatrace.db.entities.processingaction;

import com.abelium.inatrace.db.base.BaseEntity;
import com.abelium.inatrace.db.entities.codebook.ProcessingEvidenceType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ProcessingActionPET extends BaseEntity {

	@ManyToOne
	@NotNull
	private ProcessingAction processingAction;

	@ManyToOne
	@NotNull
	private ProcessingEvidenceType processingEvidenceType;

	private Boolean mandatory;

	private Boolean requiredOnQuote;

	private String requiredOneOfGroupIdForQuote;

	public ProcessingAction getProcessingAction() {
		return processingAction;
	}

	public void setProcessingAction(ProcessingAction processingAction) {
		this.processingAction = processingAction;
	}

	public ProcessingEvidenceType getProcessingEvidenceType() {
		return processingEvidenceType;
	}

	public void setProcessingEvidenceType(ProcessingEvidenceType processingEvidenceType) {
		this.processingEvidenceType = processingEvidenceType;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Boolean getRequiredOnQuote() {
		return requiredOnQuote;
	}

	public void setRequiredOnQuote(Boolean requiredOnQuote) {
		this.requiredOnQuote = requiredOnQuote;
	}

	public String getRequiredOneOfGroupIdForQuote() {
		return requiredOneOfGroupIdForQuote;
	}

	public void setRequiredOneOfGroupIdForQuote(String requiredOneOfGroupIdForQuote) {
		this.requiredOneOfGroupIdForQuote = requiredOneOfGroupIdForQuote;
	}

	public ProcessingActionPET(
		@NotNull ProcessingAction processingAction,
		@NotNull ProcessingEvidenceType processingEvidenceType,
		Boolean mandatory,
		Boolean requiredOnQuote,
		String requiredOneOfGroupIdForQuote) {
		super();
		this.processingAction = processingAction;
		this.processingEvidenceType = processingEvidenceType;
		this.mandatory = mandatory;
		this.requiredOnQuote = requiredOnQuote;
		this.requiredOneOfGroupIdForQuote = requiredOneOfGroupIdForQuote;
	}

	public ProcessingActionPET() {
		super();
	}
	
}
