import java.sql.*;

public class Model {
	private String name;
	private String city;
	private String emailid;
	private String password;
	private Connection connection=null;
	private PreparedStatement psmnt = null;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int register() {
		int rows=0;
		JdbcUtil jdbc = new JdbcUtil();
		try {
			connection=jdbc.connection();
			String sql="Insert Into primary_info (uname,emailid,passwrod,city) values (?,?,?,?)";
			psmnt=connection.prepareStatement(sql);
			
			psmnt.setString(1, name);
			psmnt.setString(2, emailid);
			psmnt.setString(3, password);
			psmnt.setString(4, city);
			
			rows=psmnt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				psmnt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
}
