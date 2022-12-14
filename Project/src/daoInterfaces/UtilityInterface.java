package daoInterfaces;

import java.sql.SQLException;

import ems.AbstractClassEms;

public interface UtilityInterface {
	void refreshRecords() throws SQLException;

	void getAll() throws SQLException;

	<T extends AbstractClassEms> T get(int id) throws SQLException;

}
