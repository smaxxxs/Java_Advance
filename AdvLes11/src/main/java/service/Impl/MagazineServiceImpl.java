package service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.MagazineDao;
import dao.UserDao;
import dao.impl.MagazineDaoImpl;
import domain.Magazine;
import service.MagazineService;

//other commit
public class MagazineServiceImpl  implements MagazineService {

	private MagazineDao magazineDao;
	
	private final static Logger LOG = Logger.getLogger(UserDao.class);
	
	public MagazineServiceImpl() {
		try {
			magazineDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		
			LOG.error(e);
		}

	}

	@Override
	public Magazine create(Magazine t) {
		return magazineDao.create(t);
	}

	@Override
	public Magazine read(Integer id) {
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine t) {
		return magazineDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDao.readAll();
	}

}
