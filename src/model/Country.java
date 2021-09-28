package model;


public class Country {

	private String countryName; 
	private int goldMedals, silverMedales, bronzeMedals;
	
	public Country(String countryName, int goldMedals, int silverMedales, int bronzeMedals) {
		this.countryName = countryName;
		this.goldMedals = goldMedals;
		this.silverMedales = silverMedales;
		this.bronzeMedals = bronzeMedals;
		
	}
	public String getCountryName() {
		return countryName;
	}
	public int getGoldMedals() {
		return goldMedals;
	}
	public int getSilverMedales() {
		return silverMedales;
	}
	public int getBronzeMedals() {
		return bronzeMedals;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public void setGoldMedals(int goldMedals) {
		this.goldMedals = goldMedals;
	}
	public void setSilverMedales(int silverMedales) {
		this.silverMedales = silverMedales;
	}
	public void setBronzeMedals(int bronzeMedals) {
		this.bronzeMedals = bronzeMedals;
	}

	
	
}
