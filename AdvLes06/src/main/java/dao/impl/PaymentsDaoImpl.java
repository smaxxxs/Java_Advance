package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import dao.PaymentsDao;
import dao.UserDao;
import domain.Payments;
import utils.ConnectionUtils;

public class PaymentsDaoImpl implements PaymentsDao{
	static String CREATE = "insert into payments(id_payment,date,username,description,sum) values (?,?,?,?,?)";
	static String READ_ALL = "select * from payments";
	private static String READ_BY_ID = "select * from payments where id =?";
	private static String DELETE_BY_ID = "delete from payments where id=?";
	
	private final static Logger LOG = Logger.getLogger(UserDao.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public PaymentsDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}
	@Override
	public Payments create(Payments t) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, t.getId_payment());
			preparedStatement.setDate(2,  new Date(t.getDate().getTime()));
			preparedStatement.setString(3, t.getName());
			preparedStatement.setString(4, t.getDescription());
			preparedStatement.setFloat(5, t.getSum());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId_payment(rs.getInt(1));
		} catch (SQLException e) {
			LOG.error(e);
		}

		return t;
	}

	@Override
	public Payments read(Integer id) {
		Payments payment = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			Integer id_payment = result.getInt("id_payment");
			java.util.Date date = result.getDate("date");
			String user = result.getString("username");
			String description = result.getString("description");
			Float sum = result.getFloat("sum");
			
			payment = new Payments(id_payment, date, user, description,sum);

		} catch (SQLException e) {
			LOG.error(e);
		}

		return payment;
	}
	@Override
	public Payments update(Payments t) {
		throw new IllegalStateException("there is no update for payment");
		
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e);
		}
	}

	@Override
	public List<Payments> readAll() {
		List <Payments> payments = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer id_payment = result.getInt("id_payment");
				java.util.Date date = result.getDate("date");
				String user = result.getString("username");
				String description = result.getString("description");
				Float sum = result.getFloat("sum");
				
				payments.add(new Payments(id_payment, date, user, description,sum));
			}
		} catch (SQLException e) {
			LOG.error(e);
		}
		return payments;
	}

}
