package P2;

import java.sql.Date;

import P2.Dao.ReizigerArrayDaoImpl;
import P2.Dao.ReizigerDao;
import P2.Domain.Reiziger;

public class Main {
	public static void main(String[] args) {
		Date datum1 = java.sql.Date.valueOf("1999-02-09");
		Date datum2 = java.sql.Date.valueOf("1990-12-23");
		Date datum3 = java.sql.Date.valueOf("2010-10-29");
		
		Reiziger r1 = new Reiziger("Mart", datum1);
		Reiziger r2 = new Reiziger("Harry", datum2);
		Reiziger r3 = new Reiziger("Piet", datum3);
		
		ReizigerDao dao = new ReizigerArrayDaoImpl();
		
		dao.save(r1);
		dao.save(r2);
		dao.save(r3);
		
		System.out.println(dao.findAll());
		
		r1.setNaam("Henk");
		r2.setGBdatum("2004-04-04");
		
		System.out.println(dao.findByGBdatum("1999-02-09"));
		
		dao.delete(r1);
		
		Date datum3new = java.sql.Date.valueOf("2010-11-29");
		Reiziger r3new = new Reiziger("Piet", datum3new);
		
		dao.update(r3new);
		
		System.out.println(dao.findAll());
		
	}
}
