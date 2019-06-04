package P3.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import P3.Domain.Chipkaart;
import P3.Domain.Product;

public interface ProductDao {
	public ArrayList<Product> findAll() throws SQLException;
	public Product findByProductNummer(int productNummer) throws SQLException;
	public ArrayList<Product> findByChipkaart(Chipkaart kaart) throws SQLException;
	public Product save(Product product) throws SQLException;
	public Product update(Product product) throws SQLException;
	public Product delete(Product product) throws SQLException;
}
