package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.TryCatchFinally;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
@SuppressWarnings("unused")
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	//private String url = "jdbc:"+${DATABASE_URL};
	
	/** The user. */
	//private String user = ${USER};
	
	/** The password. */
	//private String password = ${PASSWORD};

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql://aws.connect.psdb.cloud/db-agenda?sslMode=VERIFY_IDENTITY", "au7en66aw5kob3q8gqwr", "pscale_pw_h0HVCmwoBjyGsKqPgPP1M0DxTAiQw9iHxahG6LgH9mK");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String sql = "insert into contatos (nome,fone,email) values (?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String sql = "select * from contatos order by nome";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String sql = "select * from contatos where idcon = ?";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getIdecon());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contato.setIdecon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {

		String sql = "update contatos set nome=?,fone=?,email=? where idcon=?";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdecon());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {

		String sql = "delete from contatos where idcon=?";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getIdecon());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
