//package test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//import model.Inflation;
//
//class InflationTest {
//
//	public Inflation inflation;
//
//	@BeforeAll
//	static void printBeforeAll() {
//		System.out.println("Test will start now");
//	}
//
//	@BeforeEach
//	void initInflation() {
//		inflation = new Inflation();
//	}
//	
//	@Test
//	void testInflationWithInflationFigure() {
//		 double input = 1.4;
//		 
//		 double expected = input;
//		 
//		 inflation.setInflationFigure(input);
//		 double actual = inflation.getInflationFigure();
//		 
//		 assertEquals(expected, actual);
//	}
//	
//	@Test
//	void testInflationWithInflationYear() {
//		 Integer input = 2015;
//		 
//		 Integer expected = input;
//		 
//		 inflation.setInflationYear(input);
//		 Integer actual = inflation.getInflationYear();
//		 
//		 assertEquals(expected, actual);
//	}
//	@AfterEach
//	void resetInflation() {
//		inflation = null;
//	}
//
//	@AfterAll
//	static void printAfterAll() {
//		System.out.println("All tests concluded");
//	}
//}
//
