package ui;

import java.io.IOException;
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
			"(2) Show Billboards\n"+								
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
		System.out.println("----------\n");
	}
}
