package main;

import java.util.List;
import java.util.Properties;

public class Calculations {

	public static void setScore(List<Record> records, Properties config) {
		
		double minimumCost = findMin(records);
		double maximumCost = findMax(records);
		
		for(Record record : records) {
			
			record.setScore(0);

			record.setScore(Math.sqrt(
					Math.pow(Math.max(0, Math.min(5, 5 * ((maximumCost - record.getPrice()) / (maximumCost - minimumCost)))*Double.parseDouble(config.getProperty("price_weight"))), 2) +
					Math.pow(record.getNeed()*Double.parseDouble(config.getProperty("need_weight")), 2) + 
					Math.pow(record.getWant()*Double.parseDouble(config.getProperty("want_weight")), 2)
					));
		}
		
	}
	
	private static double findMin(List<Record> records) {
		
		double minValue = records.get(0).getPrice();
		
		for(Record record : records) {
			
			if(record.getPrice() < minValue) {
				
				minValue = record.getPrice();
				
			}
			
		}
	
		return minValue;
		
	}
	
	private static double findMax(List<Record> records) {
		
		double maxValue = records.get(0).getPrice();
		
		for(Record record : records) {
			
			if(record.getPrice() > maxValue) {
				
				maxValue = record.getPrice();
				
			}
			
		}
	
		return maxValue;
		
	}
	
}
