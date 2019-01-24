package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import domain.Magazine;
import domain.User;
import utils.ConnectionUtils;

public class UserDaoImpl implements UserDao{
	static String CREATE = "insert into users(username,subscribes,pass) values (?,?,?)";
	static String READ_ALL_USER = "select * from users";
	private static String READ_BY_ID = "select * from users where id_user =?";
	private static String UPDATE_BY_ID = "update users set username=?, subscribes = ?, pass = ?, where id = ?";
	private static String DELETE_BY_ID = "delete from users where id_user=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public User create(User user) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUser_name());
			preparedStatement.setString(2, user.getSub());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setUser_id(rs.getInt(1));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			int idu = result.getInt("id_user");
			String name = result.getString("username");
			String subscribe = result.getString("subscribes");
			String pass = result.getString("pass");
			user = new User(idu, name, subscribe,pass);


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
		
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,user.getUser_name() );
			preparedStatement.setString(2, user.getSubscribes().toString());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
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
	public List<User> readAll() {
		List<User> users = new ArrayList<User>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL_USER);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int id = result.getInt("id_user");
				String name = result.getString("username");
				String subscribe = result.getString("subscribes");
				String pass = result.getString("pass");
				users.add(new User(id, name, subscribe,pass));

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return users;
		
	}
	public boolean existUser(String name) throws Exception {
		return readAll().stream().anyMatch(u->u.getUser_name().contains(name));
		}
	public User thisUser(String name) throws Exception {
		return readAll().stream().filter(u->u.getUser_name().contains(name)).findFirst().orElse(null);
	}
	
	public void printAllUsers() throws Exception {
		
		readAll().forEach(System.out::println);
	}

	public List<User> showFullSubscribes() throws Exception {
		List<User> temporary = readAll();
		temporary.forEach(u -> {
			u.toIntList(u.getSub());
			u.setSub("");
			u.getSubscribes().forEach(s -> {

				try {
					MagazineDaoImpl magazines=new MagazineDaoImpl();;
					List <Magazine> mag = magazines.readAll();
					u.setSub(u.getSub() + mag.get(s - 1) + "\n");

				} catch (Exception e) {

					
				
				}
			});

		});
		return temporary;
	}
public String userSubscribes(User u) {
	u.toIntList(u.getSub());
	u.setSub("");
	u.getSubscribes().forEach(s -> {

		try {
			u.setSub(u.getSub() + readAll().get(s - 1) + "\n");

		} catch (Exception e) {

		}
});
return u.getSub();}
}
