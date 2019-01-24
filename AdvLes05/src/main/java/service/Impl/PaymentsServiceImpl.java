package service.Impl;

import java.sql.SQLException;
import java.util.List;


import dao.impl.PaymentsDaoImpl;
import domain.Payments;
import service.PaymentsService;

public class PaymentsServiceImpl implements PaymentsService {
	PaymentsDaoImpl paymentsDao;

	
	public PaymentsServiceImpl() {
		
		try {
			paymentsDao = new PaymentsDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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

}
