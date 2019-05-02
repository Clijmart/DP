package P2.Dao;

import java.util.ArrayList;

import P2.Domain.Reiziger;

public interface ReizigerDao {
	public ArrayList<Reiziger> findAll();
	public ArrayList<Reiziger> findByGBdatum(String GBdatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
	public void closeConnection();
}
