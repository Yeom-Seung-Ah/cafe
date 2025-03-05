package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Repository
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;

	public List<Product> getAllProducts() throws Exception{
		Class.forName(DB_DRIVER);
		String url = DB_URL;
		String user = DB_USER;
		String pw = DB_PW;
		
		String sql="select * from product";
		try(
			Connection con = DriverManager.getConnection(url, user, pw);
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				){
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				int prodcode = rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				String pimg = rs.getString("pimg");
				int price = rs.getInt("price");
				
				list.add(new Product(prodcode, price, prodname, pimg));
			}
			return list;
		}
		
	}
}
