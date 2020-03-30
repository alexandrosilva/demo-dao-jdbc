package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + 
					"FROM seller INNER JOIN department " + 
					"ON seller.DepartmentId = department.Id " + 
					"WHERE seller.Id = ?"				
					);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next() ) {
				Department dep = new Department();
				
				// pega ID do departamento
				dep.setId(rs.getInt("DepartmentId"));
				// pega nome do departamento
				dep.setName(rs.getString("DepName"));
				
				//Extrair dados do tabela seller
				Seller obj = new Seller();
				// pega id do seller
				obj.setId(rs.getInt("Id"));
				// pega o nome da tabela seller
				obj.setName(rs.getString("Name"));
				// pega o email da tebela seller
				obj.setEmail(rs.getString("Email"));
				// pega o salario da tebela seller
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				// pega a data da tabela seller
				obj.setBirthDate(rs.getDate("BirthDate"));
				// a associação do departamento
				obj.setDepartment(dep);
				
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
