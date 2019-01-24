package dvLes02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	
	static String READ_ALL_LIST = "select * from list";
	static String READ_ALL_USER = "select * from users";
	static String NEW_USER = "insert into users(username,subscribes) values (?,?)";
	static String NEW_PAYMENT = "insert into payments(username,description,sum) values (?,?,?)";
	static String DELETE_USER_BY_ID= "delete from users where id_user = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public Dao(Connection connection) {
		this.connection = connection;
	}

	public List<Magazine> AllMagazines() throws Exception {
		
		List<Magazine> mag = new ArrayList<Magazine>();
		preparedStatement = connection.prepareStatement(READ_ALL_LIST);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			float price = result.getInt("price");
			mag.add(new Magazine(id, name, price));
		}
		return mag;
	}

	public void printAllMagazines() throws Exception {
		AllMagazines().stream().forEach(System.out::println);
	}

	public List<User> AllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		preparedStatement = connection.prepareStatement(READ_ALL_USER);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			int id = result.getInt("id_user");
			String name = result.getString("username");
			String subscribe = result.getString("subscribes");
			users.add(new User(id, name, subscribe));

		}
		return users;
	}

	public void printAllUsers() throws Exception {
		AllUsers().forEach(System.out::println);
	}

	public List<User> showFullSubscribes() throws Exception {
		List<User> temporary = AllUsers();
		temporary.forEach(u -> {
			u.toIntList(u.getSub());
			u.setSub("");
			u.getSubscribes().forEach(s -> {

				try {
					u.setSub(u.getSub() + AllMagazines().get(s - 1) + "\n");

				} catch (Exception e) {

					e.printStackTrace();
				}
			});

		});
		return temporary;
	}

	public void newUser(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(NEW_USER);
		preparedStatement.setString(1, user.getUser_name());
		preparedStatement.setString(2, user.getSub());
		preparedStatement.executeUpdate();
	}

	public void newPayment(User user,Magazine mag ) throws SQLException {
		preparedStatement = connection.prepareStatement(NEW_PAYMENT);
		preparedStatement.setString(1, user.getUser_name());
		preparedStatement.setString(2, mag.toString());
		preparedStatement.setFloat(3, mag.getPrice());
		preparedStatement.executeUpdate();
	}
	public void newPaymentById(int us, int mag ) throws Exception {
		newPayment(AllUsers().get(us),AllMagazines().get(mag));
	}
	public void deleteUser(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

}