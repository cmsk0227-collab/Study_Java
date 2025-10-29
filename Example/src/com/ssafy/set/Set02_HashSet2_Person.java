package com.ssafy.set;

import java.util.HashSet;

class Person{
	String name;
		int age;
		public Person() {
			
		}
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		@Override
		public String toString() {
		    return "Person [name=" + name + ", age=" + age + "]";
		}

		
	}
	

public class Set02_HashSet2_Person {
	public static void main(String[] args) {
		HashSet<Person> names = new HashSet<>();
		names.add(new Person("강진서", 29));
		names.add(new Person("양띵균", 40));
		names.add(new Person("양명균", 45));
		names.add(new Person("양명균", 45));
		
		for(Person p : names) {
			System.out.println(p);
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

