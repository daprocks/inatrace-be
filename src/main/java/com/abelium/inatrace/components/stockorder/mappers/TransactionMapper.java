package com.abelium.inatrace.components.stockorder.mappers;

import com.abelium.inatrace.components.codebook.action_type.ActionTypeMapper;
import com.abelium.inatrace.components.codebook.grade_abbreviation.GradeAbbreviationMapper;
import com.abelium.inatrace.components.codebook.measure_unit_type.MeasureUnitTypeMapper;
import com.abelium.inatrace.components.codebook.semiproduct.SemiProductMapper;
import com.abelium.inatrace.components.company.mappers.CompanyMapper;
import com.abelium.inatrace.components.facility.FacilityMapper;
import com.abelium.inatrace.components.stockorder.api.ApiTransaction;
import com.abelium.inatrace.db.entities.stockorder.Transaction;

public class TransactionMapper {

    public static ApiTransaction toApiTransaction(Transaction entity) {
        if(entity == null) return null;
        ApiTransaction apiTransaction = new ApiTransaction();
        apiTransaction.setId(entity.getId());
        apiTransaction.setCompany(CompanyMapper.toApiCompanyBase(entity.getCompany()));
        apiTransaction.setInitiationUserId(entity.getInitiationUserId());
        apiTransaction.setSourceStockOrder(StockOrderMapper.toApiStockOrder(entity.getSourceStockOrder(), null));
        apiTransaction.setTargetStockOrder(StockOrderMapper.toApiStockOrder(entity.getTargetStockOrder(), null));
        apiTransaction.setSemiProduct(SemiProductMapper.toApiSemiProduct(entity.getSemiProduct()));
        apiTransaction.setSourceFacility(FacilityMapper.toApiFacility(entity.getSourceFacility()));
        apiTransaction.setTargetFacility(FacilityMapper.toApiFacility(entity.getTargetFacility()));
        apiTransaction.setIsProcessing(entity.getIsProcessing());
        apiTransaction.setActionType(ActionTypeMapper.toApiActionType(entity.getActionType()));
        apiTransaction.setStatus(entity.getStatus());
        apiTransaction.setShipmentId(entity.getShipmentId());
        apiTransaction.setInputMeasureUnitType(MeasureUnitTypeMapper.toApiMeasureUnitType(entity.getInputMeasureUnitType()));
        apiTransaction.setOutputMeasureUnitType(MeasureUnitTypeMapper.toApiMeasureUnitType(entity.getOutputMeasureUnitType()));
        apiTransaction.setInputQuantity(entity.getInputQuantity());
        apiTransaction.setOutputQuantity(entity.getOutputQuantity());
        apiTransaction.setPricePerUnit(entity.getPricePerUnit());
        apiTransaction.setCurrency(entity.getCurrency());
        apiTransaction.setGradeAbbreviation(GradeAbbreviationMapper.toApiGradeAbbreviation(entity.getGradeAbbreviation()));
        apiTransaction.setRejectComment(entity.getRejectComment());
        return apiTransaction;
    }

}
