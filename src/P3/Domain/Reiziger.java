package P3.Domain;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
	private int id;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	private ArrayList<Chipkaart> chipkaarten = new ArrayList<Chipkaart>();
	
	public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
		this.id = id;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
	}
	
	public Reiziger() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	
	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	public Date getGeboortedatum() {
		return geboortedatum;
	}
	
	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	
	public ArrayList<Chipkaart> getKaarten() {
		return chipkaarten;
	}
	
	public void setKaarten(ArrayList<Chipkaart> chipkaarten) {
		this.chipkaarten = chipkaarten;
	}
	
	public boolean voegChipkaartToe(Chipkaart chipkaart) {
		return chipkaarten.add(chipkaart);
	}

	public boolean verwijderChipkaart(Chipkaart chipkaart) {
		return chipkaarten.remove(chipkaart);
	}
	
	
	public String getNaam() {
		return getVoorletters() + " " + getTussenvoegsel() + " " + getAchternaam();
	}
	
	public String toString() {
		return "\nReiziger: " + getId() + "\nNaam: " + getNaam() + "\nGeboortedatum: " + getGeboortedatum();
	}
}
