package main;

public class Record {

	private String name;
	private double need;
	private double want;
	private double price;
	private double score;
	private boolean bought;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNeed(double need) {
		this.need = need;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setWant(double want) {
		this.want = want;
	}
	public String getName() {
		return name;
	}
	public double getNeed() {
		return need;
	}
	public double getPrice() {
		return price;
	}
	public double getWant() {
		return want;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getScore() {
		return score;
	}
	public void setBought(boolean bought) {
		this.bought = bought;
	}
	public boolean getBought() {
		return bought;
	}
	
}
