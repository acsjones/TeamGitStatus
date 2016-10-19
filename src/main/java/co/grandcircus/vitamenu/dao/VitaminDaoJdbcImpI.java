package co.grandcircus.vitamenu.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import co.grandcircus.vitamenu.exception.NotFoundException;
import co.grandcircus.vitamenu.model.Vitamin;

@Repository
@Primary
public class VitaminDaoJdbcImpI implements VitaminDao{
	
private static final Logger logger = LoggerFactory.getLogger(VitaminDao.class);
	
	@Autowired
	JdbcConnectionFactory connectionFactory;

	@Override
	public List<Vitamin> getAllVitamins() {
		String sql = "SELECT * FROM ebdb.vitamenu2";
		try (Connection connection = connectionFactory.getConnection();
				Statement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery(sql);

			List<Vitamin> vitamins = new ArrayList<Vitamin>();
			while (result.next()) {
				Integer vitamin_key = result.getInt("vitamin_key");
				String vitamin_letter = result.getString("vitamin_letter");
				 String vitamin_name = result.getString("vitamin_name");
		

				 vitamins.add(new Vitamin(vitamin_key, vitamin_letter, vitamin_name));
			}

			return vitamins;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Vitamin> getAllVitaminsSortedBy(String sort) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vitamin getVitamin(int vitamin_key) throws NotFoundException {
		String sql = "SELECT * FROM ebdb.vitamenu2 WHERE vitamin_key = ?";
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, vitamin_key);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				String vitamin_benefits = result.getString("vitamin_benefits");
				String vitamin_defiency = result.getString("vitamin_defiency");
				String vitamin_name = result.getString("vitamin_name");
				String vitamin_letter = result.getString("vitamin_letter");
				String food_1 = result.getString("food_1");
				String food_2 = result.getString("food_2");
				String food_3 = result.getString("food_3");
				String food_4 = result.getString("food_4");
				String food_5 = result.getString("food_5");
				String food_6 = result.getString("food_6");
				String food_7 = result.getString("food_7");

				return new Vitamin(vitamin_key, vitamin_letter, vitamin_benefits, vitamin_defiency, vitamin_name, food_1, food_2, food_3,food_4,food_5,food_6,food_7);
			} else {
				throw new NotFoundException("No such vitamin.");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void addFoodItem(String vname, String food) {
		Vitamin vitamin = new Vitamin();
		vitamin.setVitamin_name(vname);
		vitamin.setFood_6(food);
		//vitamin.setFood_7(food);
		System.out.println(vitamin.getVitamin_name());
		System.out.println(vitamin.getFood_6());
		//System.out.println(vitamin.getFood_7());
		String sql = "UPDATE  vitamenu2 SET food_6=? WHERE vitamin_name= ?";
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			statement.setString(1,vitamin.getFood_6());
			//statement.setString(2,vitamin.getFood_7());
			//statement.setString(2,vitamin.getFood_8());
			statement.setString(2,vitamin.getVitamin_name());
		
			int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated != 1) {
                throw new NotFoundException("No such mentor");
                
               
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
			
	}

	
}