package com.neuedu.personnel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.JobService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.JobServiceimpl;
import com.neuedu.personnel.utils.Constant;
import com.neuedu.personnel.utils.StringUtil;

/**
 * Servlet implementation class JobServlet
 */
//岗位
@WebServlet("/job/JobServlet.action")
public class JobServlet extends HttpServlet {

  private JobService jobservice =JobServiceimpl.getJobService();
  private CodeService codeservice = CodeServiceimpl.getCodeService();
  private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if("list".equals(action)) {
			//查询所有
			dolist(request,response);
		}else if("editui".equals(action)) {
			//为添加准备下拉列表
			doeditui(request,response);
		}else if("updateJob".equals(action)) {
			//添加
			doUpdateJob(request,response);
		}else if("xiugai".equals(action)) {
			//按id查询岗位，修改的准备工作
			doXiugai(request,response);
		}else if("xiugai2".equals(action)) {
			//修改
			doRexiugai(request,response);
		}else if("dele".equals(action)) {
			//删除
			doDelect(request,response);
		}else if("tiaojian".equals(action)) {
			//岗位的条件查询
			doIfFind(request,response);
		}else if("employee".equals(action)) {
			//按岗位查询所有员工的信息
			doEmployee(request,response);
		}else if("zengjia".equals(action)) {
			//增加的岗位编号
			dofindAllcount(request,response);
		}else if("xiuganbh".equals(action)) {
			//修改的岗位编号
			dofindAllBh(request,response);
		}
	}
	
	//修改的岗位编号
	private void dofindAllBh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type =request.getParameter("job_type");
		String uid =request.getParameter("id");

		Integer job_type =StringUtil.string2Integer(type);
		Integer id =StringUtil.string2Integer(uid);
		Integer coun =0;
		
		coun=jobservice.findAllcount(job_type);
		jobservice.updatejob(coun,job_type, id);
		List<Job> joblist11 = new ArrayList<Job>();
		joblist11=jobservice.findByJob(id);
		
		//将数据保存的前台数据
		request.setAttribute("joblist11", joblist11);
		
		request.setAttribute("job_type", job_type);
		//转发
		request.getRequestDispatcher("/LAIeditWork.jsp").forward(request, response);
		
	}
	//增加的岗位编号
	private void dofindAllcount(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String type =request.getParameter("job_type");
		Integer job_type =StringUtil.string2Integer(type);
		Integer coun =0;
		coun=jobservice.findAllcount(job_type);
		request.setAttribute("coun", coun);
		//准备数据，下拉列表
		List<Code> codelist =new ArrayList<Code>();
		codelist =codeservice.findByType(Constant.JOB_TYPE);
		//共享数据
		request.setAttribute("job_type", job_type);
		request.setAttribute("codelist", codelist);
		request.getRequestDispatcher("/LAIaddWork.jsp").forward(request, response);	
	}
	/* 为添加准备下拉列表 */
	private void doeditui(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		//岗位编号
		Integer coun =1;
		request.setAttribute("coun", coun);
		//准备数据，下拉列表
		List<Code> codelist =new ArrayList<Code>();
		codelist =codeservice.findByType(Constant.JOB_TYPE);
		//共享数据
		Integer job_type=0;
		request.setAttribute("job_type", job_type);
		request.setAttribute("codelist", codelist);
		//转向
		request.getRequestDispatcher("/LAIaddWork.jsp").forward(request, response);	
	}
	/* 添加*/
	private void doUpdateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		String number =request.getParameter("job_number");
		String job_name=request.getParameter("job_name");
		String type=request.getParameter("job_type");
		String max=request.getParameter("job_max");
		
		// 数据转换
		Integer job_type =StringUtil.string2Integer(type);
		
		//封装数据
		Job insertJob =new Job();
		List<Job> jlist =new ArrayList<Job>();
		jlist=jobservice.findAllJob1();
		
		Boolean is=true;
		//判断岗位编号
					//1.岗位编号不能为空
					if(!StringUtil.isNull(number)) {	
						//2.岗位编号必须是纯数字
						if(number.matches("^\\d+$")) {
							Integer job_number = StringUtil.string2Integer(number);
							//循环遍历岗位变所有
							//3.在数据库中无论状态是否为0的岗位，他们的编号都不能重复。
							for (Job j : jlist) {
								if(j.getJob_number().equals(job_number)) {
									is = false;
									request.setAttribute("jmessage", "岗位编号重复");									
									break;
								}else {						
									insertJob.setJob_number(job_number);
								}
							}		
						}else {
							is = false;
							request.setAttribute("jmessage", "岗位编号必须是纯数字");		
						}	
					}else {
						is = false;
						request.setAttribute("jmessage", "岗位编号不能为空");			
				}
			
	//判断岗位名称是否为空
				if(!StringUtil.isNull(job_name)) {
					for(Job j:jlist) {
						if(j.getJob_name().equals(job_name)) {
							is = false;
							request.setAttribute("jmessage1", "岗位名称重复");									
							break;
						}else {
							insertJob.setJob_name(job_name);
						}
					}
				}else {
					is = false;
					request.setAttribute("jmessage1", "岗位名称不能为空");	
				}
				
	//不用判断岗位类型
		insertJob.setJob_type(job_type);
	//岗位编制人数
				if(max.matches("^\\d+$")) {
					Integer job_max =StringUtil.string2Integer(max);
					insertJob.setJob_max(job_max);
				}else {
					is = false;
					request.setAttribute("jmessage2", "岗位编制人数必须为数字");	
				}
		
		
	//判断每一个是否符合条件
		if(is) {
			jobservice.insertJob(insertJob);
			dolist(request,response);
		}else {
			doeditui(request,response);
		}
	}

	 /*删除  */	 
	private void doDelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		String id1=request.getParameter("deid");
		String man=request.getParameter("jobman");
		
		//调用工具类，进行类型转换
		Integer id=StringUtil.string2Integer(id1);
		Integer job_man =StringUtil.string2Integer(man);
		
		//如果岗位人数为0，才可以将岗位删除
		if(job_man ==0) {
			jobservice.DeleteJob(id);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("message", "此岗位人数不为0，不可以删除");			
		}
		
		//转发
		request.getRequestDispatcher("/job/JobServlet.action?action=list").forward(request, response);
	}

	/* 修改*/
	private void doRexiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		String number =request.getParameter("job_number");
		String job_name=request.getParameter("job_name");
		String type=request.getParameter("job_type");
		String max=request.getParameter("job_max");
		String id1=request.getParameter("id");
		
		//调用工具类，进行类型转换
		Integer job_number=StringUtil.string2Integer(number);
		Integer job_type =StringUtil.string2Integer(type);
		Integer id=StringUtil.string2Integer(id1);
		
		Boolean is=true;
		List<Job> jlist =new ArrayList<Job>();
		jlist=jobservice.findAllJob1();
		
		
		//封装数据
		Job insertJob =new Job();
		insertJob.setJob_number(job_number);
		
		//判断岗位名称是否为空
		if(!StringUtil.isNull(job_name)) {	
			insertJob.setJob_name(job_name);
		}else {
			is = false;
			request.setAttribute("jmessage1", "岗位名称不能为空");	
		}
				
		//不用判断岗位类型
		insertJob.setJob_type(job_type);
		//岗位编制人数
		if(!StringUtil.isNull(max)) {
			if(max.matches("^\\d+$")) {
				List<Job> joblist11 = new ArrayList<Job>();
				joblist11=jobservice.findByJob(id);
				Integer job_max =StringUtil.string2Integer(max);
				if(joblist11.get(0).getJob_man()<=job_max) {
					insertJob.setJob_max(job_max);
				}else {
					is = false;
					request.setAttribute("jmessage2", "岗位编制人数必须大于等于岗位所在人数");	
				}
			}else {
				is = false;
				request.setAttribute("jmessage2", "岗位编制人数必须为数字");	
			}
		}else {
			is = false;
			request.setAttribute("jmessage2", "岗位编制人数不能为空");	
		}
		
		//判断每一个是否符合条件
		if(is) {
			jobservice.UpdateJob(insertJob,id);		
			dolist(request,response);
		}else {
			doXiugai(request,response);
		}
	}

	/* 查询所有*/
	private void dolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//准备数据
		Job job =new Job();
		//计算在岗人数
		jobservice.JobCount();
		List<Job> joblist = new ArrayList<Job>();
		joblist=jobservice.findAllJob();
		//共享数据
		request.setAttribute("joblist", joblist);
