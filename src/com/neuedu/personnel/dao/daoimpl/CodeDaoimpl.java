package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.dao.CodeDao;
import com.neuedu.personnel.utils.DButil;

public class CodeDaoimpl implements CodeDao {

	@Override
	public List<Code> findByType(Integer id) {
		
		List<Code> coldlist =new ArrayList<Code>();
		Connection conn =DButil.getconn();
		PreparedStatement ps =null;
		ResultSet rs =null;
		String sql=" select * from code where type_id= ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Code code =new Code();
				code.setId(rs.getInt("id"));
				code.setCode_value(rs.getString("code_value"));
				code.setType_id(rs.getInt("type_id"));
				code.setCode_name(rs.getString("code_name"));
				coldlist.add(code);
//				System.out.println(code.getId());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		return coldlist;
	
		
	}

}
