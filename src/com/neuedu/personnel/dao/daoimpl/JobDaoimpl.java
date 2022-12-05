package com.neuedu.personnel.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.dao.JobDao;
import com.neuedu.personnel.utils.DButil;

public class JobDaoimpl implements JobDao {
	/*
	 * 添加
	 */
	@Override
	public void insertJob(Job job) {
		PreparedStatement ps=null;
		Connection conn=DButil.getconn();
		String sql="insert into job (job_number,job_name,job_type,job_man,job_max) values(?,?,?,0,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,job.getJob_number());
			ps.setString(2, job.getJob_name());
			ps.setInt(3, job.getJob_type());
			ps.setInt(4, job.getJob_max());
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
	  * 删除 
	  */
	@Override
	public void DeleteJob(Integer id) {
		Connection conn = DButil.getconn();
		String sql = "UPDATE job SET situation = 0 WHERE id=?";
		PreparedStatement ps = null;
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
	public void UpdateJob(Job job,Integer id) {
						
				Connection conn = DButil.getconn();
				String sql = "UPDATE job SET job_number= ? , job_name= ?, job_type = ?, job_max= ? where id=?";
				
				PreparedStatement ps = null;
				try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1,job.getJob_number());
				ps.setString(2,job.getJob_name());
				ps.setInt(3,job.getJob_type());
				ps.setInt(4, job.getJob_max());
				ps.setInt(5, id);
				ps.executeUpdate();
				
				} catch (SQLException e) {
				
				e.printStackTrace();
				}finally {
				DButil.close(ps);
				DButil.close(conn);
				}
		
		
	}

	
	 /*
	  * 查询所有(数据库界面)
	  */
	@Override
	public List<Job> findAllJob1() {
		List<Job> joblist =new ArrayList<Job>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		String sql="select j.*,c.code_value job_type_name  from job j,code c where j.job_type=c.id";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Job j = new Job();
				j.setId(rs.getInt("id"));
				j.setJob_number(rs.getInt("job_number"));
				j.setJob_name(rs.getString("job_name"));
				j.setJob_type(rs.getInt("job_type"));
				j.setJob_man(rs.getInt("job_man"));
				j.setJob_max(rs.getInt("job_max"));
				j.setSituation(rs.getInt("situation"));
				j.setJob_type_name(rs.getString("job_type_name"));
				joblist.add(j);
//				System.out.println(joblist.get(0).getJob_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		return joblist;
	}

	 /*
	  * 查询所有(用户界面的所有)
	  */
	@Override
	public List<Job> findAllJob() {
		List<Job> joblist =new ArrayList<Job>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		String sql="select j.*,c.code_value job_type_name  from job j,code c where situation =1 and j.job_type=c.id";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Job j = new Job();
				j.setId(rs.getInt("id"));
				j.setJob_number(rs.getInt("job_number"));
				j.setJob_name(rs.getString("job_name"));
				j.setJob_type(rs.getInt("job_type"));
				j.setJob_man(rs.getInt("job_man"));
				j.setJob_max(rs.getInt("job_max"));
				j.setSituation(rs.getInt("situation"));
				j.setJob_type_name(rs.getString("job_type_name"));
				joblist.add(j);
//				System.out.println(joblist.get(0).getJob_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		return joblist;
	}

