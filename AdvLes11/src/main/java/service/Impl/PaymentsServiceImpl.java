package service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.UserDao;
import dao.impl.PaymentsDaoImpl;
import domain.Payments;
import service.PaymentsService;

public class PaymentsServiceImpl implements PaymentsService {
	PaymentsDaoImpl paymentsDao;

	private final static Logger LOG = Logger.getLogger(UserDao.class);
	
	public PaymentsServiceImpl() {
		
		try {
			paymentsDao = new PaymentsDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}

	@Override
	public Payments create(Payments t) {

		return paymentsDao.create(t);
	}

	@Override
	public Payments read(Integer id) {

		return paymentsDao.read(id);
	}

	@Override
	public Payments update(Payments t) {

		return paymentsDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		paymentsDao.delete(id);

	}

	@Override
	public List<Payments> readAll() {

		return paymentsDao.readAll();
	}
	
	public List<Payments> userPayments(String name) {

		return paymentsDao.userPayments(name);
	}
}
