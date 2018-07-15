import java.math.BigDecimal;
import java.util.Scanner;

public class Service {
	public void method() {
		System.out.println("1.To register");
		System.out.println("2.login");
		System.out.println("3.exit");
		int choice = 0;
		System.out.println("enter the choice");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			// register account code
			break;
		case 2:
			System.out.println("enter login id");
			String id = scanner.next();
			System.out.println("enter password");
			String pass = scanner.next();
			boolean result = service.loginCustomer(id, pass);
			if (result == true) {
				// total code enter here
			}
		}
	}

	boolean validatePassword(String pass) throws Exception {
		if (!((pass.length()) >= 8)) {
			throw new Exception();
		}
		return true;
	}

	boolean validatePhone(String phone) throws Exception {
		String pattern = "\\d{10}";
		if (!(phone.matches(pattern))) {
			throw new Exception();
		}
		return true;
	}

	boolean validateMoney(BigDecimal amount) throws Exception {
		String amou = amount.toString();
		if (amou.matches("\\d")) {
			throw new Exception();
		}
		return true;
	}

	boolean validateName(String name) throws Exception {
		if (name.matches("[A-Za-z]+")) {
			throw new Exception();
		}
		return true;

	}

	boolean validateEmail(String email) throws Exception {
		if (!(email.matches("[a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]{2,}"))) {
			throw new Exception();
		}
		return true;
	}

	boolean validateAge(Integer age) throws Exception {
		String age1 = age.toString();
		if (!(age1.contains("[0-9]{2}"))) {
			throw new Exception();
		}
		return true;
	}

	boolean validateGender(String gender) throws Exception {
		if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
			return true;
		} else if (gender.equalsIgnoreCase("female")
				|| gender.equalsIgnoreCase("f")) {
			return true;
		} else {
			throw new Exception();
		}
	}

}