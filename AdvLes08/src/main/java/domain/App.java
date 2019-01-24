package domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import service.Impl.MagazineServiceImpl;
import service.Impl.PaymentsServiceImpl;
import service.Impl.UserServiceImpl;

public class App {
	private final static Logger LOG = Logger.getLogger(App.class);
	
    public static void main( String[] args ) throws Exception
    
    {	LOG.debug("START");
    	Date date = new Date();
    	DOMConfigurator.configure("LogerConfig.xml");
    	UserServiceImpl userDao = new UserServiceImpl();
    	MagazineServiceImpl magazineDao = new MagazineServiceImpl();
    	PaymentsServiceImpl paymentsDao = new PaymentsServiceImpl();
    	
    	List<Magazine> mag = magazineDao.readAll();
    	mag.forEach(System.out::println);
    	List<User> userList = Arrays.asList(
    			new User("2pac","2","wer"),
    			new User("IceCube","1","sdfasdfd"), 
    			new User("Eminem","2","sdfsd"));
    	userList.forEach(u -> {
			userDao.create(u);
		});
    	List<User> usersList = userDao.showFullSubscribes();
    	userDao.printAllUsers();
    	paymentsDao.readAll().forEach(System.out::println);
    	paymentsDao.create(new Payments(date,userDao.readAll().get(2).getUser_name(), magazineDao.readAll().get(2).getName(),magazineDao.readAll().get(2).getPrice()));
    	paymentsDao.create(new Payments(date,"css","Auto",400));
    	userDao.delete(1);
        System.out.println(usersList);
    }
}
