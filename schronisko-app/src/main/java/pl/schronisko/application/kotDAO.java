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

	public cat pokazKotaById(int id) {
		String sql = "SELECT * FROM koty WHERE idkota =?";
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			cat kot = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { 
				kot = new cat();
				kot.setId(rs.getInt("idkota")); 
				kot.setName(rs.getString("imie"));
				kot.setWeight(rs.getDouble("waga"));
				kot.setGuardian(rs.getString("opiekun"));
				kot.setDateOfBirth(rs.getDate("data"));
			} 
				rs.close(); 
				ps.close();
				return kot;
		} catch (SQLException e) { 
			throw new RuntimeException(e); 
		} finally { 
			if (conn != null) { 
				try { conn.close();
				} catch (SQLException e) {} 
			}
		}
	} 
}
