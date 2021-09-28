package model;

import java.util.Comparator;

public class CountryMedalMaterialAndNameComparator implements Comparator<Country>{

	@Override
	public int compare(Country o2, Country o1) 
	{
		int result;
		if(o1.getGoldMedals()>o2.getGoldMedals())
		{
			result = 1;
		}
		else if( o1.getGoldMedals()<o2.getGoldMedals())
		{
			result = -1;
		}
		else
		{
			if(o1.getSilverMedals() > o2.getSilverMedals())
			{
				result = 1;
			}
			else if(o1.getGoldMedals()< o2.getGoldMedals())
			{
				result = -1;
			}
			else
			{
				if(o1.getBronzeMedals()> o2.getBronzeMedals())
				{
					result = 1;
				}
				else if( o1.getBronzeMedals() < o2.getBronzeMedals())
				{
					result = -1;
				}
				else
				{
					result = o1.getCountryName().compareTo(o2.getCountryName());
				}
			}
			
		}
			
		return result;
	}

	
	
}
