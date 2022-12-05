package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.DeptDao;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;

public class DeptDaoimpl implements DeptDao {

	/*
	 * 添加
	 */
	@Override
	public void insertDept(Dept dept) {
			Connection conn = DButil.getconn();
			PreparedStatement ps = null;
			String sql = "insert into dept (dept_number,dept_name,dept_type,dept_tel,dept_fax,dept_super,dept_desc,dept_setdate,situation) values(?,?,?,?,?,?,?,?,0)";
			try {
				
				System.out.println(dept.getDept_number());
				System.out.println(dept.getDept_super().getId());
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dept.getDept_number());
				ps.setString(2, dept.getDept_name());
				ps.setInt(3, dept.getDept_type());
				ps.setString(4, dept.getDept_tel());
				ps.setString(5, dept.getDept_fax());
				ps.setInt(6, dept.getDept_super().getId());
				ps.setString(7, dept.getDept_desc());
				ps.setDate(8, new java.sql.Date (dept.getDept_setdate().getTime()));
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DButil.close(ps);
				DButil.close(conn);
		}

	}
	 
	/*
	  * 判断删除时，有没有上级部门
	  */	 
	@Override
	public int DeleteDept(Integer id) {
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int boo=0;
		String sql=" SELECT count(*)" + 
				" from dept d ,dept p" + 
				" WHERE p.dept_super=d.id and d.id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				boo=rs.getInt("count(*)");
			}
