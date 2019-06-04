package P3.Domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import P3.Dao.ReizigerOracleDaoImpl;
import P3.Dao.ReizigerDao;
import P3.Dao.ChipkaartOracleDaoImpl;
import P3.Dao.ChipkaartDao;
import P3.Dao.ProductOracleDaoImpl;
import P3.Dao.ProductDao;

public class Main {
	public static void main(String[] args) throws SQLException {
		ReizigerDao rdao = new ReizigerOracleDaoImpl();
		ChipkaartDao cdao = new ChipkaartOracleDaoImpl();
		ProductDao pdao = new ProductOracleDaoImpl();
		
		
		/*
		System.out.println(rdao.findById(4));
		System.out.println(rdao.findAll());
		System.out.println(rdao.findByGeboortedatum(Date.valueOf("2002-12-03")));
		
		Reiziger r1 = new Reiziger();
		r1.setId(6);
		r1.setVoorletters("M");
		r1.setAchternaam("Clijnk");
		r1.setGeboortedatum(Date.valueOf("1999-02-09"));
		
		rdao.save(r1);
		
		r1.setGeboortedatum(Date.valueOf("1999-09-02"));
		rdao.update(r1);
		
		Reiziger r2 = rdao.findById(3);
		//rdao.delete(r2);
		
		System.out.println(rdao.findAll());
		*/
		
		//System.out.println(cdao.findByKaartNummer(46392));
		
		//System.out.println(cdao.findAll());
		
		//Chipkaart c4 = cdao.findByKaartNummer(35283);
		
		//System.out.println(pdao.findByChipkaart(c4));
		
		System.out.println(pdao.findByChipkaart(cdao.findByKaartNummer(35283)));
		
		
		
	}
}
