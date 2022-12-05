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
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.bean.Job;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.DeptService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.JobService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.DeptServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.JobServiceimpl;
import com.neuedu.personnel.utils.StringUtil;
//员工表
@WebServlet("/Employee.action")
public class EmployeeServlet extends HttpServlet {
	
	private DeptService deptservice =DeptServiceimpl.getDeptService();
	private JobService jobservice =JobServiceimpl.getJobService();
	private EmployeeService employeeservice=EmployeeServiceimpl.getEmployeeService();
	private CodeService codeservice = CodeServiceimpl.getCodeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if("insert".equals(action)) {
				//添加
			doInsert(request,response);
			}else if("list".equals(action)) {
				//添加,下拉列表
				doList(request,response);
			}else if("findall".equals(action)) {
				//查询所有
				doFindAll(request,response);
			}else if("updateid".equals(action)) {
				//按id查询，修改的回显
				doUpdateId(request,response);
			}else if("update".equals(action)) {
				//修改
				doUpdate(request,response);
			}else if("selectif".equals(action)) {
				//查询
				doselectIf(request,response);
			}else if("updateqian".equals(action)) {
				//按id查询数据，为删除准备数据
				doList1(request,response);
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
		
	//员工编号
			HttpSession session=request.getSession();
		List<Dept> deptlist = deptservice.findAllDept();
			
		session.setAttribute("deptlist", deptlist);
		List<Job> joblist = jobservice.findAllJob();
		session.setAttribute("joblist", joblist);
		//共享数据
		request.setAttribute("empList", empList);
		request.setAttribute("pa", pa);
		request.setAttribute("pagecount", pagecount);
		//转向
		request.getRequestDispatcher("/ygxx.jsp").forward(request,response);
		
	}

	/* 按id查询数据，为删除准备数据 */
	private void doList1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List<Dept> deptlist = deptservice.findAllDept();
		HttpSession session=request.getSession();
		session.setAttribute("deptlist", deptlist);
		List<Job> jobList = jobservice.findAllJob();
		
		//共享数据
		session.setAttribute("joblist", jobList);
		String uid = request.getParameter("id");
		Integer id = StringUtil.string2Integer(uid);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/Employee.action?action=updateid").forward(request, response);
	
	}
	/*查询*/
	private void doselectIf(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
				//准备数据
		
				List<Employee> selif=new ArrayList<Employee>();
				String number=request.getParameter("em_number");
				String em_name=request.getParameter("em_name");
				//岗位编号
				String job_number1 = request.getParameter("job_number");
				//部门编号
				String dept_number1 = request.getParameter("dept_number");
				
				
				//通过工具类将非空字符串转换成Integer
				Integer em_number=StringUtil.string2Integer(number);
				Integer job_number = StringUtil.string2Integer(job_number1);
		        Integer dept_number = StringUtil.string2Integer(dept_number1);
				//封装数据
				Employee employee=new Employee();
				Dept p=new Dept();
				Job j=new Job();
				employee.setEm_number(em_number);
				employee.setEm_name(em_name);
			    j.setJob_number(job_number);
		        p.setDept_number(dept_number);
		        employee.setDept(p);
		        employee.setJob(j);
		        
		        Integer pa=1;
				selif = employeeservice.findIfEmp(employee);
				request.setAttribute("empList", selif);
			
				//转向
			    request.getRequestDispatcher("/ygxx.jsp").forward(request, response);

		
	}

	/* 修改 */
	private void doUpdate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//获取前台数据
		String uid = request.getParameter("id");
		
		String e1number = request.getParameter("enumber");
		String number = request.getParameter("em_number");
		String em_name = request.getParameter("em_name");
		String birth = request.getParameter("em_birth");
		String isex = request.getParameter("sex");
		String em_id = request.getParameter("em_id");
		String indate = request.getParameter("em_indate");
		String worktime = request.getParameter("em_worktime");
		
		String format = request.getParameter("em_format");
		String source = request.getParameter("em_source");
		String polity = request.getParameter("em_polity");
		String folk = request.getParameter("em_folk");
		String em_birthplace = request.getParameter("em_birthplace");
		String em_phone = request.getParameter("em_phone");
		String em_mail = request.getParameter("em_mail");
		String em_stature= request.getParameter("em_stature");
		String blood = request.getParameter("em_blood");
		String wedlock = request.getParameter("em_wedlock");
		String em_seat = request.getParameter("em_seat");
		String learn = request.getParameter("em_learn");
		String degree = request.getParameter("em_degree");
		String em_graduate = request.getParameter("em_graduate");
		String em_homeplace = request.getParameter("em_homeplace");
		String gradate = request.getParameter("em_gradate");
		String em_specialty=request.getParameter("em_specialty");

		//新的岗位编号
		String job_number1 = request.getParameter("job_number");
		//部门编号
		String dept_number1 = request.getParameter("dept_number");
			
		 //封装数据
         Integer id = StringUtil.string2Integer(uid);
         Integer em_number = StringUtil.string2Integer(number);
         Integer sex = StringUtil.string2Integer(isex);
         Integer em_format = StringUtil.string2Integer(format);
         Integer em_source = StringUtil.string2Integer(source);
         Integer em_polity = StringUtil.string2Integer(polity);
         Integer em_folk = StringUtil.string2Integer(folk);
         Integer em_blood = StringUtil.string2Integer(blood);
         Integer em_wedlock = StringUtil.string2Integer(wedlock);
         Integer em_learn = StringUtil.string2Integer(learn);
         Integer em_degree = StringUtil.string2Integer(degree);
         Integer job_number = StringUtil.string2Integer(job_number1);
         Integer dept_number = StringUtil.string2Integer(dept_number1);
         Integer enumber =StringUtil.string2Integer(e1number);
         
         Job j =new Job();
         Dept p=new Dept();
         Employee employee =new Employee();
         employee.setEm_name(em_name);
         employee.setEm_number(em_number);
         employee.setSex(sex);
         employee.setEm_format(em_format);
         employee.setEm_source(em_source);
         employee.setEm_polity(em_polity);
         employee.setEm_folk(em_folk);
         employee.setEm_blood(em_blood);
         employee.setEm_wedlock(em_wedlock);
         employee.setEm_learn(em_learn);
         employee.setEm_degree(em_degree);
         employee.setEm_id(em_id);
         employee.setEm_birthplace(em_birthplace);
         employee.setEm_mail(em_mail);
         employee.setEm_homeplace(em_homeplace);
         employee.setEm_seat(em_seat);
         employee.setEm_graduate(em_graduate);
         employee.setEm_specialty(em_specialty);

         j.setJob_number(job_number);
//         j.setId(job_number);
         p.setDept_number(dept_number);
