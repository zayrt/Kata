package kata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount {
	private Double balance = 0.0;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public String readData(String title) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		System.out.println(title);
		line = reader.readLine();
		return line;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void pushTransaction(Transaction transac) {
		transactions.add(transac);
	}
	
	public void showTransactions() {
		transactions.forEach(transac -> {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			DecimalFormat df = new DecimalFormat("###.##");
			System.out.println(dtf.format(transac.getLdt()) + " " + transac.getOperation() + " " + df.format(transac.getAmount()) + "$");
		});
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
}
