class Calc {
	
	public static boolean isNum(String input) {
		return input.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) {
		double a = 0.0, b = 0.0, c = 0.0;
		String stringA = "", stringB = "";
		char operation = 0;

		if (args.length == 1) {
			String line = args[0];
			boolean pastOperation = false;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '+' ||
				    line.charAt(i) == '-' ||
				    line.charAt(i) == '*' ||
				    line.charAt(i) == '/') {
					operation = line.charAt(i);
					pastOperation = true;
					continue;
				}

				if (!pastOperation) stringA += line.charAt(i);
				else stringB += line.charAt(i);
			}
		}		

		else {	
			stringA = args[0];
			stringB = args[2];
			operation = args[1].charAt(0);	
		}

		if (!isNum(stringA) || !isNum(stringB)) {
			System.out.println("Invalid characters as input, exit....");
			System.exit(1);
		} else {
			a = Double.parseDouble(stringA); 
			b = Double.parseDouble(stringB);
		}

		switch(operation) {
			case '+':
			c = a + b;
			break;

			case '-':
			c = a - b;
			break;

			case '*':case 'x':case 'X':
			c = a * b;
			break;

			case '/':
			if (b == 0.0) {
				System.out.println("Incorrect value of B = " + b + ", abort...");
				System.exit(1);
			}
			c = a / b;
			break;
				
		}
				
		System.out.println(a + " " + operation + " " + b + " = " + c);
	}
}
