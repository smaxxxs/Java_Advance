package dvLes02;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class App {
	
    public static void main( String[] args ) throws Exception
    {
    	Dao dao = new Dao(ConnectionUtils.openConnection());
    	
    	dao.printAllMagazines();
    	List<User> userList = Arrays.asList(
    			new User("2pac","2"),
    			new User("IceCube","1"), 
    			new User("Eminem","2"));
    	userList.forEach(u -> {
			try {
				dao.newUser(u);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
    	List<User> usersList = dao.showFullSubscribes();
        dao.printAllUsers();
        dao.newPayment(dao.AllUsers().get(2), dao.AllMagazines().get(2));
        dao.newPaymentById(1, 3);
        dao.deleteUser(1);
        System.out.println(usersList);
    }
}
