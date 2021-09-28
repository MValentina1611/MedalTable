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
	private int amountOfCountries;
	private final String TEST_FILE = "data/testFile.txt";
	
	public MedalTable() {
		
		this.maleCategory = new ArrayList<Country>();
		this.femaleCategory = new ArrayList<Country>();
		
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
				//int numBronzeF = Integer.parseInt(info[6]);
				
				addCountry(1,name,numGoldM,numSilverM,numBronzeM);
				//addCountry(2,name,numGoldF,numSilverF,numBronzeF);
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
	
}
