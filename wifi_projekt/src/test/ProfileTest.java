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
//import model.Profile;
//
//class ProfileTest {
//
//public Profile profile;
//
//@BeforeAll
//
//static void printBeforeAll() {
//	System.out.println("Test will start now");
//}
//
//@BeforeEach
//void initProfile() {
//	profile = new Profile();
//}
//
//
//@Test
//void testProfileWithAccountName() {
//	String input = "David";
//	
//	String expected = input;
//	
//	profile.setAccountName(input);
//	String actual = profile.getAccountName();
//	
//	assertEquals(expected, actual);
//}
//
//@Test
//void testProfileWithPassword() {
//	String input = "DavidPW";
//	
//	String expected = input;
//	
//	profile.setPassword(input);;
//	String actual = profile.getPassword();
//	
//	assertEquals(expected, actual);
//}
//@AfterEach
//void resetProfile() {
//	profile = null;
//}
//
//@AfterAll
//static void printAfterAll() {
//	System.out.println("All tests concluded");
//}
//}
