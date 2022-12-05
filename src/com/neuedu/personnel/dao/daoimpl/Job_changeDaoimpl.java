package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.bean.Job_change;
import com.neuedu.personnel.dao.Job_changeDao;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;

public class Job_changeDaoimpl implements Job_changeDao {

//添加
	@Override
	public void InsertJob(Job_change job) {
		Connection conn = DButil.getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("INSERT INTO job_change " + 
				"( emp_number, emp_name, job_chname, job_chtype, job_chreason, job_chdate, job_oldname ,job_chextra)" + 
				" VALUES (?,?,?,?,?,?,?,?) " );	
		System.out.println(sql.toString());
		try {
			
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1,job.getEmp().getEm_number() );
			ps.setString(2,job.getEmp().getEm_name() );
			ps.setString(3, job.getJob_chname());
			ps.setInt(4, job.getJob_chtype());
			ps.setString(5, job.getJob_chreason());
			ps.setDate(6, new java.sql.Date (job.getJob_chdate().getTime()));
			ps.setString(7, job.getJob_oldname());
			if(job.getJob_chextra() != null) {
				ps.setString(8,job.getJob_chextra());
			}else {
				ps.setObject(8, null);
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

	//修改
	@Override
	public void UpdateJob(Integer number, Integer id) {
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("UPDATE employee "+
				" SET job_number= ? "+
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

	/*
	 * 查询所有已调动
	 */
	@Override
	public List<Job_change> findAllCjob(Job_change cJob) {
		Connection conn = DButil.getconn();
		String sql = "SELECT *,c1.code_value ,c2.code_value"
				+ " FROM job_change j"
				+ " LEFT JOIN code c1 "
				+ " ON j.job_chtype=c1.id"
				+ " LEFT JOIN code c2"
				+ " ON j.job_chreason=c2.id"
				+ " LEFT JOIN employee e"
				+ " ON e.em_number=j.emp_number";
		List<Job_change> jchList = new ArrayList<Job_change>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Code c1 = new Code();
				Code c2 = new Code();
				Employee e = new Employee();
				Job_change j = new Job_change();
				c1.setCode_value(rs.getString("c1.code_value"));
				c2.setCode_value(rs.getString("c2.code_value"));
				j.setJob_chdate(rs.getDate("j.job_chdate"));
				j.setJob_chextra(rs.getString("j.job_chextra"));
				j.setJob_chname(rs.getString("j.job_chname"));
				j.setJob_chreason(rs.getString("j.job_chreason"));
				j.setJob_chtype(rs.getInt("j.job_chtype"));
				j.setJob_oldname(rs.getString("j.job_oldname"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_number(rs.getInt("e.em_number"));
				j.setEmp(e);
				j.setCode1(c1);
				j.setCode2(c2);
				jchList.add(j);
				
				System.out.println(jchList.get(0).getJob_chname());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return jchList;
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
				if (!StringUtil.isNull(emp.getJob().getJob_number())) {
					sql.append(" and e.job_number=" + emp.getJob().getJob_number() + "");
				}
				if (!StringUtil.isNull(emp.getJob().getJob_name())) {
					sql.append(" and d.job_name='" + emp.getJob().getJob_name() + "'");
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

	//条件查询已调动
			@Override
	public List<Job_change> findOnech(Job_change jch) {
				Connection conn = DButil.getconn();
				StringBuffer sql = new StringBuffer("SELECT *,c1.code_value,c2.code_value"
						+ " FROM job_change j"
						+ " LEFT JOIN code c1"
						+ " ON j.job_chtype=c1.id"
						+ " LEFT JOIN code c2"
						+ " ON j.job_chreason=c2.id"
						+ " LEFT JOIN employee e"
						+ " ON e.em_number=j.emp_number"
						+ " left join domission dom"
						+ " on dom.em_id=e.id"
						+ " where 1=1 ");
				if (jch.getEmp()!=null && !StringUtil.isNull(jch.getEmp().getEm_number())) {
					sql.append(" and e.em_number=" + jch.getEmp().getEm_number() + "");
				}
				if (jch.getEmp()!=null && !StringUtil.isNull(jch.getEmp().getEm_name())) {
					sql.append(" and e.em_name='" + jch.getEmp().getEm_name() + "'");
				}
				if (!StringUtil.isNull(jch.getJob_chreason())) {
					sql.append(" and j.job_chreason=" + jch.getJob_chreason() + "");
				}
				if(jch.getEmp() !=null && jch.getEmp().getEm_indate()!=null) {
					sql.append(" and j.job_chdate>='"+new java.sql.Date(jch.getEmp().getEm_indate().getTime())+"'");
				}
				if(jch.getDom() !=null && jch.getDom().getLz_date()!=null) {
					sql.append(" and j.job_chdate<='"+new java.sql.Date(jch.getDom().getLz_date().getTime())+"'");
				}
				List<Job_change> jchList = new ArrayList<Job_change>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				System.out.println(jch.getJob_chtype());
				try {
					ps = conn.prepareStatement(sql.toString());
					rs = ps.executeQuery();
					while(rs.next()) {
						Code c1 = new Code();
						Code c2 = new Code();
						
						Employee e = new Employee();
						Job_change j = new Job_change();
						c1.setCode_value(rs.getString("c1.code_value"));
						c2.setCode_value(rs.getString("c2.code_value"));
						j.setJob_chdate(rs.getDate("j.job_chdate"));
						j.setJob_chextra(rs.getString("j.job_chextra"));
						j.setJob_chname(rs.getString("j.job_chname"));
						j.setJob_chreason(rs.getString("j.job_chreason"));
						j.setJob_chtype(rs.getInt("j.job_chtype"));
						j.setJob_oldname(rs.getString("j.job_oldname"));
						e.setEm_name(rs.getString("e.em_name"));
						e.setEm_number(rs.getInt("e.em_number"));
						e.setId(rs.getInt("e.id"));
						j.setEmp(e);
						j.setCode1(c1);
						j.setCode2(c2);
						
						jchList.add(j);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return jchList;
			}

}
