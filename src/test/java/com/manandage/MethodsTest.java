package com.manandage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MethodsTest {
	private static final int LONG_SIZE = 1000;

	private List<Person> persons;
	private Methods methods;
	private double delta = 0.0000001;
	
	@Before
	public void preInit() {
		
		methods = new Methods();
		
		persons = Arrays.asList(
				new Person("Seema", 28),
				new Person("Rajiv", 25),
				new Person("Prateek", 24),
				new Person("Annu", 22),
				new Person("Avijit", 28),
				new Person("Rahul", 23)
				);
	}
	
	@Test
	public void testGetAevrageAge() {
		// Empty case
		assertEquals(0, methods.getAevrageAge(new ArrayList<Person>()), delta);
		
		// Ideal case
		double avrage = (28 + 25 + 24 + 22 + 28 + 23) / persons.size();
		assertEquals(avrage, methods.getAevrageAge(persons), delta);
		
		// Case with 1000 items
		assertEquals(500500d/1000d, methods.getAevrageAge(getLargeListOfPersons(LONG_SIZE)), delta);
	}
	
	@Test
	public void testGetAverageLengthOfNames() {
		// Empty case
		assertEquals(0, methods.getAvrageLengthOfNames(new ArrayList<Person>()), delta);
		
		// Ideal case
		assertEquals(32d/persons.size(), methods.getAvrageLengthOfNames(persons), delta);
		
		// Case with 1000 items
		assertEquals(9.893, methods.getAvrageLengthOfNames(getLargeListOfPersons(LONG_SIZE)), delta);
	}
	
	@Test
	public void testGetLongestName() {
		// Empty case
		assertNull(methods.getLongestName(new ArrayList<Person>()));
		
		// Ideal case
		assertEquals("Prateek", methods.getLongestName(persons));
		
		// Case with 1000 items
		assertEquals("Person 1000", methods.getLongestName(getLargeListOfPersons(LONG_SIZE)));
	}
	
	@Test
	public void testGetOldestPerson() {
		// Empty case
		assertNull(methods.getOldestPerson(new ArrayList<Person>()));
		
		// Ideal case
		assertEquals(Integer.valueOf(28),  methods.getOldestPerson(persons).getAge());
		
		// Case with 1000 items
		assertEquals(Integer.valueOf(LONG_SIZE),  methods.getOldestPerson(getLargeListOfPersons(LONG_SIZE)).getAge());
	}
	
	@Test
	public void testGetYoungestPerson() {
		// Empty case
		assertNull(methods.getYoungestPerson(new ArrayList<Person>()));
		
		// Ideal case
		assertEquals(Integer.valueOf(22),  methods.getYoungestPerson(persons).getAge());
		
		// Case with 1000 items
		assertEquals(Integer.valueOf(1),  methods.getYoungestPerson(getLargeListOfPersons(LONG_SIZE)).getAge());
	}
	
	@Test
	public void testGetCountOfPersonsBetweenAgeRange() {
		// Empty case
		int minAge = 18; int maxAge = 60;
		
		assertEquals(0, methods.getCountOfPersonsBetweenAgeRange(new ArrayList<Person>(), minAge, maxAge));
		
		// Ideal case
		assertEquals(6l, methods.getCountOfPersonsBetweenAgeRange(persons, minAge, maxAge));
		
		// Case with 1000 items
		assertEquals(((maxAge - minAge) + 1l), methods.getCountOfPersonsBetweenAgeRange(getLargeListOfPersons(LONG_SIZE), minAge, maxAge));
	}
	
	/**
	 * Returns the list of 1000 persons
	 * The size of the list is customizable
	 * 
	 * @param size
	 * @return
	 */
	private List<Person> getLargeListOfPersons(int size) {
		final List<Person> persons = new ArrayList<Person>();
		
		for(int i = 1 ; i <= size ; i ++) {
			persons.add(new Person(new StringBuilder("Person ").append(i).toString(), i));
		}
		return persons;
	}
}
