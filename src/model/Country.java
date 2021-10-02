package model;


public class Country implements Comparable<Country>{

	private String countryName; 
	private int goldMedals, silverMedals, bronzeMedals;
	
	public Country(String countryName, int goldMedals, int silverMedales, int bronzeMedals) {
		this.countryName = countryName;
		this.goldMedals = goldMedals;
		this.silverMedals = silverMedales;
		this.bronzeMedals = bronzeMedals;
		
	}
	public String getCountryName() {
		return countryName;
	}
	public int getGoldMedals() {
		return goldMedals;
	}
	public int getSilverMedals() {
		return silverMedals;
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
	public void setSilverMedals(int silverMedals) {
		this.silverMedals = silverMedals;
	}
	public void setBronzeMedals(int bronzeMedals) {
		this.bronzeMedals = bronzeMedals;
	}

	public String toString()
	{
		String info = countryName +" "+goldMedals+" "+silverMedals+" "+bronzeMedals;  
		return info;
		
	}
	@Override
	public int compareTo(Country c) 
	{
		int result;
		if(goldMedals > c.getGoldMedals())
		{
			result = 1;
		}
		else if( goldMedals < c.getGoldMedals())
		{
			result = -1;
		}
		else
		{
			if(silverMedals > c.getSilverMedals())
			{
				result = 1;
			}
			else if(silverMedals< c.getSilverMedals())
			{
				result = -1;
			}
			else
			{
				if( bronzeMedals > c.getBronzeMedals())
				{
					result = 1;
				}
				else if(  bronzeMedals < c.getBronzeMedals())
				{
					result = -1;
				}
				else
				{
					result = c.getCountryName().compareTo(countryName);
				}
			}
			
		}
			
		return result;
	}
	
}
