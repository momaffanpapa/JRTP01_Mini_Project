package com.anish.gaya.binding;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USER_ACCOUNTS")
public class UserAccount {

	@Id
	@GeneratedValue
	private Integer userId;
	private String fullNameUser;
	private String emailIdUser;
	private Integer phnNumUser;
	private String genUser;
	private LocalDate dobUser;
	private Integer ssnUser;
	private String activeSw = "Y";
	@CreationTimestamp
	private Date create_Date;
	@UpdateTimestamp
	private Date update_Date;

}
