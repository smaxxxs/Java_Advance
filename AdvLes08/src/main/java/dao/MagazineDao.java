package dao;

import java.util.List;

import domain.Magazine;
import shared.CRUD;

public interface MagazineDao extends CRUD <Magazine> {

	List<Magazine> readAll();

}
