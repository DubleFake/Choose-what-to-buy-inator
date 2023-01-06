package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		
		//Initialize variables
		List<Record> records = new ArrayList<>();
		Properties config = new Properties();
		
		//Load and calculate
		config = Import.loadConfig();
		records = Import.loadRecords();
		Calculations.setScore(records, config);
		
		//Sort and display
		records = sort(records);
		printWhatToBuy(records);
		
	}
	
	private static List<Record> sort(List<Record> records) {
		
		List<Record> sortedRecords = new ArrayList<Record>();
		
			sortedRecords = records.stream()
			  .sorted(Comparator.comparing(Record::getScore).reversed())
			  .collect(Collectors.toList());
		
		return sortedRecords;
		
	}
	
	private static void printWhatToBuy(List<Record> records) {
		
		List<Record> bought = new ArrayList<>();
		int x = 1;
		
		System.out.println("Items to buy: ");
		
		for(Record record : records) {
			
			if(!record.getBought())
				System.out.println("\t" + x++ + ") " + record.getName() + " - [" + record.getPrice() + " €]" + " (" + record.getScore() + ")");
			else
				bought.add(record);
		}
		
		if(!bought.isEmpty()) {
			
			System.out.println("\n\nAlready bought items: ");
			
			for(Record record : bought) {
				
				System.out.println("\t" + x++ + ") " + record.getName() + " - [" + record.getPrice() + " €]" + " (" + record.getScore() + ")");
				
			}
			
		}
		
	}
	
}
