import java.sql.*;

import javax.swing.JOptionPane;
public class ConetctaBD {

	public static Connection conectabd() throws ClassNotFoundException {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jbdc:postgresql://localhost:5432","postgres","1313");
			JOptionPane.showMessageDialog(null, "Conetado com sucesso!");
			return con;
		}
		
		catch(SQLException error) {
			
			JOptionPane.showMessageDialog(null, error);
			
			return null;
		}
	}
	
}
