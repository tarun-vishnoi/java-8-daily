package com.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Lower Bounded - If you want a generic expression to accept all types which
 * are “super” type of a particular type OR parent class of a particular class
 * then you will use a lower bound wildcard for this purpose, using ‘super’
 * keyword.
 * 
 * Unbounded Wildcard: This wildcard type is specified using the wildcard
 * character (?), for example, List. This is called a list of unknown type.
 * These are useful in the following cases : 1.) When writing a method which can
 * be employed using functionality provided in Object class. 2.) When the code
 * is using methods in the generic class that don’t depend on the type parameter
 * 
 * @author Tarun Vishnoi
 *
 */
public class LowerBounded {

	public static void main(String[] args) {
		List<Child> childs = new ArrayList<Child>();
		childs.add(new Child());
		addChild(childs);

		List<Parent> parents = new ArrayList<Parent>();
		parents.add(new Parent());
		addChild(parents);

		List<GreatParent> greatparents = new ArrayList<GreatParent>();
		greatparents.add(new GreatParent());
		addChild(greatparents);

		/*
		 * The method addChild(List<? super Child>) in the type LowerBounded is not
		 * applicable for the arguments (List<Toddler>)
		 */
		List<Toddler> toddlers = new ArrayList<Toddler>();
		toddlers.add(new Toddler());
		// addChild(toddlers); // compilation error
	}

	public static void addChild(List<? super Child> child) {
		child.add(new Child());
		System.out.println(child);
	}
}

class GreatParent {

}

class Parent extends GreatParent {

}

class Child extends Parent {

}

class Toddler extends Child {

}