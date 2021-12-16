package kata;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Core {
	private BankAccount account = new BankAccount();
	private Map<Character, Runnable> commands = new HashMap<>();
	
	public Core() throws NoSuchMethodException {
		initCommand();
	}
	
	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public void initCommand() {
	     commands.put('1', () -> {
	    	 try {
	 			String line = account.readData("Enter your deposit:");
				makeDeposit(line);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
				e.printStackTrace();
			}
		});
	     commands.put('2', () -> {
			try {
				String line = account.readData("Enter your withdrawal:");
				makeWithdrawal(line);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
				e.printStackTrace();
			}
		});
	     commands.put('3', () -> getHistory());
	}
	
	public void executeCmd(char choice) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		commands.get(choice).run();
		Menu menu = new Menu();
		executeCmd(menu.getChoice());
	}
	
	public void makeDeposit(String line) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		try {
			Double amount = Double.valueOf(line);
			account.setBalance(account.getBalance() + amount);
			account.pushTransaction(new Transaction("Deposit", LocalDateTime.now(), amount));
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number.");
		}
	}
	
	public void makeWithdrawal(String line) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Double amount = Double.valueOf(line);
			account.setBalance(account.getBalance() - amount);
			account.pushTransaction(new Transaction("Withdrawal", LocalDateTime.now(), amount));
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number.");
		}
	}
	
	public void getHistory() {
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("\nbalance: " + df.format(account.getBalance()) +"$");
		account.showTransactions();
		System.out.println("\n");
	}
}