//		System.out.println(joblist.get(1).getJob_type_name());
		//转向
		request.getRequestDispatcher("/LAIworkList.jsp").forward(request, response);
	}
	
	/* 条件查询*/
	private void doIfFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		String number =request.getParameter("job_number");
		String job_name =request.getParameter("job_name");
		String type =request.getParameter("job_type");
		
		//调用工具类，进行数据转换
		Integer job_number=StringUtil.string2Integer(number);
		Integer job_type=StringUtil.string2Integer(type);
		
		//数据的封装
		Job insertJob =new Job();
		insertJob.setJob_number(job_number);
		insertJob.setJob_name(job_name);
		insertJob.setJob_type(job_type);
		
		//调用条件查询的方法，将传回的数据放入List集合中
		List<Job> joblist22 = new ArrayList<Job>();
		joblist22=jobservice.findJobIf(insertJob);
		
		//将数据共享到下一个网页
		request.setAttribute("joblist", joblist22);
		
		//转发
		request.getRequestDispatcher("/LAIworkList.jsp").forward(request, response);

	}

	 /*按id查询岗位，修改的准备工作*/
	private void doXiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//获取前台数据
		String job_id=request.getParameter("id");
		Integer id=StringUtil.string2Integer(job_id);
		
		//岗位编号
		Integer coun =1;
		request.setAttribute("coun", coun);
		
		//调用岗位的方法
		List<Job> joblist11 = new ArrayList<Job>();
		joblist11=jobservice.findByJob(id);
		
		//将数据保存的前台数据
		request.setAttribute("joblist11", joblist11);
		
		//转发
		request.getRequestDispatcher("/LAIeditWork.jsp").forward(request, response);
	}
	
	//按岗位查询所有员工的信息
	private void doEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//获取前端数据
			String job_number =request.getParameter("job_number");
			//调用工具类，进行类型转换
			Integer number=StringUtil.string2Integer(job_number);
			//调用dao层的方法，查询所有
			List<Employee> emp=new ArrayList<Employee>();
			 emp= employeeservice.findByJob(number);
			 //将得到的数据转发的下一个界面
			 request.setAttribute("emp", emp);
			//转向
			request.getRequestDispatcher("/LAIapartEmployee.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
