package net.atos.animals.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class CuidadorIdGenerator implements IdentifierGenerator {
	
	private final static String PREFIX = "ZO";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select max(vc_matricula) as Id from cuidador");

			if (rs.next()) {
				int id = rs.getInt(1) + 101;				
				String generatedId = PREFIX + StringUtils.leftPad(String.valueOf(id), 3, "0");

				return generatedId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