	/*
	  * 按id查询岗位
	  * 
	  */
	@Override
	public List<Job> findByJob(Integer id) {
	
		List<Job> joblist1 =new ArrayList<Job>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		String sql="select j.*,c.code_value job_type_name  from job j,code c where situation =1 and j.job_type=c.id and j.id = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
//			System.out.println("111");
			if(rs.next()) {
				Job j = new Job();
				j.setId(rs.getInt("id"));
				j.setJob_number(rs.getInt("job_number"));
				j.setJob_name(rs.getString("job_name"));
				j.setJob_type(rs.getInt("job_type"));
				j.setJob_man(rs.getInt("job_man"));
				j.setJob_max(rs.getInt("job_max"));
				j.setSituation(rs.getInt("situation"));
				j.setJob_type_name(rs.getString("job_type_name"));
				joblist1.add(j);
//				System.out.println("456789");
//				System.out.println(joblist1.get(0).getJob_type_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		return joblist1;
	}

	/*
	 * 条件查询
	 */
	@Override
	public List<Job> findJobIf(Job job) {
		List<Job> joblist =new ArrayList<Job>();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		StringBuffer sql=new StringBuffer("select j.*,c.code_value job_type_name  from job j,code c where situation =1 and j.job_type=c.id");
		if(job.getJob_number() != null && job.getJob_number()!=0) {
			sql.append(" and job_number = ?");
			
		}
		if(job.getJob_name()!=null && !"".equals(job.getJob_name())) {
			sql.append(" and job_name = ?");
		}
		if(job.getJob_type()!=0) {
			sql.append(" and job_type = ?");
		}
		
		try {
			ps=conn.prepareStatement(sql.toString());
			
			int count =1;
			if(job.getJob_number() != null && job.getJob_number()!=0) {
				ps.setInt(count, job.getJob_number());
				count++;
			}
			if(job.getJob_name()!=null && !"".equals(job.getJob_name())) {
				ps.setString(count, job.getJob_name());
				count++;
			}
			if(job.getJob_type()!=0) {
				ps.setInt(count,job.getJob_type());
				
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Job j = new Job();
				j.setId(rs.getInt("id"));
				j.setJob_number(rs.getInt("j.job_number"));
				j.setJob_name(rs.getString("j.job_name"));
				j.setJob_type(rs.getInt("j.job_type"));
				j.setJob_man(rs.getInt("j.job_man"));
				j.setJob_max(rs.getInt("j.job_max"));
				j.setSituation(rs.getInt("j.situation"));
				j.setJob_type_name(rs.getString("job_type_name"));
				joblist.add(j);
//				System.out.println(joblist.get(0).getJob_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		return joblist;
	}

	 /*
	  * number查询，其他
	  */
	@Override
	public Job findIdJob(Integer number) {
	
		Job job =new Job();
		Connection conn=DButil.getconn();
		ResultSet rs =null;
		PreparedStatement ps=null;
		String sql="select j.*,c.code_value job_type_name  from job j,code c where situation =1 and j.job_type=c.id and j.job_number = ?";
		try {

			ps=conn.prepareStatement(sql);
			ps.setInt(1,number);
			rs=ps.executeQuery();
//			System.out.println("111");
			if(rs.next()) {
				job.setId(rs.getInt("id"));
				job.setJob_number(rs.getInt("job_number"));
				job.setJob_name(rs.getString("job_name"));
				job.setJob_type(rs.getInt("job_type"));
				job.setJob_man(rs.getInt("job_man"));
				job.setJob_max(rs.getInt("job_max"));
				job.setSituation(rs.getInt("situation"));
				job.setJob_type_name(rs.getString("job_type_name"));
				
//				System.out.println("456789");
//				System.out.println(joblist1.get(0).getJob_type_name());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.close(rs);
			DButil.close(ps);
			DButil.close(conn);
		}
		
		
		return job;
		
	}
	
	 /*
	  * id查询，加1
	  */
	@Override
	public void JobNumber(Integer number,Integer man) {

		Connection conn=DButil.getconn();
	
		PreparedStatement ps=null;
		String sql="UPDATE job SET job_man= ? where job_number=?";
		try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1,man);
		ps.setInt(2,number);
		ps.executeUpdate();
		
		} catch (SQLException e) {
		
		e.printStackTrace();
		}finally {
		DButil.close(ps);
		DButil.close(conn);
		}
		
	}
	

	/*
	  * 显示全部，计数	 
	  */
	@Override
	public Integer findAllcount(Integer job_type) {
		Connection conn = DButil.getconn();
		String sql = "SELECT MAX(job_number) "+ 
				" FROM job"+ 
				" where job_type= ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer coun=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,job_type);
			rs = ps.executeQuery();
			if(rs.next()) {	
				if(rs.getInt("MAX(job_number)")!=0) {
					coun=rs.getInt("MAX(job_number)")+1;
				}else{
					if(job_type==48) {
						coun=20001;
					}else if(job_type==49) {
						coun=30001;
					}else if(job_type==50) {
						coun=40001;
					}else {
						coun=1;
					}
					}
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
			return coun;
	}
	/*
	 * 修改岗位编号
	 */
	@Override
	public void updatejob(Integer job_number, Integer job_type,Integer id) {
		Connection conn = DButil.getconn();
		String sql = "UPDATE job j SET j.job_number= ? ,j.job_type= ? where j.id=?";
		
		PreparedStatement ps = null;
		try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1,job_number);
		ps.setInt(2, job_type);
		ps.setInt(3,id);
		
		ps.executeUpdate();
		
		} catch (SQLException e) {
		
		e.printStackTrace();
		}finally {
		DButil.close(ps);
		DButil.close(conn);
		}

	}
	/*
	 * 计算在岗人数
	 */
	@Override
	public void JobCount() {
		Connection conn = DButil.getconn();
		StringBuffer sql = new StringBuffer("update job j" + 
				" SET job_man=(" + 
				" SELECT count(*)" + 
				" FROM employee e" + 
				" WHERE e.job_number=j.job_number and e.situation=0 )" + 
				" WHERE j.situation=1");
		PreparedStatement ps = null;
		try {
		ps = conn.prepareStatement(sql.toString());
		ps.executeUpdate();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}finally {
		DButil.close(ps);
		DButil.close(conn);
		}
		
	}
	
}
