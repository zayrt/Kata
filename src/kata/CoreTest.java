package kata;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class CoreTest {

	@Test
	public void testDeposit() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Core core = new Core();
		core.makeDeposit("3000");
		BankAccount account = core.getAccount();
		assertEquals(new Double("3000"), account.getBalance());
	}

	@Test
	public void testWithdrawal() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Core core = new Core();
		core.makeWithdrawal("40");
		BankAccount account = core.getAccount();
		assertEquals(new Double("-40"), account.getBalance());
	}
	
	@Test
	public void testHistory() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		Core core = new Core();
		core.makeDeposit("3000");
		core.makeWithdrawal("40");
		core.makeWithdrawal("300");
		core.makeWithdrawal("50");
		BankAccount account = core.getAccount();
		assertEquals(new Double(3000 - 40 - 300 - 50), account.getBalance());
		assertEquals(4, account.getTransactions().size());
	}
}
