package com.cn.web.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Teacher;

/**
 * 	�����ʦ�������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class TeacherHomeController {
	
	@RequestMapping(value="/teacherHome")
	public String teacherHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡ��ʦ����
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//�ѽ�ʦ��ӵ���ͼ��
		mv.addObject("teacher", teacher);
		//��ת����ʦ��������
		return "teacher/teacher_home";
	}
	
}
