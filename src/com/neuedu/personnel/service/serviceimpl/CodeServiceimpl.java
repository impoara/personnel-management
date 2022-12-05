package com.neuedu.personnel.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.personnel.bean.Code;
import com.neuedu.personnel.dao.CodeDao;
import com.neuedu.personnel.dao.daoimpl.CodeDaoimpl;
import com.neuedu.personnel.service.CodeService;

public class CodeServiceimpl implements CodeService {

	private  static CodeService codeservice =new CodeServiceimpl();
	private CodeServiceimpl() {};
	public static CodeService getCodeService() {
		return codeservice;
		
	}
	
	@Override
	public List<Code> findByType(Integer id) {
		List<Code> codelist =new ArrayList<Code>();
		CodeDao codedao =new CodeDaoimpl();
		codelist = codedao.findByType(id);
		return codelist;
	}
	

}
