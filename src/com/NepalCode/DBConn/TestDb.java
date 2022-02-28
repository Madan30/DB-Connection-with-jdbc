package com.NepalCode.DBConn;

import java.sql.SQLException;

public class TestDb {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		LbefDao lbef = new LbefDao();
		lbef.selectAllRow();
		
		//lbef.deleteLbefData(0);
	}

}
