package model;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;

public class Calculator {

	//--- LESS THAN 5 YEARS OLD ---
	
	/**
	 * Determines the weight classification of a child under 5 years of age depending 
	 * on the value of the input indicator.
	 * 
	 * @param indicator the value to determine the classification.
	 * @return the classification.
	 */
	public static String weightForSize(double indicator) {
		if(indicator > 3) {
			return "Obesidad";
		} else if (isInRange(indicator, 2, false, 3, true)) {
			return "Sobrepeso";
		} else if (isInRange(indicator, 1, false, 2, true)) {
			return "Riesgo de Sobrepeso";
		} else if (isInRange(indicator, -1, true, 1, true)) {
			return "Peso Adecuado para la Talla";
		} else if (isInRange(indicator, -2, true, -1, false)) {
			return "Riesgo de Desnutrición Aguda";
		} else if (isInRange(indicator, -3, true, -2, false)) {
			return "Desnutrición Aguda Modearada";
		} else {
			return "Desnutrición Aguda Severa";
		}
	}
	
	/**
	 * Determines the height classification of a child under 5 years of age depending 
	 * on the value of the input indicator.
	 * 
	 * @param indicatort he value to determine the classification.
	 * @return the classification.
	 */
	public static String sizeForAge(double indicator) {
		if(indicator >= -1) {
			return "Talla Adecuada para la Edad";
		} else if (isInRange(indicator, -2, true, -1, false)) {
			return "Riesgo de Talla Baja";
		} else {
			return "Talla Baja para la Edad";
		}
	}
	
	/**
	 * Determines the classification of the head circumference of a child under 5 years 
	 * of age depending on the value of the input indicator.
	 * 
	 * @param indicatort he value to determine the classification.
	 * @return the classification.
	 */
	public static String headCircumferenceForAge(double indicator) {
		if(isInRange(indicator, -2, true, 2, true)) {
			return "Normal";
		} else {
			return "Factor de Riesgo para el Desarrollo Neurodesarrollo";
		}
	}
	
	/**
	 * Determines the BMI classification, for a child under 5 years of age, based 
	 * on the value of the input indicator.
	 * 
	 * @param indicator the value to determine the classification.
	 * @return the classification of the BMI.
	 */
	public static String BMIForAge(double indicator) {
		if(indicator > 3) {
			return "Obesidad";
		} else if(isInRange(indicator, 2, false, 3, true)) {
			return "Sobrepeso";
		} else if(isInRange(indicator, 1, false, 2, true)) {
			return "Riesgo de Sobrepeso";
		} else {
			return "No Aplica (Verificar con P/T)";			
		}
	}
	
	/**
	 * Determines the weight classification of a child under 5 years of age depending 
	 * on the value of the input indicator.
	 * 
	 * @param indicator the value to determine the classification.
	 * @return the classification.
	 */
	public static String weightForAge(double indicator) {
		if (indicator > 1) {
			return "No Aplica (Verificar con IMC/E)";
		} else if (isInRange(indicator, -1, true, 1, false)) {
			return "Peso Adecuado para la Edad";
		} else if (isInRange(indicator, -2, true, -1, false)) {
			return "Riesgo de Desnutrición Global";
		} else {
			return "Desnutrición Global";
		}
	}
	
	//--- OVER 5 YEARS OLD ---
	
	/**
	 * Determines the BMI classification, for a child over 5 years of age, based 
	 * on the value of the input indicator.
	 * 
	 * @param indicator the value to determine the classification.
	 * @return the classification of the BMI.
	 */
	public static String BMIForAge5YearsOlder(double indicator) {
		if(indicator > 2) {
			return "Obesidad";
		} else if (isInRange(indicator, 1, false, 2, true)) {
			return "Sobrepeso";
		} else if (isInRange(indicator, -1, false, 1, true)) {
			return "IMC Adecuado para la Edad";
		} else if (isInRange(indicator, -2, true, -1, false)) {
			return "Riesgo de Delgadez";
		} else {
			return "Delgadez";
		}
	}
	
	//--- PREGNANT ---
	
	//--- ADULT ---
	
