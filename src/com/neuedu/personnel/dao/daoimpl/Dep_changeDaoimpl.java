package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dep_change;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.Dep_changeDao;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;

public class Dep_changeDaoimpl implements Dep_changeDao {
		
		/* 修改部门编号*/
		@Override
		public void domUpdate(Integer number,Integer id) {
			Connection conn = DButil .getconn();
			PreparedStatement ps = null;
			StringBuffer sql = new StringBuffer("UPDATE employee "+
					" SET dep_number= ? "+
					" WHERE id= ? ");
			System.out.println(sql.toString());
			try {
				ps = conn.prepareStatement(sql.toString());
		
				ps.setInt(1,number);
				ps.setInt(2,id);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DButil.close(ps);
				DButil.close(conn);
			}
			
		}
		
		//添加
		@Override
		public void InsertDep(Dep_change depc) {
			Connection conn = DButil.getconn();
			PreparedStatement ps = null;
			StringBuffer sql = new StringBuffer("INSERT INTO dep_change (em_id, dept_before, dept_after, dept_chtype, dept_chreason, dept_chdate, dept_extra) VALUES (?,?,?,?,?,?,?) " );	
			
			
			
			System.out.println(sql.toString());
			try {
				
				ps = conn.prepareStatement(sql.toString());
				ps.setInt(1, depc.getEmp().getEm_number());
				
				if(depc.getDept_before().getDept_number()!=null) {
					ps.setInt(2, depc.getDept_before().getDept_number());
				}else {
					ps.setObject(2, null);
				}
				
				ps.setInt(3, depc.getDept_after().getDept_number());
				ps.setInt(4, depc.getDept_chtype());
				ps.setString(5, depc.getDept_chreason());
				ps.setDate(6, new java.sql.Date (depc.getDept_chdate().getTime()));
				if(depc.getDept_chdate() != null) {
					ps.setString(7, depc.getDept_extra());
				}else {
					ps.setObject(7, null);
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
		
		//查询已调动所有
		@Override
		public List<Dep_change> findAllChange() {
				List<Dep_change> changeList = new ArrayList<Dep_change>();
				Connection conn = DButil.getconn();
				StringBuffer sql =  new StringBuffer("SELECT e.*," + 
						" d1.id d1_id,d1.dept_number d1_dept_number,d1.dept_name d1_dept_name," + 
						" d1.dept_type d1_dept_type,d1.dept_tel d1_dept_tel,d1.dept_fax d1_dept_fax," + 
						" d1.dept_super d1_dept_super,d1.dept_desc d1_dept_desc," + 
						" d1.dept_setdate d1_dept_setdate,d1.situation d1_situation," +
						" d2.id d2_id,d2.dept_number d2_dept_number,d2.dept_name d2_dept_name," + 
						" d2.dept_type d2_dept_type,d2.dept_tel d2_dept_tel,d2.dept_fax d2_dept_fax," + 
						" d2.dept_super d2_dept_super,d2.dept_desc d2_dept_desc," + 
						" d2.dept_setdate d2_dept_setdate,d2.situation d2_situation," +
						" dep.*," + 
						" dom.*,"+
						" c1.code_value c1_code_value ,"+ 
						" c2.code_value c2_code_value " + 
						" from dep_change dep" + 
						" left JOIN employee e on e.em_number=dep.em_id" + 
						" left join dept d2 on dep.dept_after=d2.dept_number" + 
						" left JOIN dept d1 on dep.dept_before=d1.dept_number" + 
						" left join domission dom ON dom.em_id=e.id" + 
						" left join code c1 on c1.id=dep.dept_chtype"
						+" left join code c2 on c2.id=dep.dept_chreason" + 
						" where 1=1 ");
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
				ps = conn.prepareStatement(sql.toString());
				rs = ps.executeQuery();
				while(rs.next()) {						
					Employee e=new Employee();
					Dep_change dep=new Dep_change();
					Dept before = new Dept();//原部门
					Dept after = new Dept();//新部门
					Code c1 = new Code();
					Code c2 = new Code();
					
					e.setEm_number(rs.getInt("e.em_number"));
					e.setEm_name(rs.getString("e.em_name"));
					
		//				System.out.println(e.getEm_number());
		//				System.out.println(rs.getInt("e.em_number"));
					
					before.setDept_number(rs.getInt("d1_dept_number"));
					before.setDept_name(rs.getString("d1_dept_name"));
					
					after.setDept_number(rs.getInt("d2_dept_number"));
					after.setDept_name(rs.getString("d2_dept_name"));
					
					dep.setDept_after(after);
					dep.setDept_before(before);
					
					dep.setDept_chdate(rs.getDate("dep.dept_chdate"));
					dep.setDept_chtype(rs.getInt("dep.dept_chtype"));
					dep.setDept_chreason(rs.getString("dep.dept_chreason"));
					dep.setDept_extra(rs.getString("dep.dept_extra"));
					
					c1.setCode_value(rs.getString("c1_code_value"));
					c2.setCode_value(rs.getString("c2_code_value"));
					
					dep.setCode1(c1);
					dep.setCode2(c2);
					
					e.setDept(before);
					e.setDept(after);
					dep.setEmp(e);
					changeList.add(dep);
				
				}
			}catch (SQLException e) {
					
					e.printStackTrace();
				} finally {
					DButil.close(rs);
					DButil.close(ps);
					DButil.close(conn);
				}
				return changeList;
			}
			
		//已调动部门条件查询
		@Override
		public List<Dep_change> findchange(Dep_change dep) {
					List<Dep_change> changeList = new ArrayList<Dep_change>();
					Connection conn = DButil.getconn();
					StringBuffer sql =  new StringBuffer("SELECT e.*," + 
							" d1.id d1_id,d1.dept_number d1_dept_number,d1.dept_name d1_dept_name," + 
							" d1.dept_type d1_dept_type,d1.dept_tel d1_dept_tel,d1.dept_fax d1_dept_fax," + 
							" d1.dept_super d1_dept_super,d1.dept_desc d1_dept_desc," + 
							" d1.dept_setdate d1_dept_setdate,d1.situation d1_situation," +
							" d2.id d2_id,d2.dept_number d2_dept_number,d2.dept_name d2_dept_name," + 
							" d2.dept_type d2_dept_type,d2.dept_tel d2_dept_tel,d2.dept_fax d2_dept_fax," + 
							" d2.dept_super d2_dept_super,d2.dept_desc d2_dept_desc," + 
							" d2.dept_setdate d2_dept_setdate,d2.situation d2_situation," +
							" dep.*," + 
							" dom.*,"+
							" c1.code_value c1_code_value ,"+ 
							" c2.code_value c2_code_value " + 
							" from dep_change dep" + 
							" left JOIN employee e on e.em_number=dep.em_id" + 
							" left join dept d2 on dep.dept_after=d2.dept_number" + 
							" left JOIN dept d1 on dep.dept_before=d1.dept_number" + 
							" left join domission dom ON dom.em_id=e.id" + 
							" left join code c1 on c1.id=dep.dept_chtype"
							+" left join code c2 on c2.id=dep.dept_chreason" + 
							" where 1=1 ");
				if(dep.getEmp() !=null && dep.getEmp().getEm_indate()!=null) {
					sql.append(" and dep.dept_chdate>='"+new java.sql.Date(dep.getEmp().getEm_indate().getTime())+"'");
				}
				if(dep.getDom() !=null && dep.getDom().getLz_date()!=null) {
					sql.append(" and dep.dept_chdate<='"+new java.sql.Date(dep.getDom().getLz_date().getTime())+"'");
				}
				if (dep.getEmp() !=null && !StringUtil.isNull(dep.getEmp().getEm_number())) {
					sql.append(" and e.em_number=" + dep.getEmp().getEm_number() + "");
				}
				if(dep.getEmp() !=null && !StringUtil.isNull(dep.getEmp().getEm_name())) {
					sql.append(" and e.em_name='" + dep.getEmp().getEm_name() + "'");
				}
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
				ps = conn.prepareStatement(sql.toString());
				rs = ps.executeQuery();
				while(rs.next()) {						
					Employee e=new Employee();
					Dep_change dep1 = new Dep_change();
					Dept before = new Dept();//原部门
					Dept after = new Dept();//新部门
					Code c1 = new Code();
					Code c2 = new Code();
					
					e.setEm_number(rs.getInt("e.em_number"));
					e.setEm_name(rs.getString("e.em_name"));
					e.setId(rs.getInt("e.id"));
		//				System.out.println(e.getEm_number());
		//				System.out.println(rs.getInt("e.em_number"));
					
					before.setDept_number(rs.getInt("d1_dept_number"));
					before.setDept_name(rs.getString("d1_dept_name"));
					
					after.setDept_number(rs.getInt("d2_dept_number"));
					after.setDept_name(rs.getString("d2_dept_name"));
					
					dep1.setDept_after(after);
					dep1.setDept_before(before);
					
					dep1.setDept_chdate(rs.getDate("dep.dept_chdate"));
					dep1.setDept_chtype(rs.getInt("dep.dept_chtype"));
					dep1.setDept_chreason(rs.getString("dep.dept_chreason"));
					dep1.setDept_extra(rs.getString("dep.dept_extra"));
					
					c1.setCode_value(rs.getString("c1_code_value"));
					c2.setCode_value(rs.getString("c2_code_value"));
					
					dep1.setCode1(c1);
					dep1.setCode2(c2);
					
					
					e.setDept(before);
					e.setDept(after);
					dep1.setEmp(e);
					changeList.add(dep1);
				
				}
			}catch (SQLException e) {
					
					e.printStackTrace();
				} finally {
					DButil.close(rs);
					DButil.close(ps);
					DButil.close(conn);
				}
				return changeList;
			}
		
		//调动条件查询
		@Override
		public List<Employee> finOne(Employee emp) {
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
				if(!StringUtil.isNull(emp.getEm_name())) {
					sql.append(" and e.em_name='" + emp.getEm_name() + "'");
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
					e.setId(rs.getInt("e.id"));
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
