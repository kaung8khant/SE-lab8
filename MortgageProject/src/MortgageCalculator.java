import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MortgageCalculator {
	List<String> Level1Profession = new ArrayList<>(Arrays.asList(new String[]{"Developer","Architect","Scrum master"}));
	List<String> Level2Profession = new ArrayList<>(Arrays.asList(new String[]{"Tester","System Adminstrator","Technical writer"}));
	List<String> Level3Profession = new ArrayList<>(Arrays.asList(new String[]{"Department head","Professor"}));
	
	public double computeMaxMortgage(int yearOfBirt, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		
		double result=0;
		
		int age = calculateAge(yearOfBirt, month, day);
		
		if (age < 18) {
			result = 0;
		}

		
		double totalIncome = married ? monthlyIncome + monthlyIncomePartner * 0.94 : monthlyIncome; 
		
		
		if (2000<=totalIncome && totalIncome<3000) {
			if (Level1Profession.contains(profession)) result = 160000;
			if (Level2Profession.contains(profession)) result = 120000;
			if (Level3Profession.contains(profession)) result = 220000;
		}
		if (3000<=totalIncome && totalIncome<5000) {
			if (Level1Profession.contains(profession)) result = 180000;
			if (Level2Profession.contains(profession)) result = 140000;
			if (Level3Profession.contains(profession)) result = 250000;
		}
		if (5000<=totalIncome) {
			if (Level1Profession.contains(profession)) result = 220000;
			if (Level2Profession.contains(profession)) result = 160000;
			if (Level3Profession.contains(profession)) result = 280000;
		}
		

		
		return result;
	}
	public int calculateAge(int yearOfBirt, int month, int day) {
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday = LocalDate.of(yearOfBirt, month, day);  //Birth date
		
		
		 
		Period p = Period.between(birthday, today);
		return p.getYears();
	}
	

}
