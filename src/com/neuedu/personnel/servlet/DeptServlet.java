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

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.DeptService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DeptServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.utils.Constant;
import com.neuedu.personnel.utils.StringUtil;
//部门

@WebServlet("/dept/DeptServlet.action")
public class DeptServlet extends HttpServlet {
	private DeptService deptservice =DeptServiceimpl.getDeptService();
	private CodeService codeservice = CodeServiceimpl.getCodeService();
	private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if("list1".equals(action)) {
			//查询所有
			doList1(request,response);
		}else if("editui".equals(action)) {
			//为增加准备下拉列表
			doEditui(request,response);
		}else if("insertdept".equals(action)) {
			//增加
			doInsertdep(request,response);
		}else if("update".equals(action)) {
			//按id查询，修改的准备工作
			doFindByiddept(request,response);
		}else if("update11".equals(action)) {
			//修改
			doUpdate(request,response);
		}else if("delete".equals(action)) {
			//删除
			doDelDate(request,response);
		}else if("selectif".equals(action)) {
			//条件查询
			doSelete(request,response);
		}else if("deptif".equals(action)) {
			//按部门查询员工信息
			doDeptIf(request,response);
		}
		
		
	}

	/* 添加*/
	private void doInsertdep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
		String number=request.getParameter("dept_number");
		String dept_name=request.getParameter("dept_name");
		String type=request.getParameter("dept_type");
		String dept_tel=request.getParameter("dept_tel");
		String dept_fax=request.getParameter("dept_fax");
		String dept_desc=request.getParameter("dept_desc");
		String super1=request.getParameter("dept_super");
		String setdate=request.getParameter("dept_setdate");

		//调用方法，数据转换
		Integer dept_number=StringUtil.string2Integer(number);
		Integer dept_type=StringUtil.string2Integer(type);
		Integer dept_super=StringUtil.string2Integer(super1);
		
		//封装数据
				Dept insertdept=new Dept();
				Dept p=new Dept();
				List<Dept> dlist=new ArrayList<Dept>();
				dlist=deptservice.finAllDept1(insertdept);
				
				p.setId(dept_super);
				insertdept.setDept_type(dept_type);
				
				insertdept.setDept_desc(dept_desc);
				insertdept.setDept_super(p);
				//设置布尔变量 来控制是否成功
				boolean is = true;
				//1.部门编号不能为空
				if(!StringUtil.isNull(number)) {	
					//2.部门编号必须是纯数字
					if(number.matches("^\\d+$")) {
						Integer dept_num = StringUtil.string2Integer(number);
						//循环遍历岗位变所有
						//3.在数据库中无论状态是否为0的部门，他们的编号都不能重复。
						for (Dept d : dlist) {
							if(!dept_num.equals(d.getDept_number())) {
								insertdept.setDept_number(dept_num);						
							}else {				
								is = false;
								request.setAttribute("dmessage", "部门编号重复");									
								break;
							}
						}		
					}else {
						is = false;
						request.setAttribute("dmessage", "部门编号必须是纯数字");		
					}
								
				}else {
					is = false;
					request.setAttribute("dmessage", "编号不能为空");			
				}

				//部门名称不能为空
				if(!StringUtil.isNull(dept_name)) {
					insertdept.setDept_name(dept_name);
					for (Dept d : dlist) {
						if(!dept_name.equals(d.getDept_name())) {
							insertdept.setDept_name(dept_name);						
						}else {				
							is = false;
							request.setAttribute("d1message", "部门名称重复");									
							break;
						}
					}		
				}else {
					is = false;
					request.setAttribute("d1message", "部门名称不能为空");	
				}	
				
				//电话不能为空
				if(!StringUtil.isNull(dept_name)) {
					//判断电话格式
					String tel = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
					if("13999999999".matches(tel)) {
						insertdept.setDept_tel(dept_tel);
					}else {
						request.setAttribute("d3message", "电话号码错误");
					}
					
				}else {
					is = false;
					request.setAttribute("d3message", "电话不能为空");	
				}	
				
				//传真号
				if(!StringUtil.isNull(dept_fax)) {
					String fax = "^(\\d{3,4}-)?\\d{7,8}$";
					if(dept_fax.matches(fax)) {
						insertdept.setDept_fax(dept_fax);
					}else {
						request.setAttribute("d4message","传真号码错误");
					}
				}
					
				//成立日期
				if(setdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
					Date date =StringUtil.string2Date(setdate);
					insertdept.setDept_setdate(date);
				}else {
					is=false;
					request.setAttribute("d2message", "日期格式错误");
				}
						
						if(is) {
							deptservice.insertDept(insertdept);
							doList1(request,response);
						}else {
							doEditui(request,response);
						}
		
	}
	
	/* 删除  */
	private void doDelDate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
			//获取前台数据
			Integer id=Integer.parseInt(request.getParameter("id"));
			
			//判断要删除的部门是否有数据
			Boolean boo=false;
			String message="";
			boo=deptservice.DeleteDept(id);
			if(boo==true) {
				deptservice.DeleteDate(id);
				message="删除成功";
			}else {
				message="不能删除";
			}
			
			//转发数据
			HttpSession session=request.getSession();
			session.setAttribute("message", message);
			//转发
			request.getRequestDispatcher("/dept/DeptServlet.action?action=list1").forward(request, response);
			
		}

	/* 修改 */
	private void doUpdate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
		//获取前台数据
		Integer uid=Integer.parseInt(request.getParameter("id"));
		String number=request.getParameter("dept_number");
		String dept_name=request.getParameter("dept_name");
		String type=request.getParameter("dept_type");
		String dept_tel=request.getParameter("dept_tel");
		String dept_fax=request.getParameter("dept_fax");
		String dept_desc=request.getParameter("dept_desc");
		String super1=request.getParameter("dept_super");
		String setdate=request.getParameter("dept_setdate");
		
		//数据转换
		Integer dept_number=StringUtil.string2Integer(number);
		Integer dept_type=StringUtil.string2Integer(type);
		Integer dept_super=StringUtil.string2Integer(super1);
		
		//封装数据
				Dept updatedept=new Dept();
				Dept d=new Dept();
				boolean is = true;
			       //部门名称不能为空
					if(!StringUtil.isNull(dept_name)) {
						updatedept.setDept_name(dept_name);					
					}else {
						is = false;
						request.setAttribute("d1message", "部门名称不能为空");	
					}	
					
					updatedept.setDept_tel(dept_tel);
					//电话不能为空
					if(!StringUtil.isNull(dept_tel)) {
						//判断电话格式
						String tel ="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
						if(dept_tel.matches(tel)) {
						}else {
							is = false;
							request.setAttribute("d3message", "电话号码错误");
						}
						
					}else {
						is = false;
						request.setAttribute("d3message", "电话不能为空");	
					}	
					System.out.println(updatedept.getDept_tel());
					//传真号
					if(!StringUtil.isNull(dept_fax)) {
						String fax = "^(\\d{3,4}-)?\\d{7,8}$";
						if(dept_fax.matches(fax)) {
							updatedept.setDept_fax(dept_fax);
						}else {
							is = false;
							request.setAttribute("d4message","传真号码错误");
						}
					}else {
						is = false;
						request.setAttribute("d4message", "传真不能为空");	
					}	
					
					//成立日期
					if(setdate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
						Date date =StringUtil.string2Date(setdate);
						updatedept.setDept_setdate(date);
					
					}else {
						is=false;
						request.setAttribute("d2message", "日期格式错误");
					}
						
					d.setId(dept_super);
					updatedept.setDept_number(dept_number);
					updatedept.setDept_type(dept_type);
					updatedept.setDept_desc(dept_desc);
					updatedept.setDept_super(d);

					if(is) {
						deptservice.UpdateDept(updatedept, uid);
						doList1(request,response);
					}else {
						doFindByiddept(request,response);
					}


	}

	/* 按部门查询员工信息 */
	private void doDeptIf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//获取前台数据
		 String number=request.getParameter("number");
		 Integer dept_number=StringUtil.string2Integer(number);
		 
		 //调用查询的方法
		 List<Employee> employee=new ArrayList<Employee>();
		 employee=employeeservice.findByDept(dept_number);
		
		 //转发数据
		 request.setAttribute("employee", employee);
		//转向
		request.getRequestDispatcher("/search.jsp").forward(request, response);
		 
	}

	/* 条件查询 */
	private void doSelete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Dept dept=new Dept();
		List<Dept> selif=new ArrayList<Dept>();
		
		//获取前台数据
		String number=request.getParameter("dept_number");
		String dept_name=request.getParameter("dept_name");
		String type=request.getParameter("dept_type");
		
		//数据转换
		Integer dept_number=StringUtil.string2Integer(number);
		Integer dept_type=StringUtil.string2Integer(type);
		
		//封装数据
		dept.setDept_number(dept_number);
		dept.setDept_name(dept_name);
		dept.setDept_type(dept_type);
		
		//调用方法
		selif = deptservice.findDeptIf(dept);
		request.setAttribute("selif", selif);
		//转向
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	/* 按id查询 ，修改的准备工作*/
	private void doFindByiddept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取前台数据
		String uid=request.getParameter("id");
		Integer id=StringUtil.string2Integer(uid);
		
		//调用方法
		List<Dept> emplist = new ArrayList<Dept>();
		emplist=deptservice.findByDept(id);
		//转发
		request.setAttribute("emplist", emplist);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	/* 为增加准备下拉列表 */
	private void doEditui(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Code> codelist1 =new ArrayList<Code>();
		codelist1 =codeservice.findByType(Constant.DEPT_TYPE);//部门类型
		request.setAttribute("codelist1", codelist1);
		request.getRequestDispatcher("/add.jsp").forward(request, response);
	}

	 /* 查询所有 */
	private void doList1(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		List<Dept> deptlist = new ArrayList<Dept>();
		deptlist=deptservice.findAllDept();
		request.setAttribute("deptlist0", deptlist);
		
		HttpSession session=request.getSession();
		session.setAttribute("deptlist", deptlist);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
