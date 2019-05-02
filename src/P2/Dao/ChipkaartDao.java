package P2.Dao;

import java.util.ArrayList;

import P2.Domain.Chipkaart;

public interface ChipkaartDao {
	public ArrayList<Chipkaart> findAll();
	public ArrayList<Chipkaart> findByGeldigTot(String geldigTot);
	public Chipkaart save(Chipkaart chipkaart);
	public Chipkaart update(Chipkaart chipkaart);
	public boolean delete(Chipkaart chipkaart);
	public void closeConnection();
}
