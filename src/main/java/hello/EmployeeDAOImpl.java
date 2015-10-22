package hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Employee employee) {
		
		String sql = "INSERT INTO testtable " + "(id, firstname, surname) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
        	conn = dataSource.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setInt(1, employee.getId());
        	ps.setString(2, employee.getFirstName());
        	ps.setString(3, employee.getSurName());
        	ps.executeUpdate();
        	ps.close();
        }
        catch (SQLException e) {
        	throw new RuntimeException(e);
        }
        finally {
        	if (conn != null) {
        		try {
        			conn.close();
        		} catch (SQLException e) {}
        	}
        }
	}

	public Employee findById(int id) {
		String sql = "SELECT * FROM testtable WHERE id = ?";
		Connection conn = null;

		 try {
	        	conn = dataSource.getConnection();
	        	PreparedStatement ps = conn.prepareStatement(sql);
	        	ps.setInt(1, id);
	        	Employee employee = null;
	        	ResultSet rs = ps.executeQuery();
	        	if (rs.next()) {
	        		employee = new Employee(
        				rs.getInt("id"),
        				rs.getString("firstname"),
        				rs.getString("surname")
        			);
	        	}
	        	rs.close();
	        	ps.close();
	        	return employee;
		 	}
		 catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
		 finally {
			 if (conn != null) {
				 try {
					 conn.close();
				 } catch (SQLException e) {}
			 }
		 } 
	}

}