	/**
	 * Calculates the BMI for an adult and returns a classification based on the result.
	 * 
	 * @param weight weight of the adult.
	 * @param height height of the adult.
	 * @return the classification based on the calculated BMI.
	 */
	public static String adultBMI(double weight, double height) {
		double bmi = calculateBMI(weight, height);
		
		String classification = "IMC: " + bmi + " - ";
		
		if(bmi < 16) {
			classification += "Delgadez Severa";
		} else if (isInRange(bmi, 16, true, 17, false)) {
			classification += "Delgadez Moderada";
		} else if (isInRange(bmi, 17, true, 18.5, false)) {
			classification += "Delgadez Leve";
		} else if (isInRange(bmi, 18.5, true, 25, false)) {
			classification += "Normal";
		} else if (isInRange(bmi, 25, true, 30, false)) {
			classification += "Sobrepeso";
		} else if (isInRange(bmi, 30, true, 35, false)) {
			classification += "Obesidad Grado I - Moderada";
		} else if (isInRange(bmi, 35, true, 40, false)) {
			classification += "Obesidad Grado II - Severa";
		} else {
			classification += "Obesidad Grado III - Mórbida";
		}
		
		return classification;
	}
	
	/**
	 * Calculates the ideal weight for an adult by using his height and carpus. 
	 * 
	 * The first thing it does is to calculate completeness, using the carpus and height. 
	 * Then, depending on gender, it gives a value for BMI. Finally, it calculates the 
	 * ideal weight using the generated BMI, and the height in meters.
	 * 
	 * @param height the height of the person in centimeters. 
	 * @param carpus the carpus measurement in centimeters.
	 * @param gender true for woman, false for man.
	 * @return the ideal weight calculated.
	 */
	public static double adultIdealWeight(double height, double carpus, boolean gender) {
		double complexion = height/carpus;
		double bmi = 0;
		
		if(gender) {
			if(complexion > 11) {
				bmi = 20;
			} else if (isInRange(complexion, 9.9, true, 10.9, true)) {
				bmi = 22.5;
			} else {
				bmi = 24.9;
			}
		} else {
			if(complexion > 10.5) {
				bmi = 20;
			} else if (isInRange(complexion, 9.6, true, 10.4, true)) {
				bmi = 22.5;
			} else {
				bmi = 24.9;
			}
		}
		
		BigDecimal idealWeight = new BigDecimal(bmi * (Math.pow((height/100), 2)));
		
		idealWeight = idealWeight.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		return idealWeight.doubleValue();
	}
	
	/**
	 * Calculates the ideal weight of an adult using the Lorentz formula. It just needs
	 * the height, in centimeters, and the gender.
	 * 
	 * @param height the height of the person.
	 * @param gender true for woman, false otherwise.
	 * @return the calculated ideal weight.
	 */
	public static double adultIdealWeightLorentz(double height, boolean gender) {
		double idealWeight = 0;
		
		if(gender) {
			idealWeight = (height - 100) - ((height - 150) / 2.5);
		} else {
			idealWeight = (height - 100) - ((height - 150) / 4);
		}
		
		return idealWeight;
	}
	
	/**
	 * Calculates the ideal weight of an adult using the Regression formula. It just needs
	 * the height, in meters, the carpus, in centimeters, and the gender.
	 * 
	 * @param height the height of the person.
	 * @param carpus the carpus of the person.
	 * @param gender true for woman, false otherwise.
	 * @return the calculated ideal weight.
	 */
	public static double adultIdealWeightRegression(double height, double carpus, boolean gender) {
		double idealWeight = 0;
		
		if(gender) {
			idealWeight = 65 * height + 3.1 * carpus - 95.6;
		} else {
			idealWeight = 75 * height + 3.2 * carpus - 114.5;
		}
		
		return idealWeight;
	}
	
	/**
	 * Determines cardiovascular risk level of a person based on waist and hip circumference and gender.
	 * 
	 * @param waistCircumference the waist circumference of the person.
	 * @param hipCircumference the hip circumference of the person.
	 * @param gender true for woman, false otherwise.
	 * @return the result of dividing waist by hip, and the risk's level. 
	 */
	public static String adultCardiovascularRisk(double waistCircumference, double hipCircumference, boolean gender) {
		BigDecimal cardiovascularRisk = new BigDecimal(waistCircumference/hipCircumference);
		cardiovascularRisk = cardiovascularRisk.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		String risk = "Riesgo cardiovascular: " + cardiovascularRisk + " - ";
		
		double auxRisk = cardiovascularRisk.doubleValue();
		
		if(gender) {
			if(auxRisk >= 0.85) {
				risk += "Muy Elevado";
			} else if (isInRange(auxRisk, 0.8, true, 0.85, false)) {
				risk += "Elevado";
			} else {
				risk += "Muy Bajo";
			}
		} else {
			if(auxRisk >= 1) {
				risk += "Muy Elevado";
			} else if (isInRange(auxRisk, 0.9, true, 1, false)) {
				risk += "Elevado";
			} else {
				risk += "Muy Bajo";
			}
		}
		
		return risk;
	}
	
