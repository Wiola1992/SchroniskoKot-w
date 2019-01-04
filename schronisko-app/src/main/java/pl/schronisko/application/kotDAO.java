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

/*	public void dodajKota(cat c2) {

		String sql = "INSERT INTO koty (imie, waga, opiekun, data )VALUES (?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c2.getName());
			ps.setDouble(2, c2.getWeight());
			ps.setString(3, c2.getGuardian());
		//	java.sql.Date sqlDate = new java.sql.Date();
		//	 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
			
			if(c2.getDateOfBirth()!=null) {
				java.sql.Date sqlDate = new java.sql.Date(c2.getDateOfBirth().getTime());
				ps.setDate(4, sqlDate);
			} else ps.setDate(4, null);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		this.koty.add(c2);
		System.out.println("super dodales kota " + c2.getName());
	} */

	/*
	 * public List<cat> getKoty() { return koty; }
	 */

	@Transactional
	public List<cat> pokazKoty(){
		
		Query query = entityManager.createNativeQuery("SELECT *  FROM koty", cat.class);
		List<cat> kotki=query.getResultList();
		
		return kotki;
	}
	/*public List<cat> pokazKoty() {
		List<cat> kotki = new ArrayList();
		String sql = "SELECT * FROM koty";
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			cat kot = null;
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
			//	rs.getDate("data");
				java.sql.Date sqlDate = rs.getDate("data");
				
				if (sqlDate != null) {
			        Date  dateOfBirth = new Date(sqlDate.getTime());
			            kot = new cat(

							rs.getString("imie"), rs.getDouble("waga"), rs.getString("opiekun"), rs.getInt("idkota"), dateOfBirth);
						
			            kotki.add(kot);
						
				} else {
						kot = new cat(

							 rs.getString("imie"), rs.getDouble("waga"), rs.getString("opiekun"), rs.getInt("idkota"));
			        	
						kotki.add(kot);
				}
				
			}
			rs.close();
			ps.close();
			return kotki;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	} */

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
