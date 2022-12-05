package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Dept;
import com.neuedu.personnel.bean.Employee;
import com.neuedu.personnel.dao.DeptDao;
import com.neuedu.personnel.dao.EmployeeDao;
import com.neuedu.personnel.dao.daoimpl.DeptDaoimpl;
import com.neuedu.personnel.dao.daoimpl.EmployeeDaoimpl;
import com.neuedu.personnel.service.EmployeeService;

public class EmployeeServiceimpl implements EmployeeService {

	//单例模式，节省资源
		private static EmployeeService employeeservicee =new EmployeeServiceimpl();
		private EmployeeServiceimpl() {};
		public static EmployeeService getEmployeeService() {
			return employeeservicee;
		}
		
	/* 插入 */
		@Override
		public void insert(Employee employee) {
			EmployeeDao employeedao=new EmployeeDaoimpl();
			employeedao.insert(employee);
		}
		
	/* 查询所有 */
		@Override
		public List<Employee> finAllEmp(Employee emp) {
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.finAllEmp(emp);
			return joball;
		}
		
	/* 按id查询 */
		@Override
		public List<Employee> findByEmp(Integer id) {
			// TODO Auto-generated method stub
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.findByEmp(id);
			return joball;

		}

	/* 修改 */
		@Override
		public void UpdateEmp(Employee emp ,Integer id) {
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			employeeDao.UpdateEmp(emp, id);

		}
		
		/* 条件查询 */
		
		@Override
		public List<Employee> findIfEmp(Employee emp) {
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.findIfEmp(emp);
			return joball;
		}
		/* 按员工编号查询查询 */
		@Override
		public Employee  findByEmpDept(Integer number) {
			// TODO Auto-generated method stub
			Employee joball=new Employee();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.findByEmpDept(number);
			return joball;

		}
		/* 按部门编号查询查询 */
		@Override
		public List<Employee>  findByDept(Integer number) {
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.findByDept(number);
			return joball;

		}
	
		/* 按岗位编号查询查询 */
		@Override
		public List<Employee>  findByJob(Integer number) {
			// TODO Auto-generated method stub
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.findByJob(number);
			return joball;

		}
		/* 员工编号计数 */
		@Override
		public Integer finAllEmpAll() {
			Integer is=0;
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			is=employeeDao.finAllEmpAll();
			return is;
		}
		
		/* 查询所有 */
		@Override
		public List<Employee> finAllEmp1(Employee emp) {
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.finAllEmp1(emp);
			return joball;
		}
		@Override
		public List<Employee> finAllPage(Employee emp) {
			List<Employee> joball=new ArrayList<Employee>();
			EmployeeDao employeeDao=new EmployeeDaoimpl();
			joball=employeeDao.finAllpage(emp);
			return joball;		}
}
