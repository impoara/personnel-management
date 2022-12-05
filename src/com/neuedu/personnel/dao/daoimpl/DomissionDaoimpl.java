package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.DomissionDao;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;

public class DomissionDaoimpl implements DomissionDao {


	/* 添加离职表 */
	@Override
	public void domInsert(Domission dom) {
		Connection conn = DButil.getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("INSERT into domission" + 
				" (em_id ,lz_type ,lz_date ,lz_go)" + 
				" VALUES (? , ? ,? ,?)");	
		System.out.println(sql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
		
			if(!StringUtil.isNull(dom.getId())) {
				ps.setInt(1, dom.getId());
			}
			if(!StringUtil.isNull(dom.getLz_type())) {
				ps.setInt(2, dom.getLz_type());
			}
			if(dom.getLz_date() != null) {
				ps.setDate(3, new java.sql.Date(dom.getLz_date() .getTime()));
			}
			if(!StringUtil.isNull(dom.getLz_go())) {
				ps.setString(4, dom.getLz_go());
			}else {
				ps.setObject(4, "无");
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			DButil.close(ps);
			DButil.close(conn);
		}
	}

	 /* 查询在职所有 */
	@Override
	public List<Employee> finAllEmp() {
		List<Employee> domList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		String sql = "select e.*," 
				+" j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+" j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+" d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+" d.dept_setdate d_dept_setdate,d.situation d_situation,"
				+" c.code_name,c.code_value,c.id,c.type_id"
				+" from employee e "
			    +" left JOIN dept d on e.dep_number=d.dept_number "
			    +" left join job j on j.job_number=e.job_number "
	            +" LEFT JOIN code c ON j.job_type=c.id "
			    +" where e.situation=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {						
				Employee e=new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setEm_number(rs.getInt("e.em_number"));
				e.setId(rs.getInt("e.id"));
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				d.setId(rs.getInt("d_id"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setSex(rs.getInt("e.sex"));
				
				e.setDept(d);
				e.setJob(j);
				domList.add(e);
								
//				domission.setId(rs.getInt("dom.id"));
//				domission.setLz_type(rs.getInt("dom.lz_type"));
//				domission.setLz_date(rs.getDate("dom.lz_date"));
//				domission.setLz_go(rs.getString("dom.lz_go"));
//				
//				e.setEm_id(rs.getString("e.em_id"));
	
//				d.setId(rs.getInt("d_id"));
//				d.setDept_number( rs.getInt("d_dept_number"));
//				d.setDept_name(rs.getString( "d_dept_name" ));
//				d.setDept_type(rs.getInt("d_dept_type"));
//				d.setDept_tel(rs.getString( "d_dept_tel"));
//				d.setDept_fax(rs.getString("d_dept_fax"));
//				d.setDept_desc (rs.getString( "d_dept_desc" ) );
//				d.setDept_setdate(rs.getDate( "d_dept_setDate" ));
//				d.setSituation(rs.getInt( "d_situation")) ;
//				
//				j.setId(rs.getInt("j_id"));
//				j.setJob_number(rs.getInt("j_job_number"));
//				j.setJob_name(rs.getString("j_job_name"));
//				j.setJob_type(rs.getInt("j_job_type"));
//				j.setJob_max(rs.getInt("j_job_max"));
//				j.setJob_man(rs.getInt("j_job_man"));
//				j.setSituation(rs.getInt("j_situation"));
//				j.setJob_type_name(rs.getString("j_job_type_name"));
				
			
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return domList;

	}

	/* 按id查询，回显 */
	@Override
	public Employee findnumberEmp(Integer id) {
		
		Connection conn = DButil.getconn();
		String sql = "select e.*," 
				+" j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+" j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+" d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+" d.dept_setdate d_dept_setdate,d.situation d_situation,"
				+" c.code_name,c.code_value,c.id,c.type_id"
				+" from employee e "
			    +" left JOIN dept d on e.dep_number=d.dept_number "
			    +" left join job j on j.job_number=e.job_number "
	            +" LEFT JOIN code c ON j.job_type=c.id "
			    +" where e.situation=0 and e.id= ? ";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee e1=new Employee();
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {						
				
				Dept d = new Dept();
				Job j = new Job();
				
				e1.setId(rs.getInt("e.id"));
				e1.setEm_number(rs.getInt("e.em_number"));
				d.setDept_number(rs.getInt("e.dep_number"));
				if(rs.getString("d_dept_name")!=null) {
					d.setDept_name(rs.getString("d_dept_name"));
				}
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e1.setEm_name(rs.getString("e.em_name"));
				e1.setSex(rs.getInt("e.sex"));
				
				e1.setDept(d);
				e1.setJob(j);
			
				
				
//				domission.setId(rs.getInt("dom.id"));
//				domission.setLz_type(rs.getInt("dom.lz_type"));
//				domission.setLz_date(rs.getDate("dom.lz_date"));
//				domission.setLz_go(rs.getString("dom.lz_go"));
//				
//				e.setEm_id(rs.getString("e.em_id"));
	
//				d.setId(rs.getInt("d_id"));
//				d.setDept_number( rs.getInt("d_dept_number"));
//				d.setDept_name(rs.getString( "d_dept_name" ));
//				d.setDept_type(rs.getInt("d_dept_type"));
//				d.setDept_tel(rs.getString( "d_dept_tel"));
//				d.setDept_fax(rs.getString("d_dept_fax"));
//				d.setDept_desc (rs.getString( "d_dept_desc" ) );
//				d.setDept_setdate(rs.getDate( "d_dept_setDate" ));
//				d.setSituation(rs.getInt( "d_situation")) ;
//				
//				j.setId(rs.getInt("j_id"));
//				j.setJob_number(rs.getInt("j_job_number"));
//				j.setJob_name(rs.getString("j_job_name"));
//				j.setJob_type(rs.getInt("j_job_type"));
//				j.setJob_max(rs.getInt("j_job_max"));
//				j.setJob_man(rs.getInt("j_job_man"));
//				j.setSituation(rs.getInt("j_situation"));
//				j.setJob_type_name(rs.getString("j_job_type_name"));
				
			
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return e1;
	}

	/* 修改 */
	@Override
	public void domUpdate(Integer id) {
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("UPDATE employee "+
				" SET situation = 1 "+
				" WHERE id=? ");
		System.out.println(sql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1,id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.close(ps);
			DButil.close(conn);
		}
	}


	//显示所有离职人员
	@Override
	public List<Domission> finAllDom() {
		List<Domission> domList = new ArrayList<Domission>();
		Connection conn = DButil.getconn();
		String sql = "SELECT m.*,e.*,e.id e_id,e.em_id e_em_id,"
				+" c1.id c1_id,c1.code_value c1_code_value,c1.type_id c1_type_id,c1.code_name c1_code_name,"
				+" c2.id c2_id,c2.code_value c2_code_value,c2.type_id c2_type_id,c2.code_name c2_code_name,"
				+" j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
			    +" j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,"
				+" d.dept_type d_dept_type,d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,"
				+" d.dept_super d_dept_super,d.dept_desc d_dept_desc, "
				+" d.dept_setdate d_dept_setdate,d.situation d_situation"
				+" from domission m "
				+" left JOIN employee e "
				+" on e.id=m.em_id "
				+" left JOIN code c1 "
				+" ON c1.id=m.lz_type "
				+" left JOIN code c2 "
				+" on c2.id=e.sex"
				+" left JOIN dept d"
				+" on e.dep_number=d.dept_number "
				+" left join job j"
				+" on e.job_number=j.job_number";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {		
				Domission dom=new Domission();
				Employee e=new Employee();
				Dept d = new Dept();
				Job j = new Job();
				Code c = new Code();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setSex(rs.getInt("e.sex"));
				dom.setLz_type(rs.getInt("m.lz_type"));
//				System.out.println(e.getId());
				
				c.setCode_value(rs.getString("c1_code_value"));
				
				dom.setCode(c);
				e.setDept(d);
				e.setJob(j);
				dom.setEmp(e);
				domList.add(dom);
				

			
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return domList;
	}
	
	/*
	 * 离职人员的条件查询
	 */
	@Override
	public List<Domission> lizhiFind(Domission dom) {


		List<Domission> domList = new ArrayList<Domission>();
		Connection conn = DButil.getconn();
		
		StringBuffer sql = new StringBuffer("SELECT m.*,e.*,e.id e_id,e.em_id e_em_id,"
				+" c1.id c1_id,c1.code_value c1_code_value,c1.type_id c1_type_id,c1.code_name c1_code_name,"
				+" c2.id c2_id,c2.code_value c2_code_value,c2.type_id c2_type_id,c2.code_name c2_code_name,"
				+" j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
			    +" j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,"
				+" d.dept_type d_dept_type,d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,"
				+" d.dept_super d_dept_super,d.dept_desc d_dept_desc, "
				+" d.dept_setdate d_dept_setdate,d.situation d_situation"
				+" from domission m "
				+" left JOIN employee e on e.id=m.em_id "
				+" left JOIN code c1 ON c1.id=m.lz_type "
				+" left JOIN code c2 on c2.id=e.sex"
				+" left JOIN dept d on e.dep_number=d.dept_number "
				+" left join job j on e.job_number=j.job_number"
				+" where e.situation=1");
		if (!StringUtil.isNull(dom.getEmp().getEm_number())) {
			sql.append(" and e.em_number=" + dom.getEmp().getEm_number() + "");
		}
		if (!StringUtil.isNull(dom.getEmp().getEm_name())) {
			sql.append(" and e.em_name='" + dom.getEmp().getEm_name() + "'");
		}
		if (!StringUtil.isNull(dom.getDept().getDept_name())) {
			sql.append(" and d.dept_name='" + dom.getDept().getDept_name() + "'");
		}
		if (!StringUtil.isNull(dom.getJob().getJob_name())) {
			sql.append(" and j.job_name='" + dom.getJob().getJob_name() + "'");
		}
		if (dom.getEmp().getEm_indate()!=null) {
			sql.append(" and e.em_indate=" + dom.getEmp().getEm_indate() + "");
		}
		if (dom.getLz_date()!=null) {
			sql.append(" and m.lz_date=" + dom.getLz_date() + "");
		}
		if (!StringUtil.isNull(dom.getLz_type())) {
			sql.append(" and m.lz_type=" + dom.getLz_type() + "");
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e=new Employee();
				Dept d = new Dept();
				Job j = new Job();
				Code c = new Code();
				Domission ds = new Domission();
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setSex(rs.getInt("e.sex"));
				ds.setLz_type(rs.getInt("m.lz_type"));
//				System.out.println(e.getId());
				
				c.setCode_value(rs.getString("c1_code_value"));
				
				ds.setCode(c);
				e.setDept(d);
				e.setJob(j);
				ds.setEmp(e);
				domList.add(ds);

			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}

		
		return domList;

	}
	
	/*
	 * 在职人员的条件查询
	 */
	@Override
	public List<Employee> zaizhiFind(Employee emp) {
		
		List<Employee> domList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		StringBuffer sql =  new StringBuffer("select e.*," 
				+" j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+" j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+" d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+" d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+" d.dept_setdate d_dept_setdate,d.situation d_situation,"
				+" c.code_name,c.code_value,c.id,c.type_id"
				+" from employee e "
			    +" LEFT JOIN dept d on e.dep_number=d.dept_number "
			    +" LEFT JOIN job j on j.job_number=e.job_number "
	            +" LEFT JOIN code c ON e.sex=c.id "
			    +" where e.situation=0");
		if (!StringUtil.isNull(emp.getDept().getDept_number())) {
			sql.append(" and e.dep_number=" + emp.getDept().getDept_number() + "");
		}
		if (!StringUtil.isNull(emp.getDept().getDept_name())) {
			sql.append(" and d.dept_name='" + emp.getDept().getDept_name() + "'");
		}
		if (!StringUtil.isNull(emp.getEm_number())) {
			sql.append(" and e.em_number=" + emp.getEm_number() + "");
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		ps = conn.prepareStatement(sql.toString());
		rs = ps.executeQuery();
		while(rs.next()) {						
			Employee e=new Employee();
			Dept d = new Dept();
			Job j = new Job();
			Code c = new Code();
			e.setEm_number(rs.getInt("e.em_number"));
			d.setDept_number(rs.getInt("e.dep_number"));
			d.setDept_name(rs.getString("d_dept_name"));
			j.setJob_number(rs.getInt("e.job_number"));
			j.setJob_name(rs.getString("j_job_name"));
			e.setEm_name(rs.getString("e.em_name"));
			e.setSex(rs.getInt("e.sex"));
			c.setCode_value(rs.getString("code_value"));
			e.setCode(c);
			e.setDept(d);
			e.setJob(j);
			domList.add(e);
		
		}
	}catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		return domList;	
		}
}
