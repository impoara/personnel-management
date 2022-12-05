package com.neuedu.personnel.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dep_change;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Domission;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.Dep_changeService;
import com.neuedu.personnel.service.DeptService;
import com.neuedu.personnel.service.DomissionService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.JobService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.Dep_changeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DeptServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DomissionServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.JobServiceimpl;
import com.neuedu.personnel.utils.DButil;
import com.neuedu.personnel.utils.StringUtil;


@WebServlet("/Dep_changeServlet.action")
//部门调动
public class Dep_changeServlet extends HttpServlet {
	
	private DeptService deptservice =DeptServiceimpl.getDeptService();
	private JobService jobservice =JobServiceimpl.getJobService();
	private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
	private CodeService codeservice = CodeServiceimpl.getCodeService();
	private DomissionService domissionservice =DomissionServiceimpl.getDomissionService();
	private Dep_changeService depchangservice =Dep_changeServiceimpl.getEmployeeService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getParameter("action");
		if("findAllEmp".equals(action)) {
			//显示所有调动人员
			dofindAllEmp(request,response);
		}else if("changezhubei".equals(action)) {
			//修改的准备工作，回显
			doChangezhunbei(request,response);
		}else if("change".equals(action)) {
			//进行修改
			doChange(request,response);
		}else if("findAllDep_change".equals(action)) {
			//显示所有已调动人员
			doDep_change(request,response);
		}else if("selectif".equals(action)) {
			//岗位调动条件查询
			doselectif(request,response);
		}else if("selectif1".equals(action)) {
			//已调动部门条件查询
			doselectif1(request,response);
		}else if("list".equals(action)) {
			//调动显示部门名称
			dolist(request,response);
		}else if("list1".equals(action)) {
			//已调动显示部门名称
			dolist1(request,response);
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
	Integer pa=1;
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
	
	HttpSession session=request.getSession();
	List<Dept> deptlist = deptservice.findAllDept();
		
	session.setAttribute("deptlist", deptlist);
	List<Job> joblist = jobservice.findAllJob();
	session.setAttribute("joblist", joblist);
	//共享数据
	request.setAttribute("pagecount", pagecount);
	request.setAttribute("pa", pa);

	request.setAttribute("domList", empList);
	//转向
	request.getRequestDispatcher("/bmdd1.jsp").forward(request,response);
	}
//显示所有已调动人员
private void doDep_change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//准备数据
		List<Dep_change> changeList = new ArrayList<Dep_change>();
		changeList=depchangservice.findAllChange();
		//共享数据
		request.setAttribute("changeList", changeList);
		//转向
		request.getRequestDispatcher("/111.jsp").forward(request, response);
	
}

//显示所有调动人员
private void dofindAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	// 准备数据
			Employee emp=new Employee();
			List<Employee> empList=new ArrayList<Employee>();
			List<Employee> empList0=new ArrayList<Employee>();
			
			String pc = request.getParameter("p");
			Integer p=StringUtil.string2Integer(pc);
			Integer pa=p;
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
			
			
			List<Job> joblist = jobservice.findAllJob();
			request.setAttribute("joblist", joblist);
			//共享数据
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("pa", pa);
				//共享数据
				request.setAttribute("domList", empList);
				//转向
				request.getRequestDispatcher("/bmdd1.jsp").forward(request,response);		
		}

//岗位调动条件查询
private void doselectif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//获取前台数据
	//部门编号
	String dept_number1 = request.getParameter("dept_number");
//	String dept_name = request.getParameter("dept_name");
	String number=request.getParameter("em_number");
	String em_name=request.getParameter("em_name");
	
	//通过工具类将非空字符串转换成Integer
	Integer em_number=StringUtil.string2Integer(number);
    Integer dept_number = StringUtil.string2Integer(dept_number1);
    
	//数据封装
    Employee employee=new Employee();
	Dept p=new Dept();
	employee.setEm_number(em_number);
	employee.setEm_name(em_name);
    p.setDept_number(dept_number);
//	p.setDept_name(dept_name);
    employee.setDept(p);
 
    //调用方法，共享数据
	List<Employee> deptlist = new ArrayList<Employee>();
	deptlist = depchangservice.findOne(employee);
	request.setAttribute("domList", deptlist);
	//转向
	request.getRequestDispatcher("/bmdd1.jsp").forward(request, response);
}

