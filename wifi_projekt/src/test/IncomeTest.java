//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import model.Income;
//import model.Profile;
//
//class IncomeTest {
//	public Income income;
//
//	@BeforeAll
//	static void printBeforeAll() {
//		System.out.println("Test will start now");
//	}
//
//	@BeforeEach
//	void initIncome() {
//		income = new Income();
//	}
//
//	@Test
//	void testIncomeWithAmountInc() {
//		double input = 1000;
//
//		double expected = input;
//
//		income.setAmountInc(input);
//		double actual = income.getAmountInc();
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testIncomeWithDateFixedExpenditures() {
//		LocalDate input = LocalDate.of(2021, 2, 27);
//
//		LocalDate expected = input;
//
//		income.setDateInc(input);
//		;
//		LocalDate actual = income.getDateInc();
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testIncomeWithProfile() {
//		Profile input = new Profile("Markus", "MarkusPW");
//		Profile expected = input;
//
//		income.setProfile(input);
//		Profile actual = income.getProfile();
//
//		assertEquals(expected, actual);
//	}
//
//	@AfterEach
//	void resetIncome() {
//		income = null;
//	}
//
//	@AfterAll
//	static void printAfterAll() {
//		System.out.println("All tests concluded");
//	}
//}
