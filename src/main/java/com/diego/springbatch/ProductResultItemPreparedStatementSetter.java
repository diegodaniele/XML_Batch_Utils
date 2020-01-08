package com.diego.springbatch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.diego.springbatch.model.Prodotto;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class ProductResultItemPreparedStatementSetter implements ItemPreparedStatementSetter<Prodotto> {

	public void setValues(Prodotto result, PreparedStatement ps) throws SQLException {
		ps.setString(1, result.getProductName());
		ps.setDouble(2, result.getPrice());
		ps.setBoolean(3, result.getState());
		ps.setString(4, result.getDescription());
		ps.setInt(5, result.getQuantity());
	}

}