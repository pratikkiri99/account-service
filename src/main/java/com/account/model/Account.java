package com.account.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@NotNull
	@Column(name = "id")
	private String id;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "balanace_date")
	private Date balanceDate;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "user_id")
	private String userId;
}
