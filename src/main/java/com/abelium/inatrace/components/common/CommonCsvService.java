package com.abelium.inatrace.components.common;

import com.abelium.inatrace.api.errors.ApiException;
import com.abelium.inatrace.components.payment.api.ApiPayment;
import com.abelium.inatrace.components.stockorder.api.ApiStockOrder;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Service for payment csv generator.
 *
 * @author Rene Flores, Sunesis d.o.o.
 */
@Lazy
@Service
public class CommonCsvService extends BaseService {
	
	public byte[] createPaymentsByCompanyCsv(List<ApiPayment> apiPayments, Long companyId) throws ApiException, IOException {
		
		// Create CSV byte array
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try (CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(bytes), CSVFormat.RFC4180)) {
			
			// Headers
			csvPrinter.printRecord("Payment purpose", "Amount paid to the farmer", "Farmer name", "Company name", "Delivery date", "Payment date",  "Way of payment");
			// Data
			for (ApiPayment p : apiPayments) {
				csvPrinter.printRecord(
					p.getPaymentPurposeType(), p.getAmountPaidToTheFarmer(), 
					p.getRecipientUserCustomer().getName() + " " + p.getRecipientUserCustomer().getSurname(), p.getRecipientCompany().getName(),
					p.getProductionDate(), p.getFormalCreationTime(), 
					p.getPreferredWayOfPayment());
			}
			
		csvPrinter.flush();
		}
		
		return bytes.toByteArray();
	}
	
	public byte[] createPurchasesByCompanyCsv(List<ApiStockOrder> apiStockOrders, Long companyId) throws ApiException, IOException {
		
		// Create CSV byte array
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try (CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(bytes), CSVFormat.RFC4180)) {
			
			// Headers
			csvPrinter.printRecord("Delivery date", "Farmer name", "Semi-product", "Quantity", "Payable", "Open Balance",  "Way of payment");
			// Data
			for (ApiStockOrder p : apiStockOrders) {
				csvPrinter.printRecord(
					p.getDeliveryTime(),
					p.getProducerUserCustomer().getName() + " " + p.getProducerUserCustomer().getSurname(), 
					p.semiProduct.getName(), p.getTotalQuantity(),
					p.getCost(), p.getBalance(), 
					p.getPreferredWayOfPayment());
			}
			
		csvPrinter.flush();
		}
		
		return bytes.toByteArray();
	}

}
