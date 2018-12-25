package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;

/**
 * 	��ʦ���߼���
 * @author Sherlock
 *
 */
public interface ServiceTeacher {
	/**
	 * 	��ʦ��¼
	 * @param teacherid ��ʦ����
	 * @param password ����
	 * @return ��ѯ�Ľ�ʦ����
	 */
	public Teacher teacherLogin(int teacherid,String password);
	
	/**
	 * 	��ʦ��ѯ������Ϣ
	 * @param id ��ʦ����
	 * @return ��ʦ����
	 */
	public Teacher searchTeacherById(int id);
	
	/**
	 * 	��ʦ��ѯ�༶��ѧ������
	 * @param classid �༶id
	 * @return �༶��ѧ������
	 */
	public List<Student> searchAllStudentByClassesid(int classesid);
	
	/**
	 * 	�޸Ľ�ʦ��������
	 * @param teacherid ��ʦ����
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyTeacherPwd(int teacherid,String newPwd);
	
	/**
	 * 	���鲢���Ľ�ʦ����
	 * @param teacherid ��ʦ����
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyTeacherPwd(int teacherid,String pwd,String newPwd,String rePwd);
	
	/**
	 * 	��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * @param courses רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼���
	 */
	public Map<Integer,Curriculum> curriculumTransform(Courses courses,Elective elective);
	
	/**
	 * 	��ѯĳλ��ʦһ��ѧ�ڵ����пγ̰��ţ�רҵ�μ�ѡ�޿Σ�
	 * @param termid ѧ��id
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦһ��ѧ�ڵĿγ̰��ż���
	 */
	public Map<Integer,Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid,int teacherid);
	
	/**
	 * 	��ѯһ��ѧ��һ���༶�����пγ�
	 * @param termid ѧ��id
	 * @param classesid �༶id
	 * @return һ��ѧ��һ���༶�Ŀγ̼���
	 */
	public Map<Integer,Curriculum> searchAllCurriculumByTermidAndClassesid(int termid,int classesid);
	
	/**
	 * 	��ӵ��ΰ���
	 * @param vo ���ΰ��Ŷ���
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addCurriculumArrange(Curriculumarrange vo);
	
	/**
	 * 	��ѯĳλ��ʦ�����е��ΰ���
	 * @param teacherid ��ʦ����
	 * @return ���ΰ��ż���
	 */
	public List<Curriculumarrange> searchAllCurriculumArrangeByTeacherid(int teacherid);
	
	/**
	 * 	��ѯ�࿼��ʦ�����п��԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ���԰��ż���
	 */
	public List<Exam> searchAllExamByTeacherid(int teacherid);
	
	/**
	 * 	��ѯ�࿼��ʦ��������ῼ�԰���
	 * @param teacherid �࿼��ʦ����
	 * @return ��ῼ�԰��ż���
	 */
	public List<Gradecet> searchAllGradeCetByTeacherid(int teacherid);
	
	/**
	 *	 ����ѡ�޿β�ѯ��ѡ�޿ε�ѧ������
	 * @param electiveid ѡ�޿�id
	 * @return ��ѡ�޿ε�ѧ������
	 */
	public List<Student> searchAllStudentByElectiveid(int electiveid);
	
	/**
	 * 	��ѯĳһ��רҵ�ε�����ѧ���ɼ�
	 * @param coursesid רҵ��id
	 * @return ĳһ��רҵ�ε�����ѧ���ɼ�
	 */
	public List<Stuscore> searchAllStuScoreByCoursesid(int coursesid);
	
	/**
	 * 	��ѯĳһ��ѡ�޿ε�����ѧ���ɼ�
	 * @param electiveid ѡ�޿�id
	 * @return ĳһ��ѡ�޿ε�����ѧ���ɼ�
	 */
	public List<Stuscore> searchAllStuScoreByElectiveid(int electiveid);
	
	/**
	 * 	��ѯһ����ĳ��ѧ�ڵ�����ѧ���ɼ�
	 * @param classesid �༶���
	 * @param termid ѧ��id
	 * @return һ����һ��ѧ�ڵ�����ѧ���ɼ�����
	 */
	public List<Stuscore> searchAllStuScoreByClassesidAndTermid(int classesid,int termid);
	
	/**
	 * 	�ϴ�һ��רҵ�εĳɼ�
	 * @param coursesid רҵ��id
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addStuScoreByCoursesid(int coursesid);
	
	/**
	 * 	�ϴ�һ���������ѧ���ɼ�
	 * @param classesid �༶���
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addStuScoreByClassesid(int classesid);
	
	/**
	 * 	�ϴ�ĳһ����ῼ�Գɼ�
	 * @param studentid ����ѧ��
	 * @return �Ƿ�ɹ��ϴ�
	 */
	public boolean addGradeCetByStudentid(int studentid);
	
	/**
	 * 	�鿴ĳλ��ʦ�����н�ѧ����
	 * @param teacherid ��ʦ����
	 * @return ĳλ��ʦ�����н�ѧ���ۼ���
	 */
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid);
	
}
