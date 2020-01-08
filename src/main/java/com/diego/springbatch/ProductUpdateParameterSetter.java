package com.diego.springbatch;

import com.diego.springbatch.model.Prodotto;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateParameterSetter implements ItemPreparedStatementSetter<Prodotto> {

    public void setValues(Prodotto result, PreparedStatement ps) throws SQLException {

        ps.setBoolean(1, result.getState());

    }
}
