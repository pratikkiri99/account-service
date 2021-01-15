package com.account.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id
	@NotNull
	@Column(name = "id")
	private String id;
	
	@Column(name = "value_date")
	private String valueDate;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "transaction_debit_credit")
	private String transactionAction;
	
	@Column(name = "narrative")
	private String nerrative;
	
	@ManyToOne
	@JoinColumn(name = "account_number", nullable = false)
	private Account account;
}
