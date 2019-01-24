package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MagazineDao;
import domain.Magazine;
import utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao {
	static String CREATE = "insert into list(name,price) values (?,?)";
	private static String READ_ALL_LIST= "select * from list";
	private static String READ_BY_ID = "select * from list where id =?";
	private static String UPDATE_BY_ID = "update list set name = ?, price=?  where id = ?";
	private static String DELETE_BY_ID = "delete from list where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	public MagazineDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Magazine create(Magazine t) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setDouble(2, t.getPrice());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine mag = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			int idu = result.getInt("id_user");
			String name = result.getString("name");
			float price= result.getFloat("price");
			mag = new Magazine (idu, name, price);


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mag;
		
	}

	@Override
	public Magazine update(Magazine t) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setDouble(2, t.getPrice());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public  List<Magazine> readAll() {
		List<Magazine> mag = new ArrayList<Magazine>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL_LIST);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				float price = result.getFloat("price");
				mag.add(new Magazine(id, name, price));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		return mag;
	}

}
