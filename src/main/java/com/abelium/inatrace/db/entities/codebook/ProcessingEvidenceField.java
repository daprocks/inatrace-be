package com.abelium.inatrace.db.entities.codebook;

import com.abelium.inatrace.api.types.Lengths;
import com.abelium.inatrace.db.base.TimestampEntity;
import com.abelium.inatrace.db.entities.value_chain.ValueChainProcessingEvidenceField;
import com.abelium.inatrace.types.ProcessingEvidenceFieldType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(indexes = { @Index(columnList = "label") })
@NamedQueries({
	@NamedQuery(name = "ProcessingEvidenceField.listProcessingEvidenceFieldsByValueChain", 
				query = "SELECT pef FROM ProcessingEvidenceField pef "
						+ "INNER JOIN pef.valueChains vcs "
						+ "INNER JOIN vcs.valueChain vc "
						+ "WHERE vc.id = :valueChainId"),
	@NamedQuery(name = "ProcessingEvidenceField.countProcessingEvidenceFieldsByValueChain",
	            query = "SELECT COUNT(pef) FROM ProcessingEvidenceField pef "
						+ "INNER JOIN pef.valueChains vcs "
						+ "INNER JOIN vcs.valueChain vc "
						+ "WHERE vc.id = :valueChainId")
})
public class ProcessingEvidenceField extends TimestampEntity {

	@Version
	private Long entityVersion;

	@Column(nullable = false)
	private String fieldName;

	@Column
	private String label;
	
	@Enumerated(EnumType.STRING)
	@Column(length = Lengths.ENUM, nullable = false)
	private ProcessingEvidenceFieldType type = ProcessingEvidenceFieldType.STRING;

	@OneToMany(mappedBy = "processingEvidenceField", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<ValueChainProcessingEvidenceField> valueChains;

	@OneToMany(mappedBy = "processingEvidenceField", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProcessingEvidenceFieldTranslation> processingEvidenceFieldTranslations = new ArrayList<>();

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ProcessingEvidenceFieldType getType() {
		return type;
	}

	public void setType(ProcessingEvidenceFieldType type) {
		this.type = type;
	}

	public List<ValueChainProcessingEvidenceField> getValueChains() {
		return valueChains;
	}

	public void setValueChains(List<ValueChainProcessingEvidenceField> valueChains) {
		this.valueChains = valueChains;
	}

	public List<ProcessingEvidenceFieldTranslation> getProcessingEvidenceFieldTranslations() {
		if (processingEvidenceFieldTranslations == null) {
			processingEvidenceFieldTranslations = new ArrayList<>();
		}
		return processingEvidenceFieldTranslations;
	}
}
