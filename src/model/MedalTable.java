package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MedalTable{

	private List<Country> maleCategory;
	private List<Country> femaleCategory;
	private List<Country> bothCategories;
 	private int amountOfCountries;
	//private int totalGold, totalSilver, totalBronze;
	
	private final String TEST_FILE = "data/testFile.txt";
	
	public MedalTable() {
		
		this.maleCategory = new ArrayList<Country>();
		this.femaleCategory = new ArrayList<Country>();
		this.bothCategories = new ArrayList<Country>();
		
	}
	
	public void addCountry( int category, String name, int numGold, int numSilver, int numBronze )
	{
		switch (category )
		{
			case 1:
				maleCategory.add(new Country(name, numGold, numSilver, numBronze));			
			break;
			
			case 2:
				femaleCategory.add(new Country(name, numGold, numSilver, numBronze));	
			break;
		}		
	}
	
	public List<Country> getMaleCategory() {
		return maleCategory;
	}

	public List<Country> getFemaleCategory() {
		return femaleCategory;
	}

	public List<Country> getBothCategories() {
		return bothCategories;
	}
	public int getAmountOfCountries() {
		return amountOfCountries;
	}

	public void setMaleCategory(List<Country> maleCategory) {
		this.maleCategory = maleCategory;
	}

	public void setFemaleCategory(List<Country> femaleCategory) {
		this.femaleCategory = femaleCategory;
	}

	public void setAmountOfCountries(int amountOfCountries) {
		this.amountOfCountries = amountOfCountries;
	}


	//ImportTestFile
	public void importData() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(TEST_FILE) );
		String line = br.readLine();
		
		while( line != null )
		{
				String [] info = line.split("\\;");
				String name = info[0];

			try 
			{
				int numGoldM = Integer.parseInt(info[1]);
				int numSilverM = Integer.parseInt(info[2]);
				int numBronzeM = Integer.parseInt(info[3]);
				int numGoldF = Integer.parseInt(info[4]);
				int numSilverF = Integer.parseInt(info[5]);
				int numBronzeF = Integer.parseInt(info[6]);
				
				addCountry(1,name,numGoldM,numSilverM,numBronzeM);
				addCountry(2,name,numGoldF,numSilverF,numBronzeF);
				int totalGolds = Integer.parseInt(info[1]) + Integer.parseInt(info[4]);
				int totalSilver = Integer.parseInt(info[2]) + Integer.parseInt(info[5]);
				int totalBronze = Integer.parseInt(info[3]) + Integer.parseInt(info[6]);					
				Country country = new Country(info[0], totalGolds, totalSilver,totalBronze);
				bothCategories.add(country);
				
			}
			catch(NumberFormatException ex){}
								
			line = br.readLine();
		}	
		br.close();
	}
	

	//FirstReport
	
	public void sortByMedalMaterialAndName()
	{
		Comparator<Country> c1 = new CountryMedalMaterialAndNameComparator();
		Collections.sort(maleCategory, c1);
	}
	
	//SecondReport
	
	public void sortFemaleByMedalMaterialAndName()
	{
		Collections.sort(femaleCategory);
	}
	
	//ThirdReport
		
	//sortBySelection
	
	public void sortBothCategories()
	{
		int pos = 0;
		while(pos < bothCategories.size())
		{
			Country max = bothCategories.get(pos);
		
			for(int i = pos+1; i < bothCategories.size(); i++)
			{
				if( bothCategories.get(i).getGoldMedals() > max.getGoldMedals() )
				{
					Country temp = bothCategories.get(i);
					bothCategories.set(i,max);
					max = temp;
				}
				else if( bothCategories.get(i).getGoldMedals() == max.getGoldMedals())
				{
					if( bothCategories.get(i).getSilverMedals() > max.getSilverMedals() )
					{
						Country temp = bothCategories.get(i);
						bothCategories.set(i,max);
						max = temp;
					}
					else if(bothCategories.get(i).getSilverMedals() == max.getSilverMedals())
					{
						if( bothCategories.get(i).getBronzeMedals() > max.getBronzeMedals() )
						{
							Country temp = bothCategories.get(i);
							bothCategories.set(i,max);
							max = temp;
						}
						else if(bothCategories.get(i).getSilverMedals() == max.getSilverMedals())
						{
							if(bothCategories.get(i).getCountryName().compareTo(max.getCountryName()) > 0)
							{
								Country temp = bothCategories.get(i);
								bothCategories.set(i,max);
								max = temp;
							}
							else if( bothCategories.get(i).getCountryName().compareTo(max.getCountryName()) == 0 ) 
							{
								Country temp = bothCategories.get(i);
								bothCategories.set(i,max);
								max = temp;
							}
						}
					}
				}
			}
			bothCategories.set(pos, max);
			pos++;
		}
	}
	
	//Fourth report
	
	//sortByInsertion
	public void sortBothCategoriesByInsertion()
	{
		
		for( int i = 1; i < bothCategories.size(); i++ )
		{
			Country aux = bothCategories.get(i); 
			int j = i-1;
			
			while( (j >= 0)  && (aux.getGoldMedals() < bothCategories.get(j).getGoldMedals()) ) 
			{
				bothCategories.set(j+1, bothCategories.get(j));
				j--;
				
				if( bothCategories.get(i).getGoldMedals() == aux.getGoldMedals())
				{
					if( bothCategories.get(i).getSilverMedals() > aux.getSilverMedals() )
					{
						bothCategories.set(j+1, bothCategories.get(j));
						j--;
					}
					else if(bothCategories.get(i).getSilverMedals() == aux.getSilverMedals())
					{
						if( bothCategories.get(i).getBronzeMedals() > aux.getBronzeMedals() )
						{
							bothCategories.set(j+1, bothCategories.get(j));
							j--;
						}
						else if(bothCategories.get(i).getSilverMedals() == aux.getSilverMedals())
						{
							if(bothCategories.get(i).getCountryName().compareTo(aux.getCountryName()) > 0)
							{
								bothCategories.set(j+1, bothCategories.get(j));
								j--;
							}
							else if( bothCategories.get(i).getCountryName().compareTo(aux.getCountryName()) == 0 ) 
							{
								bothCategories.set(j+1, bothCategories.get(j));
								j--;
							}
						}
					}
				}
			}
				
				bothCategories.set(j+1, aux);
		}

	}
	

}
