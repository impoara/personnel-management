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
import com.neuedu.personnel.bean.Job_change;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.Dep_changeService;
import com.neuedu.personnel.service.DeptService;
import com.neuedu.personnel.service.DomissionService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.JobService;
import com.neuedu.personnel.service.Job_changeService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.Dep_changeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DeptServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DomissionServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.JobServiceimpl;
import com.neuedu.personnel.service.serviceimpl.Job_changeServiceimpl;
import com.neuedu.personnel.utils.StringUtil;

/**
 * Servlet implementation class Job_changeServlet
 */
//岗位调动
@WebServlet("/Job_changeServlet.action")
public class Job_changeServlet extends HttpServlet {

	private DeptService deptservice =DeptServiceimpl.getDeptService();
	private JobService jobservice =JobServiceimpl.getJobService();
	private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
	private CodeService codeservice = CodeServiceimpl.getCodeService();
	private DomissionService domissionservice =DomissionServiceimpl.getDomissionService();
	private Dep_changeService depchangservice =Dep_changeServiceimpl.getEmployeeService();
	private Job_changeService jobchangeservice =Job_changeServiceimpl.getjobservice();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if("findAllEmp".equals(action)) {
			//查询所有
			dofindAllEmp(request,response);
		}else if("changezhubei".equals(action)) {
			//修改的准备工作，回显
			doChangezhunbei(request,response);
		}else if("change".equals(action)) {
			//进行修改
			doChange(request,response);
		}else if("findAllzhunbei".equals(action)) {
			//查询所有的准备工作(修改)
			doFindAllzhunbei(request,response);
		}else if ("findallcjob".equals(action)) {
			//查询所有已调动
			doFindAllCjod(request, response);
		} else if ("findOnech".equals(action)) {
			//条件查询已调动
			doFindOnech(request, response);
		}else if("selectif".equals(action)) {
			//调动条件查询
			doSelectif(request, response);	
		}else if("list".equals(action)) {
			 //调动显示岗位名称
			dolist(request, response);	
		}else if("findallzhunbei".equals(action)) {
			//查询所有准备工作
			doFindAllZhunbei(request,response);	
		}
		
	
	
	}

	//查询所有准备工作
	private void doFindAllZhunbei(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 准备数据
				Employee emp=new Employee();
				List<Employee> empList=new ArrayList<Employee>();
				List<Employee> empList0=new ArrayList<Employee>();
			
				Integer p=1;
				emp.setPage(p);
				
				empList=employeeservice.finAllPage(emp);
				//查找有几条信息
				empList0=employeeservice.finAllEmp(emp);
				Integer count=0;
				for (Employee e : empList0) {
					count = e.getPagecoun();
				}
				Integer pagecount=0;
				if(count%10 == 0) {
					pagecount = count/10;
				}else {
					pagecount = count/10 + 1;
				}
				Integer pa=1;
			//员工编号
					HttpSession session=request.getSession();
				List<Dept> deptlist = deptservice.findAllDept();
					
				session.setAttribute("deptlist", deptlist);
				List<Job> joblist = jobservice.findAllJob();
				session.setAttribute("joblist", joblist);
				//共享数据
				request.setAttribute("pa", pa);
				request.setAttribute("empList", empList);
				request.setAttribute("pagecount", pagecount);
				//转向				
				request.getRequestDispatcher("/gwdd.jsp").forward(request, response);	
	}


	//调动条件查询
	private void doSelectif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		//部门编号
		String job_number1 = request.getParameter("job_number");
//		String dept_name = request.getParameter("dept_name");
		String number=request.getParameter("em_number");
		String em_name=request.getParameter("em_name");
		
		//通过工具类将非空字符串转换成Integer
		Integer em_number=StringUtil.string2Integer(number);
        Integer job_number = StringUtil.string2Integer(job_number1);
        
		//数据封装
        Employee employee=new Employee();
		Job j=new Job();
		employee.setEm_number(em_number);
		employee.setEm_name(em_name);
        j.setJob_number(job_number);
