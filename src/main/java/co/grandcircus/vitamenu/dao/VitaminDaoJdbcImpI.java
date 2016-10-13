package co.grandcircus.vitamenu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import co.grandcircus.vitamenu.model.Vitamin;



@Repository
@Primary
public class VitaminDaoJdbcImpI implements VitaminDao{
	
	private static final Logger logger = LoggerFactory.getLogger(VitaminDao.class);
	
	@Autowired
	JdbcConnectionFactory connectionFactory;

	@Override
	public List<Vitamin> getAllVitamins() {
		String sql = "SELECT * FROM vitamenu.vitamin_info";
		try (Connection connection = connectionFactory.getConnection();
				Statement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery(sql);

			List<Vitamin> vitamin = new ArrayList<Vitamin>();
			while (result.next()) {
				String vitLetter = result.getString("vitamin_letter");
				 String vitName = result.getString("vitamin_name");
				 String vitBenefit = result.getString("vitamin_benefits");
				 String vitIntake = result.getString("vitamin_recommenedintake");

				vitamin.add(new Vitamin(vitLetter, vitName, vitBenefit, vitIntake));
			}

			return vitamin;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}


	@Override
	public List<Vitamin> getAllVitaminsSortedBy(String sort) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
}