//         p.setId(dept_number);
         employee.setDept(p);
         employee.setJob(j);
         
       //设置布尔变量 来控制是否成功
	  		boolean is = true;
	  	  		    //员工名称不能为空
	  				if(!StringUtil.isNull(em_name)) {
	  					employee.setEm_name(em_name);
	  				}else {
	  					is = false;
	  					request.setAttribute("e1message", "员工名称不能为空");	
	  				}
	  				
	  				//出生日期不能为空
	  				if(!StringUtil.isNull(birth)) {
	  					//判断出生日期格式是否正确
	 	 				if(birth.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	 	 					 Date em_birth=StringUtil.string2Date(birth);
	 	 					 employee.setEm_birth(em_birth);
	 	 				}else {
	 	 					is=false;
	 	 					request.setAttribute("e2message", "出生日期格式错误");
	 	 				}
	  				}else {
	  					is=false;
	  					request.setAttribute("e2message", "出生日期不能为空");
	  				}

	  				//入职日期不能为空
	  				if(!StringUtil.isNull(indate)) {
	  					//入职日期是否错误
	 	 				if(indate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	 	 					if(!StringUtil.isNull(birth)) {
	 	 					Date em_birth=StringUtil.string2Date(birth);
	 	 					Date em_indate=StringUtil.string2Date(indate);
	 		 					if(em_birth.getTime()<em_indate.getTime()) {
	 		 				         employee.setEm_indate(em_indate);
	 		 					}else {
	 		 						is=false;
	 		 						request.setAttribute("e3message", "入职日期错误");
	 		 					}	
	 					    }
	 	 				}else {
	 						is=false;
	 						request.setAttribute("e3message", "入职日期格式错误");
	 					}
	  				}else {
	  					is=false;
	 					request.setAttribute("e3message", "入职日期不能为空");
	  				}
	  				
	  				//身份证号不能为空
	  				if(!StringUtil.isNull(em_id)) {
	 	 				String emId = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	 	 				//身份证号码格式是否错误
	 	 				if(em_id.matches(emId)) {
	 	 			         employee.setEm_id(em_id);
	 	 				}else {
	 	 					is=false;
	 						request.setAttribute("e4message", "身份证号格式错误"); 				
	 					}
	  				}else {
	  					is=false;
	 					request.setAttribute("e4message", "身份证号不能为空"); 	
	  				}

	  				//参加工作时间不能为空
	  				if(!StringUtil.isNull(worktime)) {
	 	 				if(worktime.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	 	 					//工作时间是否错误
	 	 					if(!StringUtil.isNull(indate)) {
	 	 						Date em_birth=StringUtil.string2Date(birth);
	 	 						Date em_indate=StringUtil.string2Date(indate);
	 	 						Date em_worktime=StringUtil.string2Date(worktime);
	 	 						//入职日期必须比工作日期早
	 	 						if(em_indate.getTime()>=em_worktime.getTime() && em_birth.getTime()<em_worktime.getTime()) {
	 		 						employee.setEm_worktime(em_worktime);
	 		 					}else {
	 		 						is=false;
	 		 						request.setAttribute("e5message", "参加工作日期必须大于出生日期和入职日期");
	 		 					}	
	 	 					}
	 	 				}else {
	 	 					is=false;
	 	 					request.setAttribute("e5message", "参加工作日期格式错误");
	 	 				}
	  				}else {
	  					is=false;
	  					request.setAttribute("e5message", "参加工作日期不能为空");
	  				}
	  				
	  				
	  				//毕业时间不能为空
	  				if(!StringUtil.isNull(gradate)) {
	  					//毕业时间格式是否错误
	 	 				if(gradate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
	 	 					 Date em_birth=StringUtil.string2Date(birth);
	 	 					 Date em_gradate=StringUtil.string2Date(gradate);
	 	 					 //出生日期必须比毕业时间早
	 	 					 if(em_birth.getTime()<em_gradate.getTime()) {
	 	 						employee.setEm_gradate(em_gradate);
	 	
	 	 					 }else {
	 	 						 is=false;
	 	 						request.setAttribute("e6message", "毕业日期必须大于出生日期");
	 	 					 }
	 					}else {
	 						is=false;
	 						request.setAttribute("e6message", "毕业日期格式错误");
	 					}
	  				}
	  			//身高
	  				String heigth = "^([0,1,2]\\d{2}(((cm)|(厘米))?))|([0,1,2].\\d{2,3}?((米|m)?))$";
	  				if(!StringUtil.isNull(em_stature)) {
	  					if(em_stature.matches(heigth)) {
	  						employee.setEm_stature(em_stature);
	  					}else {
		  					request.setAttribute("e8message", "身高必须是数字");
		  					is = false;
		  					
		  				}
	  				}

	  			//判断电话格式
	  				employee.setEm_phone(em_phone);
					String tel = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
					if(!StringUtil.isNull(em_phone)) {
						if(em_phone.matches(tel)) {
							
						}else {
							is = false;
							request.setAttribute("e7message", "电话号码错误");
						}
					}

	  				
	  				
	                if(is) {
	                	//新岗位所在人数man1
	  				  Job job = new Job();
	  				  job=  jobservice.findIdJob(job_number);
	  				  Integer man1= job.getJob_man();
	  				  System.out.println("新岗位所在人数"+man1);
	  				 
	  				 //旧岗位所在人数man2
	  				 	//按id查询
	  					List<Employee> emplist=new ArrayList<Employee>();
	  					emplist=employeeservice.findByEmp(id);
	  					Integer man2=emplist.get(0).getJob().getJob_man();
	  					Integer job_numberjiu=	emplist.get(0).getJob().getJob_number();
	  					System.out.println("旧岗位所在人数"+man1);
	  					
	  				     //岗位最大人数
	  				     Integer max= job.getJob_max();
	  				    
//	  				     if(man1<max) {
//	  				    	 if(job.getJob_number().equals(job_numberjiu)) {
//	  				    		
//	  				    	 }else {
//	  				    		 man1++;
//	  					    	 //新部门加一
//	  					    	 jobservice.JobNumber(job_number, man1);
//	  					    	 //旧部门减一
//	  					    	 man2--; 
//	  					    	 jobservice.JobNumber(job_numberjiu, man2);
//	  				    	 }
	  				    	//修改
	  				    	 employeeservice.UpdateEmp(employee, id); 
	  				    	 request.setAttribute("message", "修改成功");	 
//	      	 
//	  				    }else {
//	  				    request.setAttribute("message", "修改失败,新部门人数已满");
//	  	     	}
	  				    	
	               request.getRequestDispatcher("/Employee.action?action=findallzhunbei").forward(request, response);
	              }else {
	                	doUpdateId(request,response);
	                }
         
				 }

	/* 按id查询 ，修改的回显 */
	private void doUpdateId(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String uid= request.getParameter("id");
		 Integer id = StringUtil.string2Integer(uid);
		List<Employee> emplist=new ArrayList<Employee>();
		emplist=employeeservice.findByEmp(id);
		request.setAttribute("emplist", emplist);
		request.getRequestDispatcher("/xxxg.jsp").forward(request,response);
	}

	/* 查询所有 */
	private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pa", pa);
		//转向
		request.getRequestDispatcher("/ygxx.jsp").forward(request,response);

		
	}

	/* 准备下拉列表 */
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		//员工编号
		HttpSession session=request.getSession();
		List<Job> jobList = jobservice.findAllJob();
		List<Dept> deptlist = deptservice.findAllDept();
		
	   	Integer is=0;
	   	is=employeeservice.finAllEmpAll();
	   	
	  //共享数据
	   	session.setAttribute("is", is);
		session.setAttribute("deptlist", deptlist);
		session.setAttribute("joblist", jobList);

		request.getRequestDispatcher("/rzgl.jsp").forward(request, response);
	}

	/* 添加 */
	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取前台数据
		String number = request.getParameter("em_number");
		String em_name = request.getParameter("em_name");
		String em_sex = request.getParameter("sex");
		String birth = request.getParameter("em_birth");
		String em_id = request.getParameter("em_id");
		String indate = request.getParameter("em_indate");
		String worktime = request.getParameter("em_worktime");
		String format = request.getParameter("em_format");
		String source = request.getParameter("em_source");
		String polity = request.getParameter("em_polity");
		String folk = request.getParameter("em_folk");
	
		String em_birthplace = request.getParameter("em_birthplace");
		String em_phone = request.getParameter("em_phone");
		String em_mail = request.getParameter("em_mail");
		String em_stature= request.getParameter("em_stature");
		String blood = request.getParameter("em_blood");
		String wedlock = request.getParameter("em_wedlock");
		String em_homeplace = request.getParameter("em_homeplace");
		String em_seat = request.getParameter("em_seat");
		String learn = request.getParameter("em_learn");
		String degree = request.getParameter("em_degree");
		String em_graduate = request.getParameter("em_graduate");
		String em_specialty = request.getParameter("em_specialty");
		String gradate = request.getParameter("em_gradate");
		//岗位编号
		String job_number1 = request.getParameter("job_number");
		//岗位编号
		String dept_number1 = request.getParameter("dept_number");
     
		//数据转换
         Integer sex = StringUtil.string2Integer(em_sex);
         Integer em_format = StringUtil.string2Integer(format);
         Integer em_source = StringUtil.string2Integer(source);
         Integer em_polity = StringUtil.string2Integer(polity);
         Integer em_folk = StringUtil.string2Integer(folk);
         Integer em_blood = StringUtil.string2Integer(blood);
         Integer em_wedlock = StringUtil.string2Integer(wedlock);
         Integer em_learn = StringUtil.string2Integer(learn);
         Integer em_degree = StringUtil.string2Integer(degree);
         Integer job_number = StringUtil.string2Integer(job_number1);
         Integer dept_number = StringUtil.string2Integer(dept_number1);
         
         //封装数据
         Job j =new Job();
         Dept p=new Dept();
         Employee employee =new Employee();
         List<Employee> elist=new ArrayList<Employee>();
        
         employee.setSex(sex);
         employee.setEm_format(em_format);
         employee.setEm_source(em_source);
         employee.setEm_polity(em_polity);
         employee.setEm_folk(em_folk);
         employee.setEm_blood(em_blood);
         employee.setEm_wedlock(em_wedlock);
         employee.setEm_learn(em_learn);
         employee.setEm_degree(em_degree);
         employee.setEm_name(em_name);
        
         employee.setEm_birthplace(em_birthplace);
         employee.setEm_phone(em_phone);
         employee.setEm_mail(em_mail);
         employee.setEm_stature(em_stature);
         employee.setEm_homeplace(em_homeplace);
         employee.setEm_seat(em_seat);
         employee.setEm_graduate(em_graduate);
         employee.setEm_specialty(em_specialty);
         
         j.setJob_number(job_number);
