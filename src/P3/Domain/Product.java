package P3.Domain;

import java.util.ArrayList;

public class Product {
	
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<Chipkaart> kaarten;
	
	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	
	public Product() {
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public ArrayList<Chipkaart> getKaarten() {
		return kaarten;
	}
	
	public void setKaarten(ArrayList<Chipkaart> kaarten) {
		this.kaarten = kaarten;
	}
	
	public String toString() {
		return "\nProduct: " + getProductNummer() + "\nNaam: " + getProductNaam() + "\nBeschrijving: " + getBeschrijving() + "\nPrijs: " + getPrijs() ;
	}
}
