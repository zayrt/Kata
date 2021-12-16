package kata;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class main {

	public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Menu menu = new Menu();
		Core core = new Core();
		core.executeCmd(menu.getChoice());
	}
}
