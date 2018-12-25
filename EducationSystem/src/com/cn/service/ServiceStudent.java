package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.bean.Cet;
import com.cn.bean.Courses;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Student;
import com.cn.bean.Stuscore;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;

/**
 * 	ѧ�����߼���
 * @author Sherlock
 *
 */
public interface ServiceStudent {
	
	/**
	 *	 ѧ����¼������ѧ����������������ѧ���Ƿ����
	 * @param studentid ѧ��ѧ��
	 * @param password ���������
	 * @return ѧ�����󣬷��ؿ���˵���������Ϣ����
	 */
	public Student studentLogin(int studentid,String password);
	
	/**
	 * 	��ѯѧ��������Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return ��ѯ������ѧ������
	 */
	public Student searchStudentById(int studentid);
	
	/**
	 * 	��רҵ�λ�ѡ�޿�ת���ɿγ̸�ʽ
	 * @param courses רҵ�ζ�����Ϊ��֤����רҵ��
	 * @param elective ѡ�޿ζ�����Ϊ��֤����ѡ�޿�
	 * @return �ܿγ̼���
	 */
	public Map<Integer,Curriculum> curriculumTransform(Courses courses,Elective elective);
	
	/**
	 * 	��ѯ��ͬѧ�ں�һ���༶������רҵ��
	 * @param termid ѧ��id
	 * @param classesid �༶���
	 * @return һ��ѧ��һ���༶��רҵ�μ���
	 */
	public List<Courses> searchAllCoursesByTermidAndClassesid(int termid,int classesid);
	
	/**
	 * 	��ѯһ��ѧ����ͬѧ�ڵ�����ѧ���ɼ�
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return һ��ѧ��һ��ѧ�ڵ�ѧ���ɼ�����
	 */
	public Map<Integer,Stuscore> searchAllStuScoreByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	����ѡ�޿�id��ѯѡ�޿�
	 * @param id ѡ�޿�id
	 * @return ��ѯ��ѡ�޿�
	 */
	public Elective searchElectiveById(int id);
	
	/**
	 * 	����ѧ�ź�ѧ��id��ѯ��ѧ�ڵ�ѡ�ν��
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return ��ѧ��ѡ�޿ζ��󣬷��ؿ���˵����ѧ��û��ѡ�޿�
	 */
	public Elective searchElectiveByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	ѧ�����ѡ��
	 * @param studentid ѧ��
	 * @param electiveid ѡ�޿�id
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addTempElectiveByStudentid(int studentid,int electiveid);
	
	/**
	 *	 ѧ���޸�ѡ��
	 * @param tempid ѡ�޿α�����¼id
	 * @param electiveid �޸ĺ��ѡ�޿�id
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyTempElectiveByStudentid(int tempid,int electiveid);
	
	/**
	 * 	ѧ����ѯ���б�������ѡ�ν��
	 * @param studentid ѧ��
	 * @return ѡ�μ�¼����
	 */
	public List<Tempelective> searchAllTempElectiveByStudentid(int studentid);
	
	/**
	 * 	��ѯһ��ѧ��һ��ѧ�ڵ����пγ̣�רҵ�μ���ѡ�޿Σ�
	 * @param studentid ѧ��
	 * @param termid ѧ��id
	 * @return һ��ѧ��һ��ѧ�ڵ����пγ�
	 */
	public Map<Integer,Curriculum> searchCurriculumByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	��ѯһ����ʦһ��ѧ�ڵ�����רҵ��
	 * @param teacherid ��ʦ����
	 * @param termid ѧ��id
	 * @return һ����ʦһ��ѧ�ڵ�����רҵ�μ���
	 */
	public Map<Integer,Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid,int termid);
	
	/**
	 * 	��ѯ�༶�ĵ��ΰ���
	 * @param classesid �༶id
	 * @return ��������е��ΰ���
	 */
	public List<Curriculumarrange> searchAllCoursesArrangeByClassesid(int classesid);
	
	/**
	 *	 ��ѯ����Ŀ��԰���
	 * @param classesid �༶���
	 * @return �༶�Ŀ��԰��ż���
	 */
	public List<Exam> searchAllExamByClassesid(int classesid);
	
	/**
	 * 	�޸�ѧ����������
	 * @param studentid ѧ��ѧ��
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyStudentPwd(int studentid,String newPwd);
	
	/**
	 * 	���鲢����ѧ������
	 * @param studentid ѧ��ѧ��
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyStudentPwd(int studentid,String pwd,String newPwd,String rePwd);
	
	/**
	 * 	ѧ��������ῼ��
	 * @param studentid ѧ��ѧ��
	 * @param cetid ��ῼ��id
	 * @return �Ƿ����ɹ�
	 */
	public boolean addEnrollCet(int studentid,int cetid);
	
	/**
	 * 	ѧ����ѯ������ῼ�Ա�����¼
	 * @param studentid ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�����¼
	 */
	public Enrollcet searchEnrollCetByStudentidAndCetid(int studentid,int cetid);
	
	/**
	 * 	������ѯĳ����ῼ�Գɼ��Ϳ��԰���
	 * @param studentid
	 * @param cetid
	 * @return ��ῼ�Գɼ�����
	 */
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid,String cetid);
	
	/**
	 * 	������ѯ����������ῼ�Գɼ�
	 * @param studentid ѧ��
	 * @return ��ῼ�Գɼ�����
	 */
	public List<Gradecet> searchAllGradeCetByStudentid(int studentid);
	
	/**
	 * 	��ѯ��ѧ�ڵ�������ῼ��
	 * @param termid ѧ��id
	 * @return ��ѧ�ڵ���ῼ�Լ���
	 */
	public List<Cet> searchAllCet(int termid);
	
	/**
	 * 	����ѧ����ѧ�ڲ�ѯ����רҵ�γ�
	 * @param studentid ѧ��
	 * @param termid ѧ��
	 * @return רҵ�γ̼���
	 */
	public List<Courses> searchAllCoursesByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	����ѧ����ѧ���ҵ�����רҵ����ʦ
	 * @param studentid ѧ��
	 * @param termid ѧ��
	 * @return רҵ����ʦ����
	 */
	public List<Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid,int termid);
	
	/**
	 * 	ѧ����ӽ�ѧ����
	 * @param vo ��ѧ����
	 * @return ��ӵ�������
	 */
	public int addEvaluationByTeacherid(Evaluation vo);
	
}
