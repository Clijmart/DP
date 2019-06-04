package P3.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P3.Domain.Chipkaart;
import P3.Domain.Reiziger;
import P3.Dao.ReizigerDao;
import P3.Dao.ReizigerOracleDaoImpl;

public class ChipkaartOracleDaoImpl extends OracleBaseDao implements ChipkaartDao {
	
	private ReizigerDao rdao = new ReizigerOracleDaoImpl();
	private ProductDao pdao = new ProductOracleDaoImpl();
	
	public ChipkaartOracleDaoImpl() throws SQLException {
		super();
	}
	
	public ArrayList<Chipkaart> findAll() throws SQLException {
		String strQuery = "SELECT * FROM ov_chipkaart";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Chipkaart> chipkaarten = new ArrayList<Chipkaart>();	
		while (rs.next()) {
			Chipkaart c = new Chipkaart();
			c.setKaartNummer(rs.getInt("kaartnummer"));
			c.setGeldigTot(rs.getDate("geldigtot"));
			c.setKlasse(rs.getInt("klasse"));
			c.setSaldo(rs.getDouble("saldo"));
			c.setEigenaar(rdao.findById(rs.getInt("reizigerid")));
			c.setProducten(pdao.findByChipkaart(c));
			chipkaarten.add(c);
		}
		rs.close();
		pstmt.close();
		return chipkaarten;
	}
	
	public Chipkaart findByKaartNummer(int kaartNummer) throws SQLException {
		String strQuery = "SELECT * FROM ov_chipkaart WHERE kaartnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, kaartNummer);
		ResultSet rs = pstmt.executeQuery();
		
		Chipkaart c = new Chipkaart();
		while (rs.next()) {
			c.setKaartNummer(rs.getInt("kaartnummer"));
			c.setGeldigTot(rs.getDate("geldigtot"));
			c.setKlasse(rs.getInt("klasse"));
			c.setSaldo(rs.getDouble("saldo"));
			c.setEigenaar(rdao.findById(rs.getInt("reizigerid")));
			c.setProducten(pdao.findByChipkaart(c));
		}
		
		rs.close();
		pstmt.close();
		return c;
	}
	
	public ArrayList<Chipkaart> findByReiziger(Reiziger reiziger) throws SQLException {
		String strQuery = "SELECT * FROM ov_chipkaart WHERE reizigerid = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, reiziger.getId());
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Chipkaart> chipkaarten = new ArrayList<Chipkaart>();	
		while (rs.next()) {
			Chipkaart c = new Chipkaart();
			c.setKaartNummer(rs.getInt("kaartnummer"));
			c.setGeldigTot(rs.getDate("geldigtot"));
			c.setKlasse(rs.getInt("klasse"));
			c.setSaldo(rs.getDouble("saldo"));
			c.setEigenaar(reiziger);
			c.setProducten(pdao.findByChipkaart(c));
			chipkaarten.add(c);
		}
		rs.close();
		pstmt.close();
		return chipkaarten;
	}
	
	public Chipkaart save(Chipkaart chipkaart, Reiziger reiziger) throws SQLException {
		String strQuery = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, chipkaart.getKaartNummer());
		pstmt.setDate(2, chipkaart.getGeldigTot());
		pstmt.setInt(3, chipkaart.getKlasse());
		pstmt.setDouble(4, chipkaart.getSaldo());
		pstmt.setInt(5, reiziger.getId());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return chipkaart;
	}
	
	public Chipkaart update(Chipkaart chipkaart) throws SQLException {
		String strQuery = "UPDATE ov_chipkaart SET kaartnummer = ?, geldigtot = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		
		pstmt.setInt(1, chipkaart.getKaartNummer());
		pstmt.setDate(2, chipkaart.getGeldigTot());
		pstmt.setInt(3, chipkaart.getKlasse());
		pstmt.setDouble(4, chipkaart.getSaldo());
		pstmt.setInt(5, chipkaart.getEigenaar().getId());
		pstmt.setInt(6, chipkaart.getKaartNummer());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return chipkaart;
	}
	
	public Chipkaart delete(Chipkaart chipkaart) throws SQLException {
		String strQuery = "DELETE ov_chipkaart WHERE kaartnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, chipkaart.getKaartNummer());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return chipkaart;
	}
}
