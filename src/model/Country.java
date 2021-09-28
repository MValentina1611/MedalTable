package model;

public class Country {

	private String countryName; 
	private Medal countryMedal;
	private int medalsAmount;
	
	public Country(String countryName, Medal countryMedal, int medalsAmount) {
		this.countryName = countryName;
		this.countryMedal = countryMedal;
		this.medalsAmount = medalsAmount;
	}

	public String getCountryName() {
		return countryName;
	}

	public Medal getCountryMedal() {
		return countryMedal;
	}

	public int getMedalsAmount() {
		return medalsAmount;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setCountryMedal(Medal countryMedal) {
		this.countryMedal = countryMedal;
	}

	public void setMedalsAmount(int medalsAmount) {
		this.medalsAmount = medalsAmount;
	}
	
	
	
}
