package service.Impl;

import java.sql.SQLException;
import java.util.List;
import dao.impl.MagazineDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Magazine;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	private UserDaoImpl userDao;

	public UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User create(User t) {

		return userDao.create(t);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User t) {
		return userDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
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

