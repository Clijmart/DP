package P3.Dao;

import java.sql.*;
import java.util.ArrayList;

import P3.Domain.Chipkaart;
import P3.Domain.Reiziger;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
	
	
	public ReizigerOracleDaoImpl() throws SQLException {
		super();
	}
	
	public ArrayList<Reiziger> findAll() throws SQLException {
		String strQuery = "SELECT * FROM reiziger";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();	
		while (rs.next()) {
			Reiziger r = new Reiziger();
			
			r.setId(rs.getInt("reizigerid"));
			r.setVoorletters(rs.getString("voorletters"));
			r.setTussenvoegsel(rs.getString("tussenvoegsel"));
			r.setAchternaam(rs.getString("achternaam"));
			r.setGeboortedatum(rs.getDate("gebortedatum"));
			reizigers.add(r);
		}
		rs.close();
		pstmt.close();
		return reizigers;
	}
	
	public Reiziger findById(int id) throws SQLException {
		String strQuery = "SELECT * FROM reiziger WHERE reizigerid = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		Reiziger r = new Reiziger();
		while (rs.next()) {
			r.setId(rs.getInt("reizigerid"));
			r.setVoorletters(rs.getString("voorletters"));
			r.setTussenvoegsel(rs.getString("tussenvoegsel"));
			r.setAchternaam(rs.getString("achternaam"));
			r.setGeboortedatum(rs.getDate("gebortedatum"));
		
			//r.setKaarten(new ChipkaartOracleDaoImpl().findByReiziger(r));
		}
		
		rs.close();
		pstmt.close();
		return r;
	}
	
	public ArrayList<Reiziger> findByGeboortedatum(Date geboortedatum) throws SQLException {
		String strQuery = "SELECT * FROM reiziger WHERE gebortedatum = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setDate(1, geboortedatum);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();	
		while (rs.next()) {
			Reiziger r = new Reiziger();
			r.setId(rs.getInt("reizigerid"));
			r.setVoorletters(rs.getString("voorletters"));
			r.setTussenvoegsel(rs.getString("tussenvoegsel"));
			r.setAchternaam(rs.getString("achternaam"));
			r.setGeboortedatum(rs.getDate("gebortedatum"));
			reizigers.add(r);
		}
		
		rs.close();
		pstmt.close();
		return reizigers;
	}
	
	public Reiziger save(Reiziger reiziger) throws SQLException {
		String strQuery = "INSERT INTO reiziger (reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, reiziger.getId());
		pstmt.setString(2, reiziger.getVoorletters());
		pstmt.setString(3, reiziger.getTussenvoegsel());
		pstmt.setString(4, reiziger.getAchternaam());
		pstmt.setDate(5, reiziger.getGeboortedatum());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return reiziger;
	}
	
	
	public Reiziger update(Reiziger reiziger) throws SQLException {
		String strQuery = "UPDATE reiziger SET reizigerid = ?, voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, reiziger.getId());
		pstmt.setString(2, reiziger.getVoorletters());
		pstmt.setString(3, reiziger.getTussenvoegsel());
		pstmt.setString(4, reiziger.getAchternaam());
		pstmt.setDate(5, reiziger.getGeboortedatum());
		pstmt.setInt(6, reiziger.getId());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return reiziger;
	}
	
	public Reiziger delete(Reiziger reiziger) throws SQLException {
		String strQuery = "DELETE reiziger WHERE reizigerid = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, reiziger.getId());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return reiziger;
	}
	
}