//		j.setDept_name(dept_name);
        employee.setJob(j);
     
        //调用方法，共享数据
		List<Employee> joblist = new ArrayList<Employee>();
		joblist = jobchangeservice.finOne(employee);
		request.setAttribute("empList", joblist);
		//转向
		request.getRequestDispatcher("/gwdd.jsp").forward(request, response);
	}

    //调动显示岗位名称
	private void dolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Job> jobList = jobservice.findAllJob();
		//共享数据
		HttpSession session=request.getSession();
		//共享数据
		session.setAttribute("joblist", jobList);
		//转向
		request.getRequestDispatcher("/Job_changeServlet.action?action=selectif").forward(request, response);
	}

	/*
	 * 条件查询已调动
	 */
	private void doFindOnech(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取前台数据
		String number = request.getParameter("em_number");
		String em_name = request.getParameter("em_name");
		String job_chreason = request.getParameter("job_chreason");
		String indate = request.getParameter("em_indate");
		String lzdate =request.getParameter("lz_date");

		// 数据转型
		Integer em_number = StringUtil.string2Integer(number);
	
	
		// 数据封装
		Job_change j = new Job_change();
		Employee emp = new Employee();
		Domission dom=new Domission();
		emp.setEm_number(em_number);
		emp.setEm_name(em_name);
		j.setJob_chreason(job_chreason);
		if (indate != null && !"".equals(indate)) {
			Date em_indate = StringUtil.string2Date(indate);
			emp.setEm_indate(em_indate);
		}
		if (lzdate != null && !"".equals(lzdate)) {
			Date lz_date = StringUtil.string2Date(lzdate);
			dom.setLz_date(lz_date);
		}		
		j.setDom(dom);
		j.setEmp(emp);
		

		List<Job_change> cJobList = new ArrayList<Job_change>();
		cJobList = jobchangeservice.findOnech(j);
		request.setAttribute("cJobList", cJobList);

		request.getRequestDispatcher("/LAIchangeList.jsp").forward(request, response);
	}

	/*
	 * 查询所有已调动
	 */
	private void doFindAllCjod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Job_change> cJobList = new ArrayList<Job_change>();
		Job_change cJob = new Job_change();
		
		cJobList = jobchangeservice.findAllCjod(cJob);

		request.setAttribute("cJobList", cJobList);

		request.getRequestDispatcher("/LAIchangeList.jsp").forward(request, response);

	}

	//查询所有的准备工作(修改)
	private void doFindAllzhunbei(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 部门list
				Dept dept = new Dept();
				DeptService deptService = DeptServiceimpl.getDeptService();
				List<Dept> deptList = new ArrayList<Dept>();
				deptList = deptService.findAllDept();
				request.setAttribute("deptList", deptList);
				// 岗位list
				Job job = new Job();
				JobService jobService = JobServiceimpl.getJobService();
				List<Job> jobList = new ArrayList<Job>();
				jobList = jobService.findAllJob();
				request.setAttribute("jobList", jobList);
			
				request.getRequestDispatcher("/Job_changeServlet.action?action=findallzhunbei").forward(request, response);	
	}
	
	//进行修改
	private void doChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("emid");
		String emnumber = request.getParameter("em_number");
		String em_name = request.getParameter("em_name");
		String job_chreason = request.getParameter("job_chreason");
		String jobchtype = request.getParameter("job_chtype");
		String jobchdate = request.getParameter("job_chdate");
		String job_chextra = request.getParameter("job_chextra");
		String jobchnumber = request.getParameter("job_chnumber");
			
		// 转为integer
				Integer id = StringUtil.string2Integer(uid);
				Integer job_chtype = StringUtil.string2Integer(jobchtype);
				Integer em_number = StringUtil.string2Integer(emnumber);
				Integer job_chnumber = StringUtil.string2Integer(jobchnumber);

				// 根据员工编号，查找的员工信息
				// 查找旧的部门所有内容
				Employee emp1 = new Employee();
				emp1 = employeeservice.findByEmpDept(em_number);
				// 旧的岗位名称
				emp1.getJob().getJob_name();
				// 旧的岗位编号
				emp1.getJob().getJob_number();
				// 查找新部门的所有内容
				Job job2 = new Job();
				job2 = jobservice.findIdJob(job_chnumber);
				// 新的岗位名称
				job2.getJob_name();
				// 新的岗位编号
				// System.out.println(job_chnumber);

				// 封装数据
				Job_change job = new Job_change();

				job.setJob_chextra(job_chextra);
				job.setJob_chname(job2.getJob_name());
				job.setJob_chnumber(job_chnumber);
				job.setJob_chreason(job_chreason);
				job.setJob_chtype(job_chtype);
				job.setJob_oldname(emp1.getJob().getJob_name());
				job.setEmp(emp1);

				boolean is = true;

				// 调动时间不能为空
				if (!StringUtil.isNull(jobchdate)) {
					// 调动日期格式是否错误
					if (jobchdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
						Date job_chdate = StringUtil.string2Date(jobchdate);
						job.setJob_chdate(job_chdate);
					} else {
						is = false;
						request.setAttribute("jcmessage", "调动日期格式错误");
					}
				} else {
					is = false;
					request.setAttribute("jcmessage", "调动日期不能为空");
				}

				// 判断每一个是否符合条件
				if (is) {
					// 判断部门改变的条件
					if (emp1.getJob().getJob_number() != job_chnumber) {
						Job jobman = new Job();
						// 按岗位编号查询
						jobman = jobservice.findIdJob(job_chnumber);
						// 新的岗位所在人数man1
						Integer man1 = jobman.getJob_man();
						if (emp1.getJob() != null && !StringUtil.isNull(emp1.getJob().getJob_number())) {
							// 旧的岗位所在人数
							Job jobmanold = new Job();
							jobmanold = jobservice.findIdJob(emp1.getJob().getJob_number());
							Integer man2 = jobmanold.getJob_man();
							man2--;
							// 旧部门减一
							jobservice.JobNumber(emp1.getJob().getJob_number(), man2);
							request.setAttribute("message", "修改成功");
						}	
						// 新的岗位最大人数
						Integer max = jobman.getJob_max();
						if (man1 < max) {
							// 修改
							jobchangeservice.UpdateJob(job_chnumber, id);
							// 新部门加一
							man1++;
							// 按岗位编号查找岗位人数
							jobservice.JobNumber(job_chnumber, man1);

							// 添加
							jobchangeservice.InsertJob(job);
						} else {
							request.setAttribute("message", "新岗位人数已满，修改失败");
						}
					}
					// 显示所有的准备工作

	         doFindAllzhunbei(request,response);
		}else {

			request.getRequestDispatcher("/Job_changeServlet.action?action=changezhubei&&id="+id+"").forward(request, response);
			doChangezhunbei(request,response);
		}

	
	}

	//修改的准备工作，回显
	private void doChangezhunbei(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uid = request.getParameter("id");
		Integer id = StringUtil.string2Integer(uid);
		
		//员工编号，员工名称
		Employee emp=new Employee();
		emp=domissionservice.findNumberEmp(id);
		request.setAttribute("emp", emp);
		request.setAttribute("emid", id);
		
		//调转后的岗位
		List<Job> joblist=jobservice.findAllJob();
		request.setAttribute("joblist", joblist);
		request.getRequestDispatcher("/yggw.jsp").forward(request, response);		
	}

	//查询所有
	private void dofindAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		
		// 准备数据
		Employee emp=new Employee();
		List<Employee> empList=new ArrayList<Employee>();
		List<Employee> empList0=new ArrayList<Employee>();
		
		String pc = request.getParameter("p");
		Integer p=StringUtil.string2Integer(pc);
		emp.setPage(p);
		Integer pa=p;
		empList=employeeservice.finAllPage(emp);
		//查找有几条信息
		empList0=employeeservice.finAllEmp(emp);
		Integer count=0;
		for (Employee e : empList0) {
			count = e.getPagecoun();
		}
		Integer pagecount=0;
		if(count%10 == 0) {
			pagecount = count/10;
		}else {
			pagecount = count/10 + 1;
		}
		
		List<Job> joblist = jobservice.findAllJob();
		request.setAttribute("joblist", joblist);
		//共享数据
		request.setAttribute("empList", empList);
		request.setAttribute("pa", pa);
		request.setAttribute("pagecount", pagecount);
		request.getRequestDispatcher("/gwdd.jsp").forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
