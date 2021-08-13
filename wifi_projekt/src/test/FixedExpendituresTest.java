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
//import model.FixedExpenditures;
//import model.Profile;
//
//class FixedExpendituresTest {
//
//	public FixedExpenditures fixedExpenditures;
//
//	@BeforeAll
//	static void printBeforeAll() {
//		System.out.println("Test will start now");
//	}
//
//	@BeforeEach
//	void initFixedExpenditure() {
//		fixedExpenditures = new FixedExpenditures();
//	}
//
//	@Test
//	void testFixedExpendituresWithCategory() {
//		String input = "this category";
//
//		String expected = input;
//
//		fixedExpenditures.setCategory(input);
//		String actual = fixedExpenditures.getCategory();
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testFixedExpendituresWithAmount() {
//		double input = 100;
//
//		double expected = input;
//
//		fixedExpenditures.setAmount(input);
//		double actual = fixedExpenditures.getAmount();
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testFixedExpendituresWithDateFixedExpenditures() {
//		LocalDate input = LocalDate.of(2021, 2, 26);
//
//		LocalDate expected = input;
//
//		fixedExpenditures.setDateFixedExpenditure(input);
//		;
//		LocalDate actual = fixedExpenditures.getDateFixedExpenditures();
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testFixedExpenditureWithProfile() {
//		Profile input = new Profile("Thomas", "ThomasPW");
//		Profile expected = input;
//
//		fixedExpenditures.setProfile(input);
//		Profile actual = fixedExpenditures.getProfile();
//
//		assertEquals(expected, actual);
//	}
//	@AfterEach
//	void resetFixedExpenditures() {
//		fixedExpenditures = null;
//	}
//
//	@AfterAll
//	static void printAfterAll() {
//		System.out.println("All tests concluded");
//	}
//	}