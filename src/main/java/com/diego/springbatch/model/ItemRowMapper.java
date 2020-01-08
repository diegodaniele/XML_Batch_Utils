package com.diego.springbatch.model;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ItemRowMapper implements RowMapper<Prodotto> {

    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Prodotto p = new Prodotto();
        p.setProductName(rs.getString("product_name"));
        p.setPrice(rs.getDouble("price"));
        p.setState(rs.getBoolean("state"));
        p.setDescription(rs.getString("description"));
        p.setQuantity(rs.getInt("quantity"));
        return p;
    }
}
