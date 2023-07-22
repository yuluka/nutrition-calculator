package ui;

import java.util.Scanner;

import model.Calculator;

public class ProvMenu {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void menuBeg() {
		System.out.println("\n----- Menu -----\n\n"
				+ "Selecciona el tipo de persona:"
				+ "\n1) Menor de 5 años"
				+ "\n2) Mayor de 5 años"
				+ "\n3) Gestante"
				+ "\n4) Adulto"
				+ "\n5) Adulto mayor"
				+ "\n0) Salir");
		
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			lessThanFiveYearsMenu();
			break;

		case 2:
			fiveYearsOlderMenu();
			break;
			
		case 3:
			
			break;
			
		case 4:
			adultMenu();
			break;
			
		case 5:
			
			break;
			
		case 0:
			break;
			
		default:
			System.out.println("\nSelección inválida. Intena nuevamente.");
			menuBeg();
			break;
		}
	}
	
	public static void lessThanFiveYearsMenu() {
		System.out.println("\n----- Menor de 5 Años -----\n"
				+ "Digita el indicador antropométrico:");
		
		double anthropometricIndicator = Double.parseDouble(in.nextLine());
		
		System.out.println("\nSelecciona el indicador antropométrico que deseas:"
				+ "\n1) Peso para la talla"
				+ "\n2) Talla para la edad"
				+ "\n3) Perímetro cefálico para la edad"
				+ "\n4) IMC para la edad"
				+ "\n5) Peso para la edad"
				+ "\n0) Atrás");
		
		int selection = Integer.parseInt(in.nextLine());
		
		String classification = "";
		
		switch (selection) {
		case 1:
			classification = Calculator.weightForSize(anthropometricIndicator);
			break;

		case 2:
			classification = Calculator.sizeForAge(anthropometricIndicator);
			break;
			
		case 3:
			classification = Calculator.headCircumferenceForAge(anthropometricIndicator);
			break;
			
		case 4:
			classification = Calculator.BMIForAge(anthropometricIndicator);
			break;
			
		case 5:
			classification = Calculator.weightForAge(anthropometricIndicator);
			break;
			
		case 0:
			menuBeg();
			break;
			
		default:
			System.out.println("\nSelección inválida. Intena nuevamente.");
			lessThanFiveYearsMenu();
			break;
		}
		
		System.out.println("\nLa clasificación antropométrica es: " + classification);
		
		menuBeg();
	}
	
	public static void fiveYearsOlderMenu() {
		System.out.println("\n----- Mayor de 5 Años -----\n"
				+ "Digita el indicador antropométrico:");
		
		double anthropometricIndicator = Double.parseDouble(in.nextLine());
		
		System.out.println("\nSelecciona el indicador antropométrico que deseas:"
				+ "\n1) Talla para la edad"
				+ "\n2) IMC para la edad"
				+ "\n0) Atrás");
		
		int selection = Integer.parseInt(in.nextLine());
		
		String classification = "";
		
		switch (selection) {
		case 1:
			classification = Calculator.sizeForAge(anthropometricIndicator);
			break;

		case 2:
			classification = Calculator.BMIForAge5YearsOlder(anthropometricIndicator);
			break;
			
		case 0:
			menuBeg();
			break;
			
		default:
			System.out.println("\nSelección inválida. Intena nuevamente.");
			fiveYearsOlderMenu();
			break;
		}
		
		System.out.println("\nLa clasificación antropométrica es: " + classification);
		
		menuBeg();
	}
	
	public static void adultMenu() {
		System.out.println("\n----- Adulto -----\n"
				+ "\nSelecciona el indicador antropométrico que deseas:"
				+ "\n1) IMC"
				+ "\n2) Peso ideal"
				+ "\n3) Riesgo cardiovascular"
				+ "\n4) Grasa corporal"
				+ "\n0) Atrás");
		
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			calculateAdultBMI();
			break;

		case 2:
			calculateAdultIdealWeight();
			break;
			
		case 0:
			menuBeg();
			break;
			
		default:
			System.out.println("\nSelección inválida. Intena nuevamente.");
			adultMenu();
			break;
		}
	}
	
	public static void calculateAdultBMI() {
		System.out.println("\n--- Calcular IMC para adulto ---\n"
				+ "\nDigita el peso de la persona:");
		
		double weight = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita la estatura de la persona:");
		
		double height = Double.parseDouble(in.nextLine());
		
		System.out.println("\nResultado: " + Calculator.adultBMI(weight, height));
		
		menuBeg();
	}
	
	public static void calculateAdultIdealWeight() {
		System.out.println("\n--- Calcular Peso Ideal para adulto ---\n"
				+ "\nDigita la altura de la persona en cms:");
		
		double height = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita el carpo de la persona en cms:");
		
		double carpus = Double.parseDouble(in.nextLine());
		
		System.out.println("\nSelecciona el género  de la persona:"
				+ "\n1) Mujer"
				+ "\n2) Hombre");
		
		int selection = Integer.parseInt(in.nextLine());
		boolean gender = false;
		
		switch (selection) {
		case 1:
			gender = true;
			break;
		}
		
		System.out.println("\nPeso ideal por fórmula de complexión: " + Calculator.adultIdealWeight(height, carpus, gender));
		
		System.out.println("\nPeso ideal por fórmula de Lorentz: " + Calculator.adultIdealWeightLorentz(height, gender));
		
		System.out.println("\nPeso ideal por fórmula de Regresión: " + Calculator.adultIdealWeightRegression((height/100), carpus, gender));

		menuBeg();
	}
	
	public static void calculateAdultCardiovascularRisk() {
		System.out.println("\n--- Calcular Riesgo Cardiovascular ---\n"
				+ "\nDigita la circunferencia de cintura en cms:");
		
		double waist = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita la circunferencia de cadera en cms:");
		
		double hip = Double.parseDouble(in.nextLine());
		
		System.out.println("\nSelecciona el género  de la persona:"
				+ "\n1) Mujer"
				+ "\n2) Hombre");
		
		int selection = Integer.parseInt(in.nextLine());
		boolean gender = false;
		
		switch (selection) {
		case 1:
			gender = true;
			break;
		}
		
		System.out.println("\nResultado:\n" + Calculator.adultCardiovascularRisk(waist, hip, gender));
		
		menuBeg();
	}
	
	public static void calculateBodyFatPercentage() {
		System.out.println("\n--- Calcular Porcentaje de Grasa Corporal ---\n"
				+ "\nSelecciona la fórmula que deseas usar:"
				+ "\n1) Faulkner"
				+ "\n2) Yuhasz");
		
		int selection = Integer.parseInt(in.nextLine());
		
		System.out.println("\nSelecciona el género  de la persona:"
				+ "\n1) Mujer"
				+ "\n2) Hombre");
		
		int genderSelection = Integer.parseInt(in.nextLine());
		boolean gender = false;
		
		switch (genderSelection) {
		case 1:
			gender = true;
			break;
		}
		
		System.out.println("\nDigita el valor del plieguie tricipital:");
		
		double tricipitalFold = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita el valor del plieguie abdominal:");
		
		double abdominalFold = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita el valor del plieguie subescapular:");
		
		double subscapularFold = Double.parseDouble(in.nextLine());
		
		System.out.println("\nDigita el valor del plieguie supraespinal:");
		
		double supraspinalFoldFold = Double.parseDouble(in.nextLine());
		
		String result = "";
		
		switch (selection) {
		case 1:
			result = Calculator.adultBodyFatFaulkner(tricipitalFold, abdominalFold, subscapularFold, supraspinalFoldFold, gender);
			break;

		case 2:
			System.out.println("\nDigita el valor del plieguie muslo frontal:");
			
			double thighFold = Double.parseDouble(in.nextLine());
			
			System.out.println("\nDigita el valor del plieguie de pantorrilla:");
			
			double calfFold = Double.parseDouble(in.nextLine());
			
			result = Calculator.adultBodyFatYuhasz(tricipitalFold, abdominalFold, subscapularFold, supraspinalFoldFold, thighFold, calfFold, gender);
			
			break;
			
		default:
			System.out.println("\nSelección inválida. Intenta nuevamente.");
			calculateBodyFatPercentage();
			break;
		}
		
		System.out.println("\nResultado:\n" + result);
		
		menuBeg();
	}
}
