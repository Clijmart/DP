package P3.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import P3.Domain.Reiziger;

public interface ReizigerDao {
	public ArrayList<Reiziger> findAll() throws SQLException;
	public Reiziger findById(int id) throws SQLException;
	public ArrayList<Reiziger> findByGeboortedatum(Date geboortedatum) throws SQLException;
	public Reiziger save(Reiziger reiziger) throws SQLException;
	public Reiziger update(Reiziger reiziger) throws SQLException;
	public Reiziger delete(Reiziger reiziger) throws SQLException;
}