//已调动部门条件查询
private void doselectif1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//获取数据
	String number=request.getParameter("em_number");
	String em_name=request.getParameter("em_name");
	String emindate = request.getParameter("em_indate");
	String lzdate = request.getParameter("lz_date");
	
	//通过工具类将非空字符串转换成Integer
	Integer em_number=StringUtil.string2Integer(number);
	
	//封装数据
	Domission dom = new Domission();
	Dep_change dep=new Dep_change();
	Employee employee=new Employee();
	
	employee.setEm_number(em_number);
	employee.setEm_name(em_name);
	
	///判断日期是否为空
	if (emindate != null && !"".equals(emindate)) {
		Date em_indate = StringUtil.string2Date(emindate);
		employee.setEm_indate(em_indate);
	}
	if (lzdate != null && !"".equals(lzdate)) {
		Date lz_date = StringUtil.string2Date(lzdate);
		dom.setLz_date(lz_date);
	}
	
	dep.setDom(dom);
	dep.setEmp(employee);
	//调用方法
	List<Dep_change> depc=new ArrayList<Dep_change>();
	depc=depchangservice.findchange(dep);
	//共享数据
	request.setAttribute("changeList", depc);
	//转向
	request.getRequestDispatcher("/111.jsp").forward(request, response);
	
}

//调动显示部门名称
private void dolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//调用方法
			List<Dept> deptlist = deptservice.findAllDept();
			//共享数据
			HttpSession session=request.getSession();
			session.setAttribute("deptlist", deptlist);
//			Job job=new Job();
//			List<Job> jobList = jobService.findAllJob(job);
//			//共享数据
//			session.setAttribute("joblist", jobList);
			//转向
			request.getRequestDispatcher("/Dep_changeServlet.action?action=selectif").forward(request, response);
		}

//已调动显示部门名称
private void dolist1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//调用方法
			List<Dept> deptlist = deptservice.findAllDept();
			//共享数据
			HttpSession session=request.getSession();
			session.setAttribute("deptlist", deptlist);
			//转向
			request.getRequestDispatcher("/Dep_changeServlet.action?action=selectif1").forward(request, response);
		}

//进行修改
private void doChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String uid = request.getParameter("id");
		String emnumber = request.getParameter("em_number");
		String deptafter = request.getParameter("dept_after");
		
		Integer id1 = StringUtil.string2Integer(uid);
		Integer em_number = StringUtil.string2Integer(emnumber);//员工编号
		Integer dept_after = StringUtil.string2Integer(deptafter);
		
		String deptchtype = request.getParameter("dept_chtype");
		String deptchdate = request.getParameter("dept_chdate");
		String dept_chreason = request.getParameter("dept_chreason");
		String dept_extra = request.getParameter("dept_extra");
		
		Integer dept_chtype = StringUtil.string2Integer(deptchtype);

		
		//根据员工编号，查找的员工信息
		Employee emp1=new Employee();
		emp1=employeeservice.findByEmpDept(em_number);
//		Integer bumenId=emp1.getId();
		
		//存入
		Dep_change depc=new Dep_change();
		Dept dbefore =new Dept();
		Dept dafter =new Dept();
		
		depc.setId(id1);

		depc.setDept_chreason(dept_chreason);
		depc.setDept_chtype(dept_chtype);
		depc.setDept_extra(dept_extra);
		
		
		if(emp1.getDept().getDept_number()!=null) {	
		//jiu部门编号
		dbefore.setDept_number(emp1.getDept().getDept_number());
		depc.setDept_before(dbefore);
	
		}
		
		depc.setEmp(emp1);
		//xin部门编号
		dafter.setDept_number(dept_after);
		
		depc.setDept_after(dafter);
		
		
		boolean is=true;
		
		//调动时间
		if(!StringUtil.isNull(deptchdate)) {
			if(deptchdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
				 Date dept_chdate=StringUtil.string2Date(deptchdate);
				 depc.setDept_chdate(dept_chdate);
		    }else {
				is=false;
				request.setAttribute("dcmessage", "调动日期格式错误");
		    }
		}else {
			is=false;
			request.setAttribute("dcmessage", "调动日期不能为空");
		}
		
		if(is) {

			//修改员工编号
			depchangservice.domUpdate(dept_after, id1);
			//完成增加部门调动表中的内容
			depchangservice.InsertDep(depc);
			doFindAllZhunbei(request,response);	
		}else {
			doChangezhunbei(request,response);
		}

	}

//修改的准备工作，回显
private void doChangezhunbei(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String uid = request.getParameter("id");
		Integer id = StringUtil.string2Integer(uid);
		
		//员工编号，员工名称
		Employee emp=new Employee();
		emp=domissionservice.findNumberEmp(id);
		request.setAttribute("emp", emp);
		
		//调转后的部门
		List<Dept> deptlist=deptservice.findAllDept();
		request.setAttribute("deptlist", deptlist);
		
		request.getRequestDispatcher("/ygbm.jsp").forward(request, response);
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
