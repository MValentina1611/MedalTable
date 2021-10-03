package ui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.Country;
import model.MedalTable;

public class MedalTableSystem {

	private  MedalTable medalTable;
	private Scanner reader;
	
	
	public MedalTableSystem()
	{
		medalTable = new MedalTable();
		reader = new Scanner(System.in);
	}
	
	
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		System.out.println("The App is initializing...");
		
		 MedalTableSystem mts = new MedalTableSystem();
		 
		 int menuOp = 0;

			do
			{
				menuOp = mts.showMenu();
				mts.executeOptions(menuOp);

			}while( menuOp != 0 );
			
		
	}
	
	public int showMenu() throws IOException 
	{
		int menuOp = 0;

		String menu = 
			"=====WELCOME TO THE MEDAL TABLE SYSTEM=====\n" +
			"Pick an option \n" +
			"(1) Use default info\n" +
			"(2) Type the info\n"+								
			"(0) Exit";
		
		System.out.println(menu);
		menuOp = reader.nextInt();
		reader.nextLine();
		return menuOp;

	}//Method ends
	
	public void executeOptions( int option ) throws IOException, ClassNotFoundException
	{
		switch( option ) 
		{

			case 0:
				System.out.println ("Bye");
				break;
			case 1:
				testScenario();
				break;
	
			case 2:
				askForCountries();
				showReports();
				break;
		
			default:
				System.out.println("Error, invalid option");
				
		}//Switch ends
		
	}//Method ends
	
	
	
	
	public void printArrayList(List<Country> category)
	{
		for( int i = 0; i < category.size(); i++ )
		{
			System.out.println(category.get(i).toString());
		}
	}
	
	public void testScenario() throws IOException
	{
		medalTable.importData();
		showReports();
	}
	
	public void showReports()
	{

		System.out.println("Male");
		medalTable.sortByMedalMaterialAndName();
		printArrayList(medalTable.getMaleCategory());
		System.out.println("\n----------\n");

		System.out.println("Female");
		medalTable.sortFemaleByMedalMaterialAndName();
		printArrayList(medalTable.getFemaleCategory());
		System.out.println("\n----------\n");
		
		System.out.println("Combined");
		medalTable.sortBothCategories();
		printArrayList(medalTable.getBothCategories());
		System.out.println("\n----------\n");
		
		System.out.println("Combined");
		medalTable.sortBothCategoriesByInsertion();
		Collections.reverse(medalTable.getBothCategories());
		printArrayList(medalTable.getBothCategories());

		
	}
	
	public void askForCountries()
	{
		String inputInfo = "";
		int amount = 0;
		
		System.out.println("How many countries do you want register?" );
		amount = reader.nextInt();
		reader.nextLine();
		System.out.println("Type the info of each country separate by semicolon" +"\n");
		
		for(int i = 0; i<amount; i++)
		{
			inputInfo = reader.nextLine() + ";";	
			if(inputInfo != null)
			{
				String info[] = inputInfo.split("\\;");
				String countryName = info[0];
				try{
					medalTable.addCountry(1, countryName,Integer.parseInt(info[1]) , Integer.parseInt(info[2]),Integer.parseInt(info[3]));
					medalTable.addCountry(2, countryName,Integer.parseInt(info[4]),Integer.parseInt(info[5]),Integer.parseInt(info[6]));
					
					int totalGolds = Integer.parseInt(info[1]) + Integer.parseInt(info[4]);
					int totalSilver = Integer.parseInt(info[2]) + Integer.parseInt(info[5]);
					int totalBronze = Integer.parseInt(info[3]) + Integer.parseInt(info[6]);					
					Country country = new Country(info[0], totalGolds, totalSilver,totalBronze);
					medalTable.getBothCategories().add(country);
					
				}catch(NumberFormatException e){}
			}
		}

	}
	
	public void printArray(String [] array)
	{
		for(int i =0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
}
