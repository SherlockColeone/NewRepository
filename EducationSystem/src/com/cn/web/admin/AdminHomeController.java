package com.cn.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;

/**
 * 	�������Ա�������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class AdminHomeController {
	
	@RequestMapping(value="/adminHome")
	public String adminHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Admin admin = (Admin) session.getAttribute("admin");
		//�ѹ���Ա��ӵ���ͼ��
		mv.addObject("admin", admin);
		//��ת������Ա��������
		return "teacher/teacher_home";
	}
	
}
