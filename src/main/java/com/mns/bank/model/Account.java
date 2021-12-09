package com.mns.bank.model;

import com.mns.bank.bean.AppException;

public class Account {
	
	private Long num;
	private String label;
	private Double solde;
	private Double overdraftAllowed;
	private Client client;
	
	public Account(String label, Double solde, Double overdraftAllowed, Client client) {
		super();
		this.label = label;
		this.solde = solde;
		this.overdraftAllowed = overdraftAllowed;
		this.client = client;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Double getOverdraftAllowed() {
		return overdraftAllowed;
	}

	public void setOverdraftAllowed(Double overdraftAllowed) {
		this.overdraftAllowed = overdraftAllowed;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void credit(double amount) throws AppException {
		if (amount >= 0) { 
			solde += amount;
		} else {
			throw new AppException("Credit illegal amount : " + amount);
		}
	}
	
	public void withdrawal(double amount) throws AppException {
		if (amount < 0) {
			throw new AppException("Withdrawal illegal amount : " + amount);
		} else if (solde + overdraftAllowed >= amount) {
			solde -= amount;
		} else {
			throw new AppException("Withdrawal amount exceeds overdraft allowed !");
		}
	}
}
