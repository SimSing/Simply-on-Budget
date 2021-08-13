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
//import model.FluctExpenditures;
//import model.Profile;
//
//class FluctExpendituresTest {
//
//	public FluctExpenditures fluctExpenditures;
//	
//	@BeforeAll
//	
//	static void printBeforeAll() {
//		System.out.println("Test will start now");
//	}
//	
//	@BeforeEach
//	void initFluctExpenditure() {
//		fluctExpenditures = new FluctExpenditures();
//	}
//	
//	@Test
//	void testFluctExpendituresWithPrice() {
//		 double input = 10;
//		 
//		 double expected = input;
//		 
//		 fluctExpenditures.setPrice(input);
//		 double actual = fluctExpenditures.getPrice();
//		 
//		 assertEquals(expected, actual);
//	}
//	
//	@Test
//	void testFluctExpendituresWithDate() {
//		LocalDate input = LocalDate.of(2021, 2, 25);
//		
//		LocalDate expected = input;
//		
//		fluctExpenditures.setDate(input);
//		LocalDate actual = fluctExpenditures.getDate();
//		
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void testFluctExpendituresWithComment() {
//		String input = "this comment";
//		
//		String expected = input;
//		
//		fluctExpenditures.setComment(input);
//		String actual = fluctExpenditures.getComment();
//		
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	void testFluctExpendituresWithPath() {
//		String input = "C:\\Users\\Simon\\Desktop\\Billa-Rechnung";
//		
//		String expected = input;
//		
//		fluctExpenditures.setPath(input);
//		String actual = fluctExpenditures.getPath();
//		
//		assertEquals(expected, actual);
//	}
//	@Test
//	void testFluctExpenditureWithProfile() {
//		Profile input = new Profile("Paul", "paulPW");
//		Profile expected = input;
//		
//		fluctExpenditures.setProfile(input);
//		Profile actual = fluctExpenditures.getProfile();
//		
//		assertEquals(expected, actual);
//	}
//@AfterEach
//void resetFluctExpenditures() {
//	fluctExpenditures = null;
//}
//
//@AfterAll
//static void printAfterAll() {
//	System.out.println("All tests concluded");
//}
//}