	/**
	 * Using the Faulkner formula, that needs 4 folds, calculates the body fat percentage
	 * and returns a classification based on that percentage.
	 * 
	 * @param tricipitalFold fold 1.
	 * @param abdominalFold fold 2.
	 * @param subscapularFold fold 3.
	 * @param supraspinalFold fold 4.
	 * @param gender true for woman, false otherwise.
	 * @return the classification based on the body fat percentage.
	 */
	public static String adultBodyFatFaulkner(double tricipitalFold, double abdominalFold, double subscapularFold, double supraspinalFold, boolean gender) {
		double[] folds = {tricipitalFold, abdominalFold, subscapularFold, supraspinalFold};
		
		double percentage = ((DoubleStream.of(folds).sum()) * 0.153 + 5.783) * 100;
		
		return clasifyBodyFat(percentage, gender);
	}
	
	/**
	 * Using the Yuhasz formula, that needs 6 folds, calculates the body fat percentage
	 * and returns a classification based on that percentage.
	 * 
	 * @param tricipitalFold fold 1.
	 * @param abdominalFold fold 2.
	 * @param subscapularFold fold 3.
	 * @param supraspinalFold fold 4.
	 * @param thighFold fold 5.
	 * @param calfFold fold 6.
	 * @param gender true for woman, false otherwise.
	 * @return the classification based on the body fat percentage.
	 */
	public static String adultBodyFatYuhasz(double tricipitalFold, double abdominalFold, double subscapularFold, double supraspinalFold, double thighFold, double calfFold, boolean gender) {
		double[] folds = {tricipitalFold, abdominalFold, subscapularFold, supraspinalFold, thighFold, calfFold};
		
		double percentage = 0;
		
		if(gender) {
			percentage = ((DoubleStream.of(folds).sum()) * 0.1429 + 4.56) * 100;
		} else {
			percentage = ((DoubleStream.of(folds).sum()) * 0.097 + 3.64	) * 100;
		}
		
		return clasifyBodyFat(percentage, gender);
	}
	
	/**
	 * Returns a body fat classification based on the percentage of fat input, and the gender of the individual.
	 * 
	 * @param fatPercentage the body fat percentage input.
	 * @param gender true for woman, false otherwise. 
	 * @return the classification.
	 */
	private static String clasifyBodyFat(double fatPercentage, boolean gender) {
		String classification = "Porcentaje de Grasa  corporal: " + fatPercentage + " - ";
		
		if(gender) {
			if(fatPercentage < 15) {
				classification += "Delgado";
			} else if (isInRange(fatPercentage, 15.1, true, 20.9, true)) {
				classification += "Óptimo";
			} else if (isInRange(fatPercentage, 21, true, 25.9, true)) {
				classification += "Ligero Sobrepeso";
			} else if (isInRange(fatPercentage, 26, true, 31.9, true)) {
				classification += "Sobrepeso";
			} else {
				classification += "Obesidad";
			}
		} else {
			if(fatPercentage < 8) {
				classification += "Delgado";
			} else if (isInRange(fatPercentage, 8.1, true, 15.9, true)) {
				classification += "Óptimo";
			} else if (isInRange(fatPercentage, 16, true, 20.9, true)) {
				classification += "Ligero Sobrepeso";
			} else if (isInRange(fatPercentage, 21, true, 24.9, true)) {
				classification += "Sobrepeso";
			} else {
				classification += "Obesidad";
			}
		}
		
		return classification;
	}
	
	//--- PREGNANT ---
	
	/**
	 * Calculates the BMI of a pregnant woman and returns a classification based on the BMI value and the week
	 * of pregnancy.
	 * 
	 * @param weight the weight of the woman (in kilograms).
	 * @param height the height of the woman (in meters).
	 * @param gestationWeek the week of pregnancy the woman is at.
	 * @return the classification based on the BMI.
	 */
	public static String pregnantBMI(double weight, double height, int gestationWeek) {
		double bmi = calculateBMI(weight, height);
		
		String classification = "IMC: " + bmi + " - ";
		
		if(isInRange(gestationWeek, 10, true, 15, true)) {
			if(isInRange(bmi, 15, true, 21, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 21, true, 25, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 25, true, 30, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 30, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		} else if (isInRange(gestationWeek, 16, true, 20, true)) {
			if(isInRange(bmi, 15, true, 21, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 21, true, 26, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 26, true, 31, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 31, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		} else if (isInRange(gestationWeek, 21, true, 25, true)) {
			if(isInRange(bmi, 15, true, 22, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 22, true, 26, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 26, true, 31, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 31, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		} else if (isInRange(gestationWeek, 26, true, 30, true)) {
			if(isInRange(bmi, 15, true, 23, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 23, true, 27, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 27, true, 32, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 32, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		} else if (isInRange(gestationWeek, 31, true, 35, true) && isInRange(bmi, 15, true, 24, true)) {
			if(isInRange(bmi, 15, true, 24, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 24, true, 28, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 28, true, 32, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 32, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		} else if (isInRange(gestationWeek, 36, true, 42, true) && isInRange(bmi, 15, true, 25, true)) {
			if(isInRange(bmi, 15, true, 25, true)) {
				classification += "Bajo Peso para la Edad Gestacional";
			} else if (isInRange(bmi, 25, true, 29, true)) {
				classification += "IMC Adecuado para la Edad Gestacional";
			} else if (isInRange(bmi, 29, true, 33, true)) {
				classification += "Sobrepeso para la Edad Gestacional";
			} else if (isInRange(bmi, 33, true, 40, true)) {
				classification += "Obesidad para la Edad Gestacional";
			}
		}
		
		return classification;
	}
	
	/**
	 * Given the pre-gestational weight, height, and gestational week of a woman, calculates the appropriate 
	 * weight gain range for her, and returns it.
	 * 
	 * @param pregestationalWeight the pre-gestational weight of the woman.
	 * @param height the height of the woman.
	 * @param gestationalWeek the quantity of weeks the woman has been pregnant.
	 * @return the appropriate weight gain range of the woman (Upper bound kg - Lower bound kg).
	 */
	public static String pregnantWeightGain(double pregestationalWeight, double height, int gestationalWeek) {
		double pregestationalBMI = calculateBMI(pregestationalWeight, height);
		
		double weightGainLB = 0;
		double weightGainUB = 0;
		
		gestationalWeek -= 12;
		
		if(pregestationalBMI < 20) {
			weightGainLB = 2.3;
			
			if (gestationalWeek > 0) {
				weightGainUB = weightGainLB + gestationalWeek * 0.6;
				weightGainLB += gestationalWeek * 0.4;
			}
		} else if (isInRange(pregestationalBMI, 20, true, 24.9, true)) {
			weightGainLB = 1.6;
			
			if(gestationalWeek > 0) {
				weightGainUB = weightGainLB + gestationalWeek * 0.43;
				weightGainLB += gestationalWeek * 0.33;
								
			}			
		} else if (isInRange(pregestationalBMI, 25, true, 29.9, true)) {
			weightGainLB = 0.9;
			
			if(gestationalWeek > 0) {
				weightGainUB = weightGainLB + gestationalWeek * 0.33;
				weightGainLB += gestationalWeek * 0.23;
			}
		} else {
			if(gestationalWeek > 0) {
				weightGainUB = gestationalWeek * 0.23;
				weightGainLB = gestationalWeek * 0.2;
			}
		}
		
		return weightGainLB + " - " + weightGainUB;
	}
	
	//--- AUXILIAR ---
	
	/**
	 * Given a number and two bounds, determines if the number is between the bounds.
	 * 
	 * @param num the number to search in the range.
	 * @param lowerBound the lower boundary.
	 * @param lBoundIncluded true if the lower boundary is included in the range. False otherwise.
	 * @param upperBound the upper boundary.
	 * @param uBoundIncluded true if the upper boundary is included in the range. False otherwise.
	 * @return true if @param num is in the range. False otherwise.
	 */
	private static boolean isInRange(double num, double lowerBound, boolean lBoundIncluded, double upperBound, boolean uBoundIncluded) {
		if(num >= lowerBound && num <= upperBound) {
			if(num == upperBound && !uBoundIncluded || num == lowerBound && !lBoundIncluded) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Given the weight (in kilograms) and the height (in meters) of a person, calculates the BMI and returns it.
	 * 
	 * @param weight the weight to calculate the BMI.
	 * @param height the height to calculate the BMI.
	 * @return the calculated BMI.
	 */
	private static double calculateBMI(double weight, double height) {
		BigDecimal bmi = new BigDecimal(weight/(Math.pow(height, 2)));
		
		bmi = bmi.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		return bmi.doubleValue();
	}
}
