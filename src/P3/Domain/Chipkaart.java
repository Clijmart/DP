package P3.Domain;

import java.sql.Date;
import java.util.ArrayList;

public class Chipkaart {
	
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger eigenaar;
	private ArrayList<Product> producten;
	
	public Chipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
	}
	
	public Chipkaart() {
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Reiziger getEigenaar() {
		return eigenaar;
	}
	
	public void setEigenaar(Reiziger eigenaar) {
		this.eigenaar = eigenaar;
	}
	
	public ArrayList<Product> getProducten() {
		return producten;
	}
	
	public void setProducten(ArrayList<Product> producten) {
		this.producten = producten;
	}
	
	public String toString() {
		return "\nChipkaart: " + getKaartNummer() + "\nGeldig Tot: " + getGeldigTot() + "\nKlasse: " + getKlasse() + "\nSaldo: " + getSaldo() + "\nEigenaar: " + getEigenaar() + "\nProducten: " + getProducten().toString();
	}
}
