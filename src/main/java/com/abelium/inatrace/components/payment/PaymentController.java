package com.abelium.inatrace.components.payment;

import com.abelium.inatrace.api.ApiBaseEntity;
import com.abelium.inatrace.api.ApiDefaultResponse;
import com.abelium.inatrace.api.ApiPaginatedRequest;
import com.abelium.inatrace.api.ApiPaginatedResponse;
import com.abelium.inatrace.api.ApiResponse;
import com.abelium.inatrace.api.errors.ApiException;
import com.abelium.inatrace.components.payment.api.ApiBulkPayment;
import com.abelium.inatrace.components.payment.api.ApiPayment;
import com.abelium.inatrace.components.stockorder.converters.SimpleDateConverter;
import com.abelium.inatrace.db.entities.payment.PaymentStatus;
import com.abelium.inatrace.db.entities.stockorder.enums.PreferredWayOfPayment;
import com.abelium.inatrace.security.service.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST controller for payment entity.
 *
 * @author Rene Flores, Sunesis d.o.o.
 */
@RestController
@RequestMapping("/chain/payment")
public class PaymentController {

	private final PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping("list")
	@ApiOperation("Get a paginated list of payments.")
	public ApiPaginatedResponse<ApiPayment> getPaymentList(
			@Valid ApiPaginatedRequest request,
			@Valid @ApiParam(value = "Preferred way of payment") @RequestParam(value = "preferredWayOfPayment", required = false) PreferredWayOfPayment preferredWayOfPayment,
			@Valid @ApiParam(value = "Payment status") @RequestParam(value = "paymentStatus", required = false) PaymentStatus paymentStatus,
			@Valid @ApiParam(value = "Production date range start") @RequestParam(value = "productionDateStart", required = false) @DateTimeFormat(pattern = SimpleDateConverter.SIMPLE_DATE_FORMAT) Date productionDateStart,
			@Valid @ApiParam(value = "Production date range end") @RequestParam(value = "productionDateEnd", required = false) @DateTimeFormat(pattern = SimpleDateConverter.SIMPLE_DATE_FORMAT) Date productionDateEnd,
			@Valid @ApiParam(value = "Search by farmer name") @RequestParam(value = "query", required = false) String farmerName) {

		return new ApiPaginatedResponse<>(paymentService.getPaymentList(
				request,
				new PaymentQueryRequest(
						preferredWayOfPayment,
						paymentStatus,
						productionDateStart != null ? productionDateStart.toInstant() : null,
						productionDateEnd != null ? productionDateEnd.toInstant() : null,
						farmerName
				)));
	}
	
	@GetMapping("{id}")
	@ApiOperation("Get a single payment with the provided ID.")
	public ApiResponse<ApiPayment> getPayment(@Valid @ApiParam(value = "Payment ID", required = true) @PathVariable("id") Long id) throws ApiException {

		return new ApiResponse<>(paymentService.getPayment(id));
	}
	
	@GetMapping("bulk-payment/{id}")
	@ApiOperation("Get a single bulk payment with the provided ID.")
	public ApiResponse<ApiBulkPayment> getBulkPayment(@Valid @ApiParam(value = "Payment ID", required = true) @PathVariable("id") Long id) throws ApiException {

		return new ApiResponse<>(paymentService.getBulkPayment(id));
	}
	
	@GetMapping("list/purchase/{id}")
	@ApiOperation("Get a list of payments by purchase order (stock order) ID.")
	public ApiPaginatedResponse<ApiPayment> listPaymentsByPurchase(
		@Valid @ApiParam(value = "Purchase ID", required = true) @PathVariable("id") Long purchaseId, 
		@Valid ApiPaginatedRequest request) {

		return new ApiPaginatedResponse<>(paymentService.listPaymentsByPurchase(purchaseId, request));
	}
	
	@GetMapping("list/company/{id}")
	@ApiOperation("Get a list of payments by company ID.")
	public ApiPaginatedResponse<ApiPayment> listPaymentsByCompany(
		@Valid @ApiParam(value = "Company ID", required = true) @PathVariable("id") Long companyId, 
		@Valid ApiPaginatedRequest request) {

		return new ApiPaginatedResponse<>(paymentService.listPaymentsByCompany(companyId, request));
	}
	
	@GetMapping("list/bulk-payment/company/{id}")
	@ApiOperation("Get a list of bulk payments by company ID.")
	public ApiPaginatedResponse<ApiBulkPayment> listBulkPaymentsByCompany(
		@Valid @ApiParam(value = "Company ID", required = true) @PathVariable("id") Long companyId, 
		@Valid ApiPaginatedRequest request) {

		return new ApiPaginatedResponse<>(paymentService.listBulkPaymentsByCompany(companyId, request));
	}

	@PutMapping
	@ApiOperation("Create or update payment. If ID is provided, then the entity with the provided ID is updated.")
	public ApiResponse<ApiBaseEntity> createOrUpdatePayment(
			@Valid @RequestBody ApiPayment apiPayment,
			@AuthenticationPrincipal CustomUserDetails authUser) throws ApiException {

		return new ApiResponse<>(paymentService.createOrUpdatePayment(apiPayment, authUser.getUserId()));
	}
	
	@PutMapping("bulk-payment")
	@ApiOperation("Create bulk payment.")
	public ApiResponse<ApiBaseEntity> createOrUpdateBulkPayment(
			@Valid @RequestBody ApiBulkPayment apiBulkPayment,
			@AuthenticationPrincipal CustomUserDetails authUser) throws ApiException {

		return new ApiResponse<>(paymentService.createOrUpdateBulkPayment(apiBulkPayment, authUser.getUserId()));
	}

	@DeleteMapping("{id}")
	@ApiOperation("Deletes a payment with the provided ID.")
	public ApiDefaultResponse deletePayment(@Valid @ApiParam(value = "Payment ID", required = true) @PathVariable("id") Long id) throws ApiException {

		paymentService.deletePayment(id);
		return new ApiDefaultResponse();
	}
}
