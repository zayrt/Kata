package kata;

import java.time.LocalDateTime;

public class Transaction {
	LocalDateTime ldt;
	String operation;
	Double amount;
	
	public Transaction(String operation, LocalDateTime ldt, Double amount) {
		this.operation = operation;
		this.ldt = ldt;
		this.amount = amount;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
