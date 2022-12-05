package com.neuedu.personnel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.DeptService;
import com.neuedu.personnel.service.DomissionService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.JobService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DeptServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DomissionServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.JobServiceimpl;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;


@WebServlet("/DomissionServlet.action")
//离职信息
public class DomissionServlet extends HttpServlet {

	private DeptService deptservice =DeptServiceimpl.getDeptService();
	private JobService jobservice =JobServiceimpl.getJobService();
	private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
	private CodeService codeservice = CodeServiceimpl.getCodeService();
	private DomissionService domissionservice =DomissionServiceimpl.getDomissionService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if("findAllEmp".equals(action)) {
			//查询所有
			doFindall(request,response);
		}else if("domupdate".equals(action)) {
			//修改
			doDomupdate(request,response);
		}else if("findnumber".equals(action)) {
			//按id查询，回显  
			doFindnumber(request,response);
		}else if("findAllDom".equals(action)) {
			//为条件查询准备下来列表
			dofindAllDom(request,response);
		}else if("lizhifind".equals(action)) {
			//离职人员的条件查询
			dolizhiFind(request,response);
		}else if("zaizhifind".equals(action)) {
			//在职人员的条件查询
			dozaizhiFind(request,response);
		}
		
		
		
	}
	
	/*
	 * 在职人员的条件查询
	 */
	private void dozaizhiFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取前台数据
				String deptnumber = request.getParameter("dep_number");
				String deptname = request.getParameter("dept_name");
				String emtype = request.getParameter("em_type");
				String emnumber = request.getParameter("em_number");
				//数据转型
				Integer dept_number = StringUtil.string2Integer(deptnumber);
				Integer em_number = StringUtil.string2Integer(emnumber);
				//数据封装
				Employee emp = new Employee();
				Dept d = new Dept();
				d.setDept_number(dept_number);
				d.setDept_name(deptname);
				emp.setEm_number(em_number);
				emp.setDept(d);
				
				List<Employee> domList = new ArrayList<Employee>();
				domList = domissionservice.zaizhiFind(emp);
				request.setAttribute("domList", domList);
				request.getRequestDispatcher("/Tn_Separationsearch1.jsp").forward(request, response);
	}
	/*
	 * 离职人员的条件查询
	 */
	private void dolizhiFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取前台数据
				String emnumber = request.getParameter("em_number");
				String emname = request.getParameter("em_name");
				String jobname = request.getParameter("job_name");
				String deptname = request.getParameter("dept_name");
				String emindate = request.getParameter("em_indate");
				String lzdate = request.getParameter("lz_date");
				String lztype = request.getParameter("lz_type");
				//类型转换
				Integer em_number = StringUtil.string2Integer(emnumber);
				Integer lz_type = StringUtil.string2Integer(lztype);
				
				//封装数据
				Domission dom = new Domission();
				Dept d=new Dept();
				Job j = new Job();
				Employee e = new Employee();
				e.setEm_number(em_number);
				e.setEm_name(emname);
				j.setJob_name(jobname);
				j.setJob_name(jobname);	
				d.setDept_name(deptname);
				dom.setLz_type(lz_type);
				dom.setEmp(e);
				dom.setJob(j);
				dom.setDept(d);

				if (emindate != null && !"".equals(emindate)) {
					Date em_indate = StringUtil.string2Date(emindate);
					e.setEm_indate(em_indate);
				}
				if (lzdate != null && !"".equals(lzdate)) {
					Date lz_date = StringUtil.string2Date(lzdate);
					dom.setLz_date(lz_date);
				}
				List<Domission> domissionList = new ArrayList<Domission>();
				domissionList = domissionservice.lizhiFind(dom);
				request.setAttribute("domissionList", domissionList);
				
				request.getRequestDispatcher("/Tn_SeparationSearch.jsp").forward(request, response);
	}
/* 为条件查询准备下来列表 */
	private void dofindAllDom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 准备数据
		List<Domission> domissionList=new ArrayList<Domission>();
		domissionList=domissionservice.finAllDom();
		//共享数据
		
		request.setAttribute("domissionList", domissionList);
		//转向
		request.getRequestDispatcher("/Tn_SeparationSearch.jsp").forward(request,response);
		
	}

	/* 按id查询，回显  */
	private void doFindnumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 String uid = request.getParameter("id");
		 Integer id = StringUtil.string2Integer(uid);
		 
		 Employee domList1=new Employee();
		 domList1= domissionservice.findNumberEmp(id);
		 
			 HttpSession session=request.getSession();
			 session.setAttribute("domList1", domList1);
			
				//转向
				request.getRequestDispatcher("/Tn_SeparationEvaluation.jsp").forward(request,response);
		
	}

	/*  修改 */
	private void doDomupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		  String id = request.getParameter("em_id");
		  String type = request.getParameter("lz_type");
		  String date = request.getParameter("lz_date");
		  String lz_go = request.getParameter("lz_go");
		  String dept_name=request.getParameter("dept_name");
		  
	      Integer em_id = StringUtil.string2Integer(id);

	      Integer lz_type = StringUtil.string2Integer(type);
	  
	      
	      Domission domission =new Domission();
	      domission.setId(em_id);
	  
	      domission.setLz_go(lz_go);
	      domission.setLz_type(lz_type);
	 
	      boolean is=true;
			//离职日期
			if(!StringUtil.isNull(date)) {
				if(date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
					Date lz_date = StringUtil.string2Date(date);
					domission.setLz_date(lz_date);
			    }else {
					is=false;
					request.setAttribute("dommessage", "离职日期格式错误");
			    }
			}else {
				is=false;
				request.setAttribute("dommessage", "离职日期不能为空");
			}
	      
			if(is) {
			      
				//添加	      
					      domissionservice.domInsert(domission);
//					     
					if(!StringUtil.isNull(dept_name)) {
						
				
					      //调用按id查询的方法，得到job_number
						Employee domList1=new Employee();
					     domList1 =domissionservice.findNumberEmp(em_id);
					     Integer job_number=domList1.getJob().getJob_number();

					      //修改前岗位所在人数
					      Job job = new Job();
					      job=  jobservice.findIdJob(job_number);
					      Integer man= job.getJob_man();
					      System.out.println(man);
					      //岗位最大人数
					      Integer max= job.getJob_max();
					      System.out.println(max);
					      man--;
				     	  //岗位人数减少一
				     	  jobservice.JobNumber(job_number, man);
					}
				    	  //修改
					      domissionservice.domUpdate(em_id);
				     	 
				     	  request.setAttribute("message", "离职成功");
					     	 
			  	  doFindall(request,response);
			}else {
				request.getRequestDispatcher("/DomissionServlet.action?action=findnumber&&id="+id+"").forward(request, response);
			}

	}


	/* 查询所有 */
	private void doFindall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			// 准备数据
			List<Employee> domList=new ArrayList<Employee>();
			domList=domissionservice.finAllEmp();
			//共享数据
			HttpSession session=request.getSession();
			session.setAttribute("domList", domList);
			
			//转向
			request.getRequestDispatcher("/Tn_Separationsearch1.jsp").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
