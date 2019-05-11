package P3.Domain;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<int> chipkaarten = new ArrayList<int>();
	
	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	
	public Product getByKaartNummer(int kaartNummer) {
		return Product;
	}

}