//			System.out.println("123");
//			System.out.println(boo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.close(ps);
			DButil.close(conn);
		}
		return boo;
	}
	
	/*
	  * 删除 
	  */	
	@Override
	public void DeleteDate(Integer id) {

		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		String sql="update dept set situation=1 where id= ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButil.close(ps);
			DButil.close(conn);
		}
		
	}

	/*
	  * 修改
	  */
	@Override
	public void UpdateDept(Dept dept, Integer id) {
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("update dept set dept_number=?,dept_name=?,dept_type=?,"
		                     +"dept_tel=?,dept_fax=?,dept_super=?,dept_desc=?,"
				             +"dept_setdate=?"
		                     +" where id=?");
//		System.out.println(sql.toString());
		try {
			System.out.println(123456);
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, dept.getDept_number());
			ps.setString(2, dept.getDept_name());
			ps.setInt(3, dept.getDept_type());
			if(!StringUtil.isNull(dept.getDept_tel())) {
				ps.setString(4, dept.getDept_tel());
			}else {
				ps.setObject(4, 0);
			}
			
			ps.setString(5, dept.getDept_fax());
			if(!StringUtil.isNull(dept.getDept_super().getId())) {
				ps.setInt(6, dept.getDept_super().getId());
			}else {
				ps.setObject(6, null);
			}
			System.out.println(dept.getDept_super().getId());
			ps.setString(7,dept.getDept_desc());
			ps.setDate(8, new java.sql.Date (dept.getDept_setdate().getTime()));
			ps.setInt(9, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.close(ps);
			DButil.close(conn);
		}
		}
	
	/* 
	 * 查询所有(用户的)
	 */
	@Override
	public List<Dept> findAllDept() {
		List<Dept> deptlist = new ArrayList<Dept>();
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("select"+
			" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"+
               " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"+
	           " d.dept_setdate d_dept_setdate,d.situation d_situation,"+
	           " p.id p_id,p.dept_number p_dept_number,p.dept_name p_dept_name,p.dept_type p_dept_type,"+
               " p.dept_tel p_dept_tel,p.dept_fax p_dept_fax,p.dept_super p_dept_super,p.dept_desc p_dept_desc,"+
	           " p.dept_setdate p_dept_setdate,p.situation p_situation,"+
               " c.id c_id,c.code_name c_code_name,c.type_id c_type_id,c.code_value c_code_value"+
	           " from dept d"+
	           " left join dept p"+
	           " on d.dept_super=p.id"+
	           " left join code c"+
	           " on d.dept_type=c.id"+
			   " where d.situation=0 "  );
//		if(!StringUtil.isNull(dept.getDept_number())) {
//			sql.append(" and d.dept_number="+dept.getDept_number()+"");
//		}
//		if(!StringUtil.isNull(dept.getDept_name())) {
//			sql.append(" and d.dept_name="+dept.getDept_name()+"");
//		}
//		if(!StringUtil.isNull(dept.getDept_type())) {
//			sql.append(" and d.dept_type="+dept.getDept_type()+"");
//		}
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				 Dept d=new Dept();
				 Dept p=new Dept();
				 Code c=new Code();
				 d.setId(rs.getInt("d_id"));
				 d.setDept_number(rs.getInt("d_dept_number"));
				 d.setDept_name(rs.getString("d_dept_name"));
				 d.setDept_type(rs.getInt("d_dept_type"));
				 d.setDept_tel(rs.getString("d_dept_tel"));
				 d.setDept_fax(rs.getString("d_dept_fax"));
				 d.setDept_desc(rs.getString("d_dept_desc"));
				 d.setDept_setdate(rs.getDate("d_dept_setdate"));
				 d.setSituation(rs.getInt("d_situation"));
				 
				 
				 p.setId(rs.getInt("p_id"));
				 p.setDept_number(rs.getInt("p_dept_number"));
				 p.setDept_name(rs.getString("p_dept_name"));
				 p.setDept_type(rs.getInt("p_dept_type"));
				 p.setDept_tel(rs.getString("p_dept_tel"));
				 p.setDept_fax(rs.getString("p_dept_fax"));
				 p.setDept_desc(rs.getString("p_dept_desc"));
				 p.setDept_setdate(rs.getDate("p_dept_setdate"));
				 p.setSituation(rs.getInt("p_situation"));
				 
				 c.setCode_value(rs.getString("c_code_value"));
			
				 d.setDept_super(p);
				 d.setCode_type(c);
				 deptlist.add(d);
				 System.out.println(deptlist.get(0).getCode_type().getCode_value());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		return deptlist;

	}

	/*
	  * 查询所有(数据库的)
	  */
	@Override
	public List<Dept> findAllD() {
		List<Dept> deptlist = new ArrayList<Dept>();
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer("select"+
			" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"+
               " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"+
	           " d.dept_setdate d_dept_setdate,d.situation d_situation,"+
	           " p.id p_id,p.dept_number p_dept_number,p.dept_name p_dept_name,p.dept_type p_dept_type,"+
               " p.dept_tel p_dept_tel,p.dept_fax p_dept_fax,p.dept_super p_dept_super,p.dept_desc p_dept_desc,"+
	           " p.dept_setdate p_dept_setdate,p.situation p_situation,"+
               " c.id c_id,c.code_name c_code_name,c.type_id c_type_id,c.code_value c_code_value"+
	           " from dept d"+
	           " left join dept p"+
	           " on d.dept_super=p.id"+
	           " left join code c"+
	           " on d.dept_type=c.id"  );
//		if(!StringUtil.isNull(dept.getDept_number())) {
//			sql.append(" and d.dept_number="+dept.getDept_number()+"");
//		}
//		if(!StringUtil.isNull(dept.getDept_name())) {
//			sql.append(" and d.dept_name="+dept.getDept_name()+"");
//		}
//		if(!StringUtil.isNull(dept.getDept_type())) {
//			sql.append(" and d.dept_type="+dept.getDept_type()+"");
//		}
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				 Dept d=new Dept();
				 Dept p=new Dept();
				 Code c=new Code();
				 d.setId(rs.getInt("d_id"));
				 d.setDept_number(rs.getInt("d_dept_number"));
				 d.setDept_name(rs.getString("d_dept_name"));
				 d.setDept_type(rs.getInt("d_dept_type"));
				 d.setDept_tel(rs.getString("d_dept_tel"));
				 d.setDept_fax(rs.getString("d_dept_fax"));
				 d.setDept_desc(rs.getString("d_dept_desc"));
				 d.setDept_setdate(rs.getDate("d_dept_setdate"));
				 d.setSituation(rs.getInt("d_situation"));
				 
				 
				 p.setId(rs.getInt("p_id"));
				 p.setDept_number(rs.getInt("p_dept_number"));
				 p.setDept_name(rs.getString("p_dept_name"));
				 p.setDept_type(rs.getInt("p_dept_type"));
				 p.setDept_tel(rs.getString("p_dept_tel"));
				 p.setDept_fax(rs.getString("p_dept_fax"));
				 p.setDept_desc(rs.getString("p_dept_desc"));
				 p.setDept_setdate(rs.getDate("p_dept_setdate"));
				 p.setSituation(rs.getInt("p_situation"));
				 
				 c.setCode_value(rs.getString("c_code_value"));
			
				 d.setDept_super(p);
				 d.setCode_type(c);
				 deptlist.add(d);
				 System.out.println(deptlist.get(0).getCode_type().getCode_value());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		return deptlist;

	}

	 /*
	  * 按id查询岗位
	  */
	@Override
	public List<Dept> findByDept(Integer id) {

		List<Dept> deptlist = new ArrayList<Dept>();
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select"+
				" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"+
	               " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"+
		            "  d.dept_setdate d_dept_setdate,d.situation d_situation,"+
		          "   p.id p_id,p.dept_number p_dept_number,p.dept_name p_dept_name,p.dept_type p_dept_type,"+
	               " p.dept_tel p_dept_tel,p.dept_fax p_dept_fax,p.dept_super p_dept_super,p.dept_desc p_dept_desc,"+
		           "   p.dept_setdate p_dept_setdate,p.situation p_situation,"+
	                " c.id c_id,c.code_name c_code_name,c.type_id c_type_id,c.code_value c_code_value"+
		           "  from dept d"+
	              "  left join dept p"+
		           " on d.dept_super=p.id"+
	            " left join code c"+
		             " on d.dept_type=c.id"+
	              " where d.situation=0 and d.id=?" ; 
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				 Dept d=new Dept();
				 Dept p = new Dept();
				 Code c=new Code();
				 d.setId(rs.getInt("d_id"));
				 d.setDept_number(rs.getInt("d_dept_number"));
				 d.setDept_name(rs.getString("d_dept_name"));
				 d.setDept_type(rs.getInt("d_dept_type"));
				 d.setDept_tel(rs.getString("d_dept_tel"));
				 d.setDept_fax(rs.getString("d_dept_fax"));
				 d.setDept_desc(rs.getString("d_dept_desc"));
				 d.setDept_setdate(rs.getDate("d_dept_setdate"));
				 d.setSituation(rs.getInt("d_situation"));
				 
				 p.setId(rs.getInt("p_id"));
				 p.setDept_number(rs.getInt("p_dept_number"));
				 p.setDept_name(rs.getString("p_dept_name"));
				 p.setDept_type(rs.getInt("p_dept_type"));
				 p.setDept_tel(rs.getString("p_dept_tel"));
				 p.setDept_fax(rs.getString("p_dept_fax"));
				 p.setDept_desc(rs.getString("p_dept_desc"));
				 p.setDept_setdate(rs.getDate("p_dept_setdate"));
				 p.setSituation(rs.getInt("p_situation"));
				 
				 d.setDept_super(p);
				 d.setCode_type(c);
				 deptlist.add(d);
				 
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		return deptlist;
	}

	/* 条件查询 */
	@Override
	public List<Dept> findDeptIf(Dept dept) {
		List<Dept> deptlist =new ArrayList<Dept>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		StringBuffer sql = new StringBuffer("select"+
				" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"+
	               " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"+
		            "  d.dept_setdate d_dept_setdate,d.situation d_situation,"+
		          "   p.id p_id,p.dept_number p_dept_number,p.dept_name p_dept_name,p.dept_type p_dept_type,"+
	               " p.dept_tel p_dept_tel,p.dept_fax p_dept_fax,p.dept_super p_dept_super,p.dept_desc p_dept_desc,"+
		           "   p.dept_setdate p_dept_setdate,p.situation p_situation,"+
	                " c.id c_id,c.code_name c_code_name,c.type_id c_type_id,c.code_value c_code_value"+
		           "  from dept d"+
	              "  left join dept p"+
		           " on d.dept_super=p.id"+
	            " left join code c"+
		             " on d.dept_type=c.id"+
	              " where d.situation=0 "  );
		if(dept.getDept_number() != null && dept.getDept_number() != 0) {
			sql.append(" and d.dept_number=?");
		}
		if(dept.getDept_name()!=null && !"".equals(dept.getDept_name())) {
			sql.append(" and d.dept_name=?");
		}
		if(dept.getDept_type()!=0) {
			sql.append(" and d.dept_type=?");
		}
		System.out.println(000);
		try {
			ps=conn.prepareStatement(sql.toString());
			int count = 1;
			if(dept.getDept_number() != null &&  dept.getDept_number() != 0) {
				ps.setInt(count, dept.getDept_number());
				count++;
			}
			if(dept.getDept_name()!=null && !"".equals(dept.getDept_name())) {
				ps.setString(count, dept.getDept_name());
				count++;
			}
			if(dept.getDept_type()!=0) {
				ps.setInt(count,dept.getDept_type());
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(111);
				Dept d = new Dept ();
				Dept p = new Dept ();
				
				Code c=new Code();
				d.setId(rs.getInt("d_id"));
				d.setDept_number(rs.getInt("d_dept_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				d.setDept_type(rs.getInt("d_dept_type"));
				d.setDept_tel(rs.getString("d_dept_tel"));
				d.setDept_fax(rs.getString("d_dept_fax"));
				d.setDept_desc(rs.getString("d_dept_desc"));
				d.setDept_setdate(rs.getDate("d_dept_setdate"));
				d.setSituation(rs.getInt("d_situation"));
				p.setId(rs.getInt("d_dept_super"));
				p.setDept_name(rs.getString("p_dept_name"));
				
				c.setCode_value(rs.getString("c_code_value"));
				d.setCode_type(c);
				d.setDept_super(p);
				
				
				
				deptlist.add(d);
				//System.out.println(deptlist.get(0).getDept_super().getDept_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		
		
		return deptlist;
	}
	
	
}
