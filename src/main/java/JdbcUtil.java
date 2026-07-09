
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;

public class JdbcUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public java.sql.Connection connection() throws SQLException {
		Connection connect=null;
		String url="jdbc:mysql://localhost:3306/Registration";
		String user="root";
		String p_w="R3B1N1J1K1@ym";

		return DriverManager.getConnection(url,user,p_w);
	}
	
	public static void close_resources(PreparedStatement statement, java.sql.Connection connect) throws SQLException {
		// TODO Auto-generated method stub
		statement.close();
		connect.close();
	}
}
