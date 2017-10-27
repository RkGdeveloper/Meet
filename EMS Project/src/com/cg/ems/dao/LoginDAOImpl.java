package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.dbconfig.DbUtil;

public class LoginDAOImpl implements ILoginDAO{

	@Override
	public int validateLogin(LoginDetailsBean loginDetails) {
		try {
			System.out.println(loginDetails);
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select login_id from login_details where login_username = ? AND login_password = ? AND login_role = ?");
			pst.setString(1, loginDetails.getUserName());
			pst.setString(2, loginDetails.getPassword());
			pst.setString(3, loginDetails.getRole());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				System.out.println("Login id is "+rs.getInt(1));
				return 1;
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
