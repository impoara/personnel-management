package com.neuedu.personnel.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.service.CodeService;
import com.neuedu.personnel.service.EmployeeService;
import com.neuedu.personnel.service.serviceimpl.CodeServiceimpl;
import com.neuedu.personnel.service.serviceimpl.EmployeeServiceimpl;
import com.neuedu.personnel.utils.Constant;

@WebListener
public class CodeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CodeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext application=event.getServletContext();
    	CodeService codeService=CodeServiceimpl.getCodeService();
    	List<Code> codeList=new ArrayList<Code>();
    	
    	//岗位类型
		codeList=codeService.findByType(Constant.JOB_TYPE);
		application.setAttribute("codeList", codeList);
		
		//部门类型
		List<Code> deptTypeList=codeService.findByType(Constant.DEPT_TYPE);
		application.setAttribute("deptTypeList", deptTypeList);


		//人员来源
		List<Code> em_SourceList=codeService.findByType(Constant.EM_SOURCE);
		application.setAttribute("em_SourceList", em_SourceList);
		
		//政治面貌
		List<Code> em_PolityList=codeService.findByType(Constant.EM_POLITY);
		application.setAttribute("em_PolityList", em_PolityList);
		
		//性别
		List<Code> em_SexList=codeService.findByType(Constant.SEX);
		application.setAttribute("em_SexList", em_SexList);
		
		//用工形式
		List<Code> em_FormatList=codeService.findByType(Constant.EM_FORMAT);
		application.setAttribute("em_FormatList", em_FormatList);
		
		//民族
		List<Code> em_FolkList=codeService.findByType(Constant.EM_FOLK);
		application.setAttribute("em_FolkList", em_FolkList);
		
		
		//最高学历
		List<Code> em_LearnList=codeService.findByType(Constant.EM_LEARN);
		application.setAttribute("em_LearnList", em_LearnList);
		
		//血型
		List<Code> em_BloodList=codeService.findByType(Constant.EM_BLOOD);
		application.setAttribute("em_BloodList", em_BloodList);
		
		//最高学位
		List<Code> em_DegreeList=codeService.findByType(Constant.EM_DEGREE);
		application.setAttribute("em_DegreeList", em_DegreeList);

		
		//婚姻状况
		List<Code> em_WedlockList=codeService.findByType(Constant.EM_WEDLOCK);
		application.setAttribute("em_WedlockList", em_WedlockList);

		//离职类型
		List<Code> domi_TypeList=codeService.findByType(Constant.DOMI_TYPE);
		application.setAttribute("domi_TypeList", domi_TypeList);
		
		 // 部门调转类型
   	 
    	List<Code> dept_chtypeCode = new ArrayList<Code>();
    	dept_chtypeCode = codeService.findByType(Constant.DEPT_CHTYPE);
    	application.setAttribute("dept_chtypeCode", dept_chtypeCode);
    	
    	// 岗位调转类型
    	 
    	List<Code> job_chtypeCode = new ArrayList<Code>();
    	job_chtypeCode = codeService.findByType(Constant.JOB_CHTYPE);
    	application.setAttribute("job_chtypeCode", job_chtypeCode);
        
    	// 考核结果
    	
    	List<Code> prob_resultsCode = new ArrayList<Code>();
    	prob_resultsCode = codeService.findByType(Constant.PROB_RESULTS);
    	application.setAttribute("prob_resultsCode", prob_resultsCode);
    	
    
    }
	
}
