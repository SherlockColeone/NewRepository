package com.cn.web.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Student;

/**
 * 	����ѧ���������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class StudentHomeController {
	
	@RequestMapping(value="/studentHome")
	public String studentHome(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//��session���л�ȡѧ������
		Student student = (Student) session.getAttribute("student");
		//��ѧ����ӵ���ͼ��
		mv.addObject("student", student);
		//��ת��ѧ����������
		return "student/student_home";
	}
	
}
