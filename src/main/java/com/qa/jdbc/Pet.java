package com.qa.jdbc;

public class Pet {
	private int petId;
	private String name;
	private int age;
	private String colour;
	private String breed;

	public Pet(int petId, String name, int age, String colour, String breed) {
		this.petId=petId;
		this.name = name;
		this.age = age;
		this.colour = colour;
		this.breed = breed;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + this.petId + ", name=" + this.name + ", age=" + this.age + ", colour="+this.colour+", breed="+this.breed+"]";
	}
}
