package model;

public class MedalTable {

	private Country[] countries;
	private int amountOfCountries;
	
	MedalTable( int amountOfCountries, String countriesName ) 
	{
		this.amountOfCountries = amountOfCountries;
		countries = new Country[amountOfCountries];
	}
	
	
}
