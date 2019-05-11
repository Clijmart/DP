package P3.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import P3.Domain.Chipkaart;
import P3.Domain.Reiziger;
import P3.Domain.Product;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {
	
	public ProductOracleDaoImpl() throws SQLException {
		super();
	}

	private ArrayList<Chipkaart> chipkaarten = new ArrayList<Chipkaart>();	
	
	public ArrayList<Chipkaart> getByKaartNummer(int kaartNummer) throws SQLException {
		String strQuery = "SELECT * FROM ov_chipkaart oc, ov_chipkaart_product ocp WHERE ov.kaartnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, reiziger.getId());
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Chipkaart> chipkaartLijst = new ArrayList<Chipkaart>();
		while (rs.next()) {   
			Chipkaart chipkaart = new Chipkaart();
			
			
			
			
			chipkaart.setEigenaar(reiziger);			
			chipkaartLijst.add(chipkaart);
		}
		
		rs.close();
		pstmt.close();
		return chipkaartLijst;
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

	public Chipkaart save(Chipkaart chipkaart, Reiziger reiziger) {
		chipkaartLijst.add(chipkaart);
		return chipkaartLijst.get(chipkaartLijst.indexOf(chipkaart));
	}
}
