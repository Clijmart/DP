package P3.Dao;

import java.util.ArrayList;

import P3.Domain.Chipkaart;

public interface ProductDao {
	public Chipkaart getByKaartNummer(int kaartNummer);
}
