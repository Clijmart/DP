package P2.Domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import P2.Dao.ReizigerOracleDaoImpl;
import P2.Dao.ReizigerDao;
import P2.Dao.ChipkaartOracleDaoImpl;
import P2.Dao.ChipkaartDao;

public class Main {
	public static void main(String[] args) throws SQLException {
		ReizigerDao rdao = new ReizigerOracleDaoImpl();
		ChipkaartDao cdao = new ChipkaartOracleDaoImpl();
		
		
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
		
		
		Reiziger r3 = rdao.findById(4);
		
		System.out.println(cdao.findByReiziger(r3));
		
		Chipkaart c1 = new Chipkaart();
		c1.setKaartNummer(69420);
		c1.setGeldigTot(Date.valueOf("2004-02-06"));
		c1.setKlasse(2);
		c1.setSaldo(6.66);
		c1.setEigenaar(r3);
		
		cdao.save(c1, r3);
		
		System.out.println(cdao.findAll());
		
		c1.setKlasse(1);
		
		cdao.update(c1);
		
		
	}
}
