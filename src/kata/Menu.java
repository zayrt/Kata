package kata;

import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	private char choice;
	
	public Menu() throws IOException {
		showMenu();
		choice = readChoice();
	}

	public char getChoice() {
		return choice;
	}
	
	public void showMenu() {
		System.out.println("Bank account");
		System.out.println("For make a deposit hit 1:");
		System.out.println("For make a withdrawal hit 2:");
		System.out.println("For see the history hit 3:");		
	}
	
	public char readChoice() throws IOException {
		InputStreamReader inp = null;
        inp = new InputStreamReader(System.in);
	
        char c;
        do {
            c = (char)inp.read();
            if (c != '1' && c != '2' && c != '3') {            	
            	System.out.println("Choix incorrect." + c);
            }
        } while (c != '1' && c != '2' && c != '3');
        return c;
	}
}

