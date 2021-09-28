package model;

public class MedalTable {

	private Country[] maleCategory;
	private Country[] femaleCategory;
	private int amountOfCountries;
	
	
	public MedalTable(Country[] maleCategory, Country[] femaleCategory, int amountOfCountries) {
		
		this.maleCategory = new Country[amountOfCountries];
		this.femaleCategory = new Country[amountOfCountries];
		
	}
	public Country[] getMaleCategory() {
		return maleCategory;
	}
	public Country[] getFemaleCategory() {
		return femaleCategory;
	}
	public int getAmountOfCountries() {
		return amountOfCountries;
	}
	public void setMaleCategory(Country[] maleCategory) {
		this.maleCategory = maleCategory;
	}
	public void setFemaleCategory(Country[] femaleCategory) {
		this.femaleCategory = femaleCategory;
	}
	public void setAmountOfCountries(int amountOfCountries) {
		this.amountOfCountries = amountOfCountries;
	}
	
	
	
}
