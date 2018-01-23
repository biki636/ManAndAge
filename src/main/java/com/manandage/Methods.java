/**
 * 
 */
package com.manandage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * This class has all the methods
 * 
 * @author soumitri
 *
 */
public class Methods {

	// The list of persons
	final List<Person> persons = Arrays.asList(
							new Person("Seema", 28),
							new Person("Rajiv", 25),
							new Person("Prateek", 24),
							new Person("Annu", 22),
							new Person("Avijit", 28),
							new Person("Rahul", 23)
							);	
	
	/**
	 * Find the average of the ages
	 * 
	 * @param persons
	 * @return
	 */
	public double getAevrageAge(List<Person> persons) {
		final OptionalDouble optionalAvrage = persons.stream()
												.mapToDouble(person -> person.getAge())
												.average();
		if(optionalAvrage.isPresent()) {
			return optionalAvrage.getAsDouble();
		}
		
		return 0;
	}
	
	
	/**
	 * Find the average length of the names
	 * 
	 * @param persons
	 * @return
	 */
	public double getAvrageLengthOfNames(List<Person> persons) {
		final OptionalDouble optionalAvrage = persons.stream()
												.mapToDouble(person -> person.getName().length())
												.average();
		
		if(optionalAvrage.isPresent()) {
			return optionalAvrage.getAsDouble();
		}
		return 0;
	}
	
	/**
	 * Get the longest name in the list
	 * 
	 * @param persons
	 * @return
	 */
	public String getLongestName(List<Person> persons) {
		final Optional<Person> optionalPerson = persons.stream()	
												.max((p1, p2) -> Integer.valueOf(p1.getName().length()).compareTo(Integer.valueOf(p2.getName().length())));
		if(optionalPerson.isPresent()) {
			return optionalPerson.get().getName();
		}
		return null;
	}
	
	/**
	 * Get the oldest person from the list
	 * 
	 * @param persons
	 * @return
	 */
	public Person getOldestPerson(List<Person> persons) {
		final Optional<Person> optionalPerson = persons.stream()
													.max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
		
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		
		return null;
	}
	
	/**
	 * Get the youngest person from the list
	 * 
	 * @param persons
	 * @return
	 */
	public Person getYoungestPerson(List<Person> persons) {
		final Optional<Person> optionalPerson = persons.stream()
													.min((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
		
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		
		return null;
	}
	
	/**
	 * Get the count of person in the list between (inclusive) the given range of ages
	 * 
	 * @param persons
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public long getCountOfPersonsBetweenAgeRange(List<Person> persons, int minAge, int maxAge) {
		return persons.stream()
				.filter(person -> person.getAge().intValue() >= minAge && person.getAge().intValue() <= maxAge)
				.count();
	}
}
