
import java.sql.*;
public class DAO {
private Connection conexao;
public DAO() {
	conexao=null;
}
public boolean conectar() {
	String driverName="org.postgresql.Driver";
	String serverName="localhost";
	String mydatabase="teste";
	int porta=5432;
	String url="jdbc:postgresql://"+serverName+":"+porta+"/"+mydatabase;
	String username="ti2cc";
	String password="ti@cc";
	boolean status=false;
	try {
		Class.forName(driverName);
		conexao=DriverManager.getConnection(url,username,password);
		status=(conexao==null);
		System.out.println("Conexao efetuada com o postgres!");
		
	}catch(ClassNotFoundException e) {
		System.err.println("Conexao Nao efetuada com o postgress--Driver não encontrado--"+e.getMessage());
	}catch (SQLException e ){
		System.err.println("Conexao NÃO efetuada com o postgress--"+e.getMessage());
		
	}
	
	return status;

}
public boolean close() {
	boolean status=false;
	try {
		conexao.close();
		status=true;
	}catch(SQLException e){
		System.err.println(e.getMessage());
	}
	return status;
	}
	public boolean inserirCasa(Casa casa) {
		boolean status=false;
	try {
		Statement st=conexao.createStatement();
		st.executeUpdate("INSERT INTO casa(objectos,camas,quartos,banheiros)"
				+"VALUES("+casa.getObjectos()+",'"+casa.getCamas()+"','"
				+casa.getQuartos()+"','"+casa.getBanheiros()+"');");
		st.close();
		status=true;
	}catch(SQLException u) {
		throw new RuntimeException(u);
	}
	return status;
				
	}
	public boolean atualizarCasa(Casa casa) {
		boolean status=false;
		try {
			Statement st=conexao.createStatement();
			String sql=("UPDATE casa SET objectos='"
					+casa.getObjectos()+"',camas='"
					+casa.getCamas()+"',quartos='"+casa.getQuartos()+"'")
			+"WHERE objectos = "+casa.getObjectos();
			st.executeUpdate(sql);
			st.close();
			status=true;
		}catch(SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
		}
	public boolean excluirCasa(int objectos) {
		boolean status=false;
		try {
			Statement st=conexao.createStatement();
			st.executeUpdate("DELETE FROM casa WHERE objectos="+objectos);
			st.close();
			status=true;
		}catch(SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	public Casa[]getCasas(){
		Casa[]casas=null;
		
		try {
			Statement st=conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("SELECT * FROM casa");
			if(rs.next()) {
				rs.last();
				casas=new Casa[rs.getRow()];
				rs.beforeFirst();
				for(int i=0;rs.next();i++) {
					casas[i]=new Casa(rs.getInt("objectos"),rs.getString("camas"),
							rs.getString("quartos"),rs.getString("banheiros"));
				}
			}
			st.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return casas;
		
	}
	public Casa[]getCasa(){
		Casa[] casas=null;
		try {
			Statement st=conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("SELECT * FROM usuario WHERE usuario.sexo LIKE'M'");
			if(rs.next()) {
				rs.last();
				casas=new Casa[rs.getRow()];
				rs.beforeFirst();
				for(int i=0;rs.next();i++) {
					casas[i]=new Casa(rs.getInt("objectos"),rs.getString("camas"),
							rs.getString("quartos"),rs.getString("banheiros"));
				}
			}
			st.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return casas;
	
	
}
}
