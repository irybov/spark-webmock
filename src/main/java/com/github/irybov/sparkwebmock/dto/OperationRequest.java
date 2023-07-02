package com.github.irybov.sparkwebmock.dto;

/*import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@ApiModel(description = "Incoming payment data object")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OperationRequest {

/*	@ApiModelProperty(value = "Sender's bill number", required = true, example = "999_999_999")
	@JsonProperty("sender")
	@NotNull(message = "Sender must not be null")
	@Max(value = 999_999_999, message = "Sender's bill number should be less than 10 digits length")
	@Positive(message = "Sender's bill number should be positive number")*/
	private Integer sender;
	
/*	@ApiModelProperty(value = "Recepient's bill number", required = true, example = "999_999_999")
	@JsonProperty("recipient")
	@NotNull(message = "Recepient must not be null")
	@Max(value = 999_999_999, message = "Recepient's bill number should be less than 10 digits length")
	@Positive(message = "Recepient's bill number should be positive number")*/
	private Integer recipient;
	
/*	@ApiModelProperty(value = "Currency's standard name", required = true, example = "USD")
	@JsonProperty("currency")
	@NotBlank(message = "Currency must not be blank")
	@Pattern(regexp = "^[A-Z]{3}$", message = "Currency code should be 3 capital characters length")*/
	private String currency;
	
/*	@ApiModelProperty(value = "Amount of money", required = true, example = "9.99")
	@JsonProperty("amount")
	@NotNull(message = "Amount must not be null")
	@Positive(message = "Amount of money should be higher than zero")*/
	private Double amount;
	
	private String bank;
	
}