//         j.setId(job_number);
         p.setDept_number(dept_number);
//         p.setId(dept_number);
         employee.setDept(p);
         employee.setJob(j);
         
         //设置布尔变量 来控制是否成功
  		boolean is = true;
         //1.员工编号不能为空
  		if(!StringUtil.isNull(number)) {	
      	//2.员工编号必须是纯数字
  			if(number.matches("^\\d+$")) {
  				Integer em_num = StringUtil.string2Integer(number);
  				employee.setEm_number(em_num);	
  				
  				//循环遍历岗位变所有
  				for (Employee e : elist) {
  					if(!em_num.equals(e.getEm_number())) {
  											
  					}else {				
  						is = false;
  						request.setAttribute("emessage", "员工编号重复");									
  						break;
  					}
  				}		
  			}else {
  				is = false;
  				request.setAttribute("emessage", "员工编号必须是纯数字");		
  			}
        	}else {
        		is = false;
 			request.setAttribute("emessage", "员工编号不能为空");		
        	}
  	//身高
			String heigth = "^([0,1,2]\\d{2}(((cm)|(厘米))?))|([0,1,2].\\d{2,3}?((米|m)?))$";
			if(!StringUtil.isNull(em_stature)) {
				if(em_stature.matches(heigth)) {
					employee.setEm_stature(em_stature);
				}else {
					request.setAttribute("e8message", "身高必须是数字");
					is = false;
					
				}
			}

  		
  		    //员工名称不能为空
  				if(!StringUtil.isNull(em_name)) {
  					employee.setEm_name(em_name);
  					for (Employee e : elist) {
  		                         //部门名称不能重复
  						if(!em_name.equals(e.getEm_name())) {
  							employee.setEm_name(em_name);						
  						}else {				
  							is = false;
  							request.setAttribute("e1message", "员工名称重复");									
  							break;
  						}
  					}		
  				}else {
  					is = false;
  					request.setAttribute("e1message", "员工名称不能为空");	
  				}
  				
  				
  				//出生日期
  				if(!StringUtil.isNull(birth)) {
 	 				if(birth.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
 	 					 Date em_birth=StringUtil.string2Date(birth);
 	 					 employee.setEm_birth(em_birth);
 	 				}else {
 	 					is=false;
 	 					request.setAttribute("e2message", "出生日期格式错误");
 	 				}
  				}else {
  					is=false;
  					request.setAttribute("e2message", "出生日期不能为空");
  				}

  				//入职日期
  				if(!StringUtil.isNull(indate)) {
 	 				if(indate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
 	 					if(!StringUtil.isNull(birth)) {
 	 					Date em_birth=StringUtil.string2Date(birth);
 	 					Date em_indate=StringUtil.string2Date(indate);
 		 					if(em_birth.getTime()<em_indate.getTime()) {
 		 				         employee.setEm_indate(em_indate);
 		 					}else {
 		 						is=false;
 		 						request.setAttribute("e3message", "入职日期错误");
 		 					}	
 					    }
 	 				}else {
 						is=false;
 						request.setAttribute("e3message", "入职日期格式错误");
 					}
  				}else {
  					is=false;
 					request.setAttribute("e3message", "入职日期不能为空");
  				}
  				
  				//身份证号
  				if(!StringUtil.isNull(em_id)) {
 	 				String emId = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
 	 				//身份证号码
 	 				//内有身份证号码http://www.jiayuanjx.cn/id/
 	 				if(em_id.matches(emId)) {
 	 			         employee.setEm_id(em_id);
 	 				}else {
 	 					is=false;
 						request.setAttribute("e4message", "身份证号格式错误"); 				
 					}
  				}else {
  					is=false;
 					request.setAttribute("e4message", "身份证号不能为空"); 	
  				}

  				//参加工作时间
  				if(!StringUtil.isNull(worktime)) {
 	 				if(worktime.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
 	 					if(!StringUtil.isNull(indate)) {
 	 						Date em_indate=StringUtil.string2Date(indate);
 	 						Date em_worktime=StringUtil.string2Date(worktime);
 	 						if(em_indate.getTime()>=(em_worktime.getTime())) {
 		 						employee.setEm_worktime(em_worktime);
 		 					}else {
 		 						is=false;
 		 						request.setAttribute("e5message", "参加工作日期错误");
 		 					}	
 	 					}
 	 				}else {
 	 					is=false;
 	 					request.setAttribute("e5message", "参加工作日期格式错误");
 	 				}
  				}else {
  					is=false;
  					request.setAttribute("e5message", "参加工作日期不能为空");
  				}
  				
  				
  				//毕业时间
  				if(!StringUtil.isNull(gradate)) {
  				if(gradate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
  					 Date em_birth=StringUtil.string2Date(birth);
  					 Date em_gradate=StringUtil.string2Date(gradate);
  					 if(em_birth.getTime()>em_gradate.getTime()) {
  						employee.setEm_gradate(em_gradate);
  						request.setAttribute("e6message", "毕业日期格式错误");
  					 }
  					 
 					System.out.println("日期正确");	
 				}else {
 					is=false;
 					request.setAttribute("e6message", "毕业日期格式错误");
 				}
  				}

 				
 				
		if(is) {
		
			if(job_number != 0) {
				//岗位所在人数
		         Job job = new Job();
		         job= jobservice.findIdJob(job_number);
		        Integer man= job.getJob_man();
		         //岗位最大人数
		        Integer max= job.getJob_max();
		        //判断人数
		         if(man<max) {
		        	 jobservice.JobNumber(job_number, man);
		        	 employeeservice.insert(employee);
		        	// System.out.println("入职成功");
		        	 request.setAttribute("message", "入职成功");
		         }else {
		        	// System.out.println("入职失败");
		        	 request.setAttribute("message", "入职失败");
		         }
			}else {
				
				employeeservice.insert(employee);
			}
			

			employeeservice.finAllEmp1(employee);
			doFindAllZhunbei(request,response);
		}else {
			request.getRequestDispatcher("/rzgl.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
