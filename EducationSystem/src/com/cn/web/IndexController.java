package com.cn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.bean.Admin;
import com.cn.bean.Student;
import com.cn.bean.Teacher;
import com.cn.service.ServiceAdmin;
import com.cn.service.ServiceStudent;
import com.cn.service.ServiceTeacher;

/**
 * 	������ҳ��������ݸ������ĵĿ�����
 * @author Sherlock
 *
 */

@Controller
public class IndexController {
	@Autowired
	private ServiceStudent serviceStudent;
	@Autowired
	private ServiceTeacher seriveTeacher;
	@Autowired
	private ServiceAdmin serivceAdmin;
	
	/**
	 * 	������ҳ�Ŀ�����
	 * @return ������ҳ��¼JSPҳ��
	 */
	@RequestMapping(value="/index")
	public String index() {
		//������ҳ��¼JSPҳ��
		return "login";
	}
	
	/**
	 * 	����ѧ���������ĵĿ�����
	 * @param mv ModelAndView
	 * @param student ��ȡ����װ��ѧ������
	 * @param request �������
	 * @return �ض���ѧ����ҳ����
	 */
	@RequestMapping(value="/studentLogin")
	public String studentLogin(ModelAndView mv,Student student,HttpServletRequest request) {
		//�߼����¼��ȡѧ��������Ϣ
		student = serviceStudent.studentLogin(student.getId(), student.getPassword());
		HttpSession session = request.getSession();
		//��ѧ���������session����
		session.setAttribute("student", student);
		//�ض���ѧ����ҳ����
		return "redirect:studentHome";
	}
	
	/**
	 * 	�����ʦ�������ĵĿ�����
	 * @param mv ModelAndView
	 * @param teacher ��ȡ����װ�Ľ�ʦ����
	 * @param request �������
	 * @return �ض��򵽽�ʦ��ҳ����
	 */
	@RequestMapping(value="/teacherLogin")
	public String teacherLogin(ModelAndView mv,Teacher teacher,HttpServletRequest request) {
		//�߼����ȡ��ʦ������Ϣ
		teacher = seriveTeacher.teacherLogin(teacher.getId(), teacher.getPassword());
		HttpSession session = request.getSession();
		//�ѽ�ʦ�������session����
		session.setAttribute("teacher", teacher);
		//�ض��򵽽�ʦ��ҳ����
		return "redirect:teacherHome";
	}
	
	/**
	 * 	�������Ա�������ĵĿ�����
	 * @param mv ModelAndView
	 * @param admin ��ȡ����װ�Ĺ���Ա����
	 * @param request �������
	 * @return �ض��򵽹���Ա��ҳ����
	 */
	@RequestMapping(value="/adminLogin")
	public String adminLogin(ModelAndView mv,Admin admin,HttpServletRequest request) {
		//�߼����ȡ����Ա������Ϣ
		admin = serivceAdmin.adminLogin(admin.getId(), admin.getPassword());
		HttpSession session = request.getSession();
		//�ѹ���Ա�������session����
		session.setAttribute("admin", admin);
		//�ض��򵽹���Ա��ҳ����
		return "redirect:adminHome";
	}
	
}
