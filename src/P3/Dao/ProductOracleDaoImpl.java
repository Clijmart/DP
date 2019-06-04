package P3.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import P3.Domain.Chipkaart;
import P3.Domain.Product;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {
	
	public ProductOracleDaoImpl() throws SQLException {
		super();
	}
	
	public ArrayList<Product> findAll() throws SQLException {
		String strQuery = "SELECT * FROM product";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Product> producten = new ArrayList<Product>();	
		while (rs.next()) {
			Product p = new Product();
			p.setProductNummer(rs.getInt("productnummer"));
			p.setProductNaam(rs.getString("productnaam"));
			p.setBeschrijving(rs.getString("beschrijving"));
			p.setPrijs(rs.getDouble("prijs"));
			producten.add(p);
		}
		rs.close();
		pstmt.close();
		return producten;
	}
	
	public Product findByProductNummer(int productNummer) throws SQLException {
		String strQuery = "SELECT * FROM product WHERE productnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, productNummer);
		ResultSet rs = pstmt.executeQuery();
		
		Product p = new Product();
		while (rs.next()) {
			p.setProductNummer(rs.getInt("productnummer"));
			p.setProductNaam(rs.getString("productnaam"));
			p.setBeschrijving(rs.getString("beschrijving"));
			p.setPrijs(rs.getDouble("prijs"));
		}
		
		rs.close();
		pstmt.close();
		return p;
	}
	
	public ArrayList<Product> findByChipkaart(Chipkaart kaart) throws SQLException {
		String strQuery = "SELECT * FROM ov_chipkaart_product WHERE kaartnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, kaart.getKaartNummer());
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Product> producten = new ArrayList<Product>();	
		while (rs.next()) {
			Product p = new Product();
			p = this.findByProductNummer(rs.getInt("productnummer"));
			producten.add(p);
		}
		rs.close();
		pstmt.close();
		return producten;
	}
	
	public Product save(Product product) throws SQLException {
		String strQuery = "INSERT INTO product (productnummer, productnaam, beschrijving, prijs) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, product.getProductNummer());
		pstmt.setString(2, product.getProductNaam());
		pstmt.setString(3, product.getBeschrijving());
		pstmt.setDouble(4, product.getPrijs());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return product;
	}
	
	public Product update(Product product) throws SQLException {
		String strQuery = "UPDATE product SET productnummer = ?, productnaam = ?, beschrijving = ?, prijs = ? WHERE productnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		
		pstmt.setInt(1, product.getProductNummer());
		pstmt.setString(2, product.getProductNaam());
		pstmt.setString(3, product.getBeschrijving());
		pstmt.setDouble(4, product.getPrijs());
		pstmt.setInt(6, product.getProductNummer());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return product;
	}
	
	public Product delete(Product product) throws SQLException {
		String strQuery = "DELETE product WHERE productnummer = ?";
		PreparedStatement pstmt = getConnection().prepareStatement(strQuery);
		pstmt.setInt(1, product.getProductNummer());
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		pstmt.close();
		return product;
	}
}
