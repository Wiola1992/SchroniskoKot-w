/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  kot.cat
 */
package pl.schronisko.application;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.schronisko.domain.cat;

@Repository
public class kotDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@PersistenceContext
	EntityManager entityManager;

	Connection conn = null;

	public cat getKotById(int id) {
		if (id <= koty.size()) {
			return koty.get(id);
		} else
			return null;
	}

	List<cat> koty = new LinkedList<cat>();
	
	@Transactional
	public void dodajKota(cat c2) {
		
		c2 = entityManager.merge(c2);
	}
	


	@Transactional
	public List<cat> pokazKoty(){
		
		Query query = entityManager.createNativeQuery("SELECT *  FROM koty", cat.class);
		if(query.getResultList()==null) {
			List<cat> kotki= new ArrayList<cat>();
			return kotki;
		} else {
			List<cat> kotki=query.getResultList();
			return kotki;
		}
	}

	@Transactional
	public cat pokazKotaById(int id) {
		Query query =entityManager.createNativeQuery("SELECT * FROM koty WHERE idkota =?", cat.class);
		query.setParameter(1, id);
		   
		    if (query.getResultList() == null ) {
		        return null;
		    } else {
		    List<cat> list = query.getResultList();
		    return list.get(0);
		    }
		}
	
}
