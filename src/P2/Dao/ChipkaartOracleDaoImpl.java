package P2.Dao;

import java.util.ArrayList;

import P2.Domain.Chipkaart;

public class ChipkaartOracleDaoImpl extends OracleBaseDao implements ChipkaartDao {
	
	private ArrayList<Chipkaart> chipkaartLijst = new ArrayList<Chipkaart>();	
	
	public ArrayList<Chipkaart> findAll() {
		return chipkaartLijst;
	}
	
	public ArrayList<Chipkaart> findByGeldigTot(String geldigTot) {
		ArrayList<Chipkaart> nieuwChipkaartLijst = new ArrayList<Chipkaart>();
		for(Chipkaart chipkaart : chipkaartLijst) {
			if((chipkaart.getGeldigTot()).equals(java.sql.Date.valueOf(geldigTot))) {
				nieuwChipkaartLijst.add(chipkaart);
			}
		}
		return nieuwChipkaartLijst;
	}
	
	public Chipkaart save(Chipkaart chipkaart) {
		chipkaartLijst.add(chipkaart);
		return chipkaartLijst.get(chipkaartLijst.indexOf(chipkaart));
	}
	
	public Chipkaart update(Chipkaart chipkaart) {
		for(Chipkaart temp : chipkaartLijst) {
			if(temp.getKaartNummer() == chipkaart.getKaartNummer()) {
				chipkaartLijst.set(chipkaartLijst.indexOf(temp), chipkaart);
				break;
			}
		}
		return chipkaart;
	}
	
	public boolean delete(Chipkaart chipkaart) {
		chipkaartLijst.remove(chipkaartLijst.indexOf(chipkaart));
		return true;
	}
}
