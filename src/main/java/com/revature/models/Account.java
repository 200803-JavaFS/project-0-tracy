package com.revature.models;

public class Account {
	
	private int accountId;
	private User userId;
	private String accountType;
	private double accountBalance;
	private String Status;
	
	public Account() {
		super();
	}

	public Account(int accontId, User userId, String accountType, double acountBalance, String status) {
		super();
		this.accountId = accontId;
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = acountBalance;
		Status = status;
	}

	public Account(User userId, String accountType, double acountBalance, String status) {
		super();
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = acountBalance;
		this.Status = status;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accontId) {
		this.accountId = accontId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double acountBalance) {
		this.accountBalance = acountBalance;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + accountId;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accontId=" + accountId + ", userId=" + userId.getUserId() + ", accountType=" + accountType
				+ ", acountBalance=" + accountBalance + ", Status=" + Status + "]";
	}
	
	
	
	
	}
	

