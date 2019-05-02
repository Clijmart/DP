package P2.Dao;

import java.util.ArrayList;

import P2.Domain.Reiziger;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
	private ArrayList<Reiziger> reizigerLijst = new ArrayList<Reiziger>();	
	
	public ArrayList<Reiziger> findAll() {
		return reizigerLijst;
	}
	
	public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> nieuwReizigerLijst = new ArrayList<Reiziger>();
		for(Reiziger reiziger : reizigerLijst) {
			if((reiziger.getGBdatum()).equals(java.sql.Date.valueOf(GBdatum))) {
				nieuwReizigerLijst.add(reiziger);
			}
		}
		return nieuwReizigerLijst;
	}
	
	public Reiziger save(Reiziger reiziger) {
		reizigerLijst.add(reiziger);
		return reizigerLijst.get(reizigerLijst.indexOf(reiziger));
	}
	
	public Reiziger update(Reiziger reiziger) {
		for(Reiziger temp : reizigerLijst) {
			if((temp.getNaam()).equals(reiziger.getNaam())) {
				reizigerLijst.set(reizigerLijst.indexOf(temp), reiziger);
				break;
			}
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		reizigerLijst.remove(reizigerLijst.indexOf(reiziger));
		return true;
	}
}
