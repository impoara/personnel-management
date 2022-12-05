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
import com.neuedu.personnel.dao.EmployeeDao;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;

public class EmployeeDaoimpl implements  EmployeeDao {

	/*
	 * 添加
	 */
	@Override
	public void insert(Employee emp) {
		Connection conn = DButil.getconn();
		PreparedStatement ps = null;
		int index = 0;
		StringBuffer sql = new StringBuffer("insert into employee(em_number,em_name,em_birth,sex,em_format,em_source,"
				+ "em_polity,em_folk,em_id,em_indate,em_worktime");
		if(!StringUtil.isNull(emp.getEm_birthplace())) {
			sql.append(",em_birthplace");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_stature())) {
			sql.append(",em_stature");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_learn())) {
			sql.append(",em_learn");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_specialty())) {
			sql.append(",em_specialty");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_phone())) {
			sql.append(",em_phone");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_blood())) {
			sql.append(",em_blood");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_homeplace())) {
			sql.append(",em_homeplace");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_degree())) {
			sql.append(",em_degree");
			index++;
		}
		if(emp.getEm_gradate() != null) {
			sql.append(",em_gradate");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_mail())) {
			sql.append(",em_mail");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_wedlock())) {
			sql.append(",em_wedlock");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_seat())) {
			sql.append(",em_seat");
			index++;
		}
		if(!StringUtil.isNull(emp.getEm_graduate())) {
			sql.append(",em_graduate");
			index++;
		}
		if(!StringUtil.isNull(emp.getDept().getDept_number())) {
			sql.append(",dep_number");
			index++;
		}
		if(!StringUtil.isNull(emp.getJob().getJob_number())) {
			sql.append(",job_number");
			index++;
		}

		sql.append(") values(?,?,?,?,?,?,?,?,?,?,?");
		for(int i = 0 ; i < index ; i++) {
			sql.append(",?");
		}
		sql.append(")");
		try {
			ps = conn.prepareStatement(sql.toString());
			index = 0;
			//System.out.println("tete:" + emp.getEm_number());
			ps.setInt(++index, emp.getEm_number());
			ps.setString(++index, emp.getEm_name());
			ps.setDate(++index, new java.sql.Date(emp.getEm_birth().getTime()));
			ps.setInt(++index, emp.getSex());
			ps.setInt(++index, emp.getEm_format());
			ps.setInt(++index, emp.getEm_source());
			ps.setInt(++index, emp.getEm_polity());
			ps.setInt(++index, emp.getEm_folk());
			ps.setString(++index, emp.getEm_id());
			//new java.sql.Date(dept.getDept_setdate().getTime())
			ps.setDate(++index, new java.sql.Date(emp.getEm_indate().getTime()));
			ps.setDate(++index, new java.sql.Date(emp.getEm_worktime().getTime()));
			
			if(!StringUtil.isNull(emp.getEm_birthplace())) {
				ps.setString(++index, emp.getEm_birthplace());
			}
			if(!StringUtil.isNull(emp.getEm_stature())) {
				ps.setString(++index, emp.getEm_stature());
			}
			if(!StringUtil.isNull(emp.getEm_learn())) {
				ps.setInt(++index, emp.getEm_learn());
			}
			if(!StringUtil.isNull(emp.getEm_specialty())) {
				ps.setString(++index, emp.getEm_specialty());
			}
			if(!StringUtil.isNull(emp.getEm_phone())) {
				ps.setString(++index, emp.getEm_phone());
			}
			if(!StringUtil.isNull(emp.getEm_blood())) {
				ps.setInt(++index, emp.getEm_blood());
				//System.out.println("13" + index);
			}
			if(!StringUtil.isNull(emp.getEm_homeplace())) {
				ps.setString(++index, emp.getEm_homeplace());
			}
			if(!StringUtil.isNull(emp.getEm_degree())) {
				ps.setInt(++index, emp.getEm_degree());
			}
			if(emp.getEm_gradate() != null) {
				ps.setDate(++index, new java.sql.Date(emp.getEm_gradate().getTime()));
			}
			if(!StringUtil.isNull(emp.getEm_mail())) {
				ps.setString(++index, emp.getEm_mail());
			}
			if(!StringUtil.isNull(emp.getEm_wedlock())) {
				ps.setInt(++index, emp.getEm_wedlock());
			}
			if(!StringUtil.isNull(emp.getEm_seat())) {
				ps.setString(++index, emp.getEm_seat());
			}
			if(!StringUtil.isNull(emp.getEm_graduate())) {
				ps.setString(++index, emp.getEm_graduate());
			}
			if(emp.getDept() != null &&!StringUtil.isNull(emp.getDept().getDept_number())) {
				ps.setInt(++index, emp.getDept().getDept_number());
			}
			if(emp.getJob() != null &&!StringUtil.isNull(emp.getJob().getJob_number())) {
				ps.setInt(++index, emp.getJob().getJob_number());
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

	/* 查询所有 */
	@Override
	public List<Employee> finAllEmp(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		StringBuffer sql = new StringBuffer("select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
//			if(StringUtil.isNull(emp.getPagecon())) {
//				//添加limit分页查询
//				sql.append("limit "+((emp.getPage()-1)*10)+",10");
//			}
//			
			Integer coun=0;
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {						
				Employee e = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_birth(rs.getDate("e.em_birth"));
				e.setSex(rs.getInt("e.sex"));
				e.setEm_format(rs.getInt("e.em_format"));
				e.setEm_source(rs.getInt("e.em_source"));
				e.setEm_polity(rs.getInt("e.em_polity"));
				e.setEm_folk(rs.getInt("e.em_folk"));
				e.setEm_id(rs.getString("e.em_id"));
				e.setEm_indate(rs.getDate("e.em_indate"));
				e.setEm_worktime(rs.getDate("e.em_worktime"));
				e.setEm_birthplace(rs.getString("e.em_birthplace"));
				e.setEm_phone(rs.getString("e.em_phone"));
				e.setEm_mail(rs.getString("e.em_mail"));
				e.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_seat(rs.getString("e.em_seat"));
				e.setEm_learn(rs.getInt("e.em_learn"));
				e.setEm_degree(rs.getInt("e.em_degree"));
				e.setEm_graduate(rs.getString("e.em_graduate"));
				e.setEm_specialty(rs.getString("e.em_specialty"));
				e.setEm_gradate(rs.getDate("e.em_gradate"));
				e.setEm_homeplace(rs.getString("e.em_homeplace"));
				e.setPagecoun(coun++);
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e.setDept(d);
				e.setJob(j);
				empList.add(e);
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return empList;

	}

	/* 按id查询 */
	@Override
	public List<Employee> findByEmp(Integer id) {
		
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		String sql = "select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0 and e.id= ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {						
				Employee e = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_birth(rs.getDate("e.em_birth"));
				e.setSex(rs.getInt("e.sex"));
				e.setEm_format(rs.getInt("e.em_format"));
				e.setEm_source(rs.getInt("e.em_source"));
				e.setEm_polity(rs.getInt("e.em_polity"));
				e.setEm_folk(rs.getInt("e.em_folk"));
				e.setEm_id(rs.getString("e.em_id"));
				e.setEm_indate(rs.getDate("e.em_indate"));
				e.setEm_worktime(rs.getDate("e.em_worktime"));
				e.setEm_birthplace(rs.getString("e.em_birthplace"));
				e.setEm_phone(rs.getString("e.em_phone"));
				e.setEm_mail(rs.getString("e.em_mail"));
				e.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				j.setJob_max(rs.getInt("j_job_max"));
				j.setJob_man(rs.getInt("j_job_man"));
				e.setEm_seat(rs.getString("e.em_seat"));
				e.setEm_learn(rs.getInt("e.em_learn"));
				e.setEm_degree(rs.getInt("e.em_degree"));
				e.setEm_graduate(rs.getString("e.em_graduate"));
				e.setEm_specialty(rs.getString("e.em_specialty"));
				e.setEm_gradate(rs.getDate("e.em_gradate"));
				e.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e.setDept(d);
				e.setJob(j);
				empList.add(e);
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return empList;
		
	}

	/* 修改 */
	@Override
	public void UpdateEmp(Employee emp, Integer id) {
		Connection conn = DButil .getconn();
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer("UPDATE employee "+
				" SET em_number=? , em_name=? ,sex=? ,em_birth=? ,em_id=? ,"+
				" em_indate=? , em_worktime=? ,em_format=? ,em_source=? ,em_polity=? ,em_folk=? ,"+
				" em_birthplace=? ,em_phone =? ,em_mail=? ,em_stature=? , em_blood=?,em_wedlock=? ,"+
				" em_seat=? ,em_learn=? ,em_degree=? ,em_gradate=? ,em_homeplace=?, "+
				"em_graduate=?,em_specialty=?"+
				" where id=?");
		//System.out.println(sql.toString());
		try {
			ps = conn.prepareStatement(sql.toString());
			Integer index=1;
			if(!StringUtil.isNull(emp.getEm_number())) {
				ps.setInt(index++, emp.getEm_number());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_name())) {
				ps.setString(index++,emp.getEm_name());
			}else {
				ps.setObject(index++, null);
			}
			
			if(!StringUtil.isNull(emp.getSex())) {
				ps.setInt(index++,emp.getSex());
			}else {
				ps.setObject(index++, null);
			}
			if(emp.getEm_birth()!=null) {
				ps.setDate(index++,new java.sql.Date(emp.getEm_birth().getTime()));
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_id())) {
				ps.setString(index++,emp.getEm_id());
			}else {
				ps.setObject(index++, null);
			}
			if(emp.getEm_indate()!=null) {
				ps.setDate(index++,new java.sql.Date(emp.getEm_indate().getTime()));
			}else {
				ps.setObject(index++, null);
			}
			if(emp.getEm_worktime()!=null) {
				ps.setDate(index++,new java.sql.Date(emp.getEm_worktime().getTime()));
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_format())) {
				ps.setInt(index++,emp.getEm_format());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_source())) {
				ps.setInt(index++,emp.getEm_source());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_polity())) {
				ps.setInt(index++,emp.getEm_polity());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_folk())) {
				ps.setInt(index++,emp.getEm_folk());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_birthplace())) {
				ps.setString(index++,emp.getEm_birthplace());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_phone())) {
				ps.setString(index++,emp.getEm_phone());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_mail())) {
				ps.setString(index++,emp.getEm_mail());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_stature())) {
				ps.setString(index++,emp.getEm_stature());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_blood())) {
				ps.setInt(index++,emp.getEm_blood());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_wedlock())) {
				ps.setInt(index++,emp.getEm_wedlock());
			}else {
				ps.setObject(index++, null);
			}
			
			if(!StringUtil.isNull(emp.getEm_seat())) {
				ps.setString(index++,emp.getEm_seat());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_learn() )){
				ps.setInt(index++,emp.getEm_learn());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_degree()) ){
				ps.setInt(index++,emp.getEm_degree());
			}else {
				ps.setObject(index++, null);
			}
			if(emp.getEm_gradate()!=null) {
				ps.setDate(index++,new java.sql.Date(emp.getEm_gradate().getTime()));
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_homeplace())) {
				ps.setString(index++,emp.getEm_homeplace());
			}else {
				ps.setObject(index++, null);
			}
		
			if(!StringUtil.isNull(emp.getEm_graduate() )){
				ps.setString(index++,emp.getEm_graduate());
			}else {
				ps.setObject(index++, null);
			}
			if(!StringUtil.isNull(emp.getEm_specialty() )){
				ps.setString(index++,emp.getEm_specialty());
			}else {
				ps.setObject(index++, null);
			}

			ps.setInt(25, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.close(ps);
			DButil.close(conn);
		}

		
	}

	/* 条件查询 */
	@Override
	public List<Employee> findIfEmp(Employee emp) {
		List<Employee> employeelist =new ArrayList<Employee>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		StringBuffer sql=new StringBuffer("select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0");
		if(emp.getEm_number() != null && emp.getEm_number() != 0) {
			sql.append(" and em_number=?");
			
		}
		if(emp.getEm_name()!=null && !"".equals(emp.getEm_name())) {
			sql.append(" and em_name=?");
		}
		if(!StringUtil.isNull(emp.getDept().getDept_number())) {
			sql.append(" and d.dept_number=?");
		}
		if(!StringUtil.isNull(emp.getJob().getJob_number())) {
			sql.append(" and j.job_number=?");
		}
		
		try {
			ps=conn.prepareStatement(sql.toString());
			
			int count = 1;
			if(emp.getEm_number() != null &&  emp.getEm_number() != 0) {
				ps.setInt(count, emp.getEm_number());
				count++;
			}
			if(emp.getEm_name()!=null && !"".equals(emp.getEm_name())) {
				ps.setString(count, emp.getEm_name());
				count++;
			}
			if(!StringUtil.isNull(emp.getDept().getDept_number())) {
				ps.setInt(count, emp.getDept().getDept_number());
				count++;
			}
			if(emp.getJob().getJob_number()!=0) {
				ps.setInt(count,emp.getJob().getJob_number());
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_birth(rs.getDate("e.em_birth"));
				e.setSex(rs.getInt("e.sex"));
				e.setEm_format(rs.getInt("e.em_format"));
				e.setEm_source(rs.getInt("e.em_source"));
				e.setEm_polity(rs.getInt("e.em_polity"));
				e.setEm_folk(rs.getInt("e.em_folk"));
				e.setEm_id(rs.getString("e.em_id"));
				e.setEm_indate(rs.getDate("e.em_indate"));
				e.setEm_worktime(rs.getDate("e.em_worktime"));
				e.setEm_birthplace(rs.getString("e.em_birthplace"));
				e.setEm_phone(rs.getString("e.em_phone"));
				e.setEm_mail(rs.getString("e.em_mail"));
				e.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_seat(rs.getString("e.em_seat"));
				e.setEm_learn(rs.getInt("e.em_learn"));
				e.setEm_degree(rs.getInt("e.em_degree"));
				e.setEm_graduate(rs.getString("e.em_graduate"));
				e.setEm_specialty(rs.getString("e.em_specialty"));
				e.setEm_gradate(rs.getDate("e.em_gradate"));
				e.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
				e.setDept(d);
				e.setJob(j);
				employeelist.add(e);
				System.out.println(employeelist.get(0).getJob().getJob_name());
				System.out.println(employeelist.get(0).getDept().getDept_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		
		
		return employeelist;
	}

	/* 按员工编号number查询所有 */
	@Override
	public Employee findByEmpDept(Integer number) {
		
		Connection conn = DButil.getconn();
		String sql = "select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0 and e.em_number= ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee e1 = new Employee();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {						
				
				Dept d = new Dept();
				Job j = new Job();
				
				e1.setId(rs.getInt("e.id"));
				e1.setEm_number(rs.getInt("e.em_number"));
				e1.setEm_name(rs.getString("e.em_name"));
				e1.setEm_birth(rs.getDate("e.em_birth"));
				e1.setSex(rs.getInt("e.sex"));
				e1.setEm_format(rs.getInt("e.em_format"));
				e1.setEm_source(rs.getInt("e.em_source"));
				e1.setEm_polity(rs.getInt("e.em_polity"));
				e1.setEm_folk(rs.getInt("e.em_folk"));
				e1.setEm_id(rs.getString("e.em_id"));
				e1.setEm_indate(rs.getDate("e.em_indate"));
				e1.setEm_worktime(rs.getDate("e.em_worktime"));
				e1.setEm_birthplace(rs.getString("e.em_birthplace"));
				e1.setEm_phone(rs.getString("e.em_phone"));
				e1.setEm_mail(rs.getString("e.em_mail"));
				e1.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e1.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e1.setEm_seat(rs.getString("e.em_seat"));
				e1.setEm_learn(rs.getInt("e.em_learn"));
				e1.setEm_degree(rs.getInt("e.em_degree"));
				e1.setEm_graduate(rs.getString("e.em_graduate"));
				e1.setEm_specialty(rs.getString("e.em_specialty"));
				e1.setEm_gradate(rs.getDate("e.em_gradate"));
				e1.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e1.setDept(d);
				e1.setJob(j);
		
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return e1;
		
	}

	/* 按部门编号number查询所有 */
	@Override
	public List<Employee> findByDept(Integer number) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		String sql = "select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0 and e.dep_number= ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {						
				Employee e1 = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e1.setId(rs.getInt("e.id"));
				e1.setEm_number(rs.getInt("e.em_number"));
				e1.setEm_name(rs.getString("e.em_name"));
				e1.setEm_birth(rs.getDate("e.em_birth"));
				e1.setSex(rs.getInt("e.sex"));
				e1.setEm_format(rs.getInt("e.em_format"));
				e1.setEm_source(rs.getInt("e.em_source"));
				e1.setEm_polity(rs.getInt("e.em_polity"));
				e1.setEm_folk(rs.getInt("e.em_folk"));
				e1.setEm_id(rs.getString("e.em_id"));
				e1.setEm_indate(rs.getDate("e.em_indate"));
				e1.setEm_worktime(rs.getDate("e.em_worktime"));
				e1.setEm_birthplace(rs.getString("e.em_birthplace"));
				e1.setEm_phone(rs.getString("e.em_phone"));
				e1.setEm_mail(rs.getString("e.em_mail"));
				e1.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e1.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e1.setEm_seat(rs.getString("e.em_seat"));
				e1.setEm_learn(rs.getInt("e.em_learn"));
				e1.setEm_degree(rs.getInt("e.em_degree"));
				e1.setEm_graduate(rs.getString("e.em_graduate"));
				e1.setEm_specialty(rs.getString("e.em_specialty"));
				e1.setEm_gradate(rs.getDate("e.em_gradate"));
				e1.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e1.setDept(d);
				e1.setJob(j);
				empList.add(e1);
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return empList;
		
	}
	
	/* 按岗位编号number查询所有 */
	@Override
	public List<Employee> findByJob(Integer number) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		String sql = "select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0 and e.job_number= ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {						
				Dept d = new Dept();
				Job j = new Job();
				Employee e1 = new Employee();
				e1.setId(rs.getInt("e.id"));
				e1.setEm_number(rs.getInt("e.em_number"));
				e1.setEm_name(rs.getString("e.em_name"));
				e1.setEm_birth(rs.getDate("e.em_birth"));
				e1.setSex(rs.getInt("e.sex"));
				e1.setEm_format(rs.getInt("e.em_format"));
				e1.setEm_source(rs.getInt("e.em_source"));
				e1.setEm_polity(rs.getInt("e.em_polity"));
				e1.setEm_folk(rs.getInt("e.em_folk"));
				e1.setEm_id(rs.getString("e.em_id"));
				e1.setEm_indate(rs.getDate("e.em_indate"));
				e1.setEm_worktime(rs.getDate("e.em_worktime"));
				e1.setEm_birthplace(rs.getString("e.em_birthplace"));
				e1.setEm_phone(rs.getString("e.em_phone"));
				e1.setEm_mail(rs.getString("e.em_mail"));
				e1.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e1.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e1.setEm_seat(rs.getString("e.em_seat"));
				e1.setEm_learn(rs.getInt("e.em_learn"));
				e1.setEm_degree(rs.getInt("e.em_degree"));
				e1.setEm_graduate(rs.getString("e.em_graduate"));
				e1.setEm_specialty(rs.getString("e.em_specialty"));
				e1.setEm_gradate(rs.getDate("e.em_gradate"));
				e1.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e1.setDept(d);
				e1.setJob(j);
		
				empList.add(e1);
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return empList;
		
	}

	/* 显示全部 计数 */
	@Override
	public Integer finAllEmpAll() {
		Connection conn = DButil.getconn();
		String sql = "SELECT MAX(em_number) "+ 
				" FROM employee";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer is=0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {						
				is=rs.getInt("MAX(em_number)")+1;
			}else {
				is=1;
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return is;

	}
	
	/* 查询所有(数据库) */
	@Override
	public List<Employee> finAllEmp1(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		String sql = "select  e.*,"
				+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
				+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
				+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
				+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
				+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
				+ " from employee e"
				+ " left JOIN dept d on e.dep_number=d.dept_number"
				+ " left join job j on j.job_number=e.job_number"
				+ " where e.situation=0";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {						
				Employee e = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_birth(rs.getDate("e.em_birth"));
				e.setSex(rs.getInt("e.sex"));
				e.setEm_format(rs.getInt("e.em_format"));
				e.setEm_source(rs.getInt("e.em_source"));
				e.setEm_polity(rs.getInt("e.em_polity"));
				e.setEm_folk(rs.getInt("e.em_folk"));
				e.setEm_id(rs.getString("e.em_id"));
				e.setEm_indate(rs.getDate("e.em_indate"));
				e.setEm_worktime(rs.getDate("e.em_worktime"));
				e.setEm_birthplace(rs.getString("e.em_birthplace"));
				e.setEm_phone(rs.getString("e.em_phone"));
				e.setEm_mail(rs.getString("e.em_mail"));
				e.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_seat(rs.getString("e.em_seat"));
				e.setEm_learn(rs.getInt("e.em_learn"));
				e.setEm_degree(rs.getInt("e.em_degree"));
				e.setEm_graduate(rs.getString("e.em_graduate"));
				e.setEm_specialty(rs.getString("e.em_specialty"));
				e.setEm_gradate(rs.getDate("e.em_gradate"));
				e.setEm_homeplace(rs.getString("e.em_homeplace"));
				
				
			//	System.out.println(rs.getString("j_job_name"));
//				
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
				
				e.setDept(d);
				e.setJob(j);
				empList.add(e);
				
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return empList;
	}

	/* 分页 */
	@Override
	public List<Employee> finAllpage(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		Connection conn = DButil.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select  e.*,"
					+ " j.id j_id,j.job_number j_job_number,j.job_name j_job_name,j.job_type j_job_type,"
					+ " j.job_man j_job_man,j.job_max j_job_max,j.situation j_situation,"
					+ " d.id d_id,d.dept_number d_dept_number,d.dept_name d_dept_name,d.dept_type d_dept_type,"
					+ " d.dept_tel d_dept_tel,d.dept_fax d_dept_fax,d.dept_super d_dept_super,d.dept_desc d_dept_desc,"
					+ " d.dept_setdate d_dept_setdate,d.situation d_situation"
					+ " from employee e"
					+ " left JOIN dept d on e.dep_number=d.dept_number"
					+ " left join job j on j.job_number=e.job_number"
					+ " where e.situation=0"
					+ " limit ?,10 ";
			
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ((emp.getPage()-1)*10));
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				Dept d = new Dept();
				Job j = new Job();
				
				e.setId(rs.getInt("e.id"));
				e.setEm_number(rs.getInt("e.em_number"));
				e.setEm_name(rs.getString("e.em_name"));
				e.setEm_birth(rs.getDate("e.em_birth"));
				e.setSex(rs.getInt("e.sex"));
				e.setEm_format(rs.getInt("e.em_format"));
				e.setEm_source(rs.getInt("e.em_source"));
				e.setEm_polity(rs.getInt("e.em_polity"));
				e.setEm_folk(rs.getInt("e.em_folk"));
				e.setEm_id(rs.getString("e.em_id"));
				e.setEm_indate(rs.getDate("e.em_indate"));
				e.setEm_worktime(rs.getDate("e.em_worktime"));
				e.setEm_birthplace(rs.getString("e.em_birthplace"));
				e.setEm_phone(rs.getString("e.em_phone"));
				e.setEm_mail(rs.getString("e.em_mail"));
				e.setEm_wedlock(rs.getInt("e.em_wedlock"));
				e.setEm_stature(rs.getString("e.em_stature"));
//				e.setEm_blood(rs.getInt("e.em_blood"));
				
				d.setDept_number(rs.getInt("e.dep_number"));
				d.setDept_name(rs.getString("d_dept_name"));
				j.setJob_number(rs.getInt("e.job_number"));
				j.setJob_name(rs.getString("j_job_name"));
				e.setEm_seat(rs.getString("e.em_seat"));
				e.setEm_learn(rs.getInt("e.em_learn"));
				e.setEm_degree(rs.getInt("e.em_degree"));
				e.setEm_graduate(rs.getString("e.em_graduate"));
				e.setEm_specialty(rs.getString("e.em_specialty"));
				e.setEm_gradate(rs.getDate("e.em_gradate"));
				e.setEm_homeplace(rs.getString("e.em_homeplace"));
				e.setJob(j);
				e.setDept(d);
				
				empList.add(e);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		return empList;
	}

}
