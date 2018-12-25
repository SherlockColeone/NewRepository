package com.cn.service;

import java.util.List;

import com.cn.bean.Admin;
import com.cn.bean.Cet;
import com.cn.bean.Classes;
import com.cn.bean.Courses;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.Gradecet;
import com.cn.bean.Major;
import com.cn.bean.Student;
import com.cn.bean.Teacher;

/**
 * 	����Ա���߼���
 * @author Sherlock
 *
 */
public interface ServiceAdmin {
	
	/**
	 * 	����Ա��¼
	 * @param adminid ����Ա����
	 * @param password ����
	 * @return ��ѯ�Ĺ���Ա����
	 */
	public Admin adminLogin(int adminid,String password);
	
	/**
	 * 	����Ա���ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addStudent(Student vo);
	
	/**
	 * 	����Աɾ��ѧ��ѧ����Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delStudentByStudentid(int studentid);
	
	/**
	 *	 ����Ա�޸�ѧ��ѧ����Ϣ
	 * @param vo ѧ������
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyStudent(Student vo);
	
	/**
	 * 	����Ա����ѧ�Ų�ѯѧ��ѧ����Ϣ
	 * @param studentid ѧ��ѧ��
	 * @return ѧ������
	 */
	public Student searchStudentByStudentid(int studentid);
	
	/**
	 * 	����Ա��ӽ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addTeacher(Teacher vo);
	
	/**
	 *	 ����Աɾ����ʦ��Ϣ
	 * @param teacherid ��ʦ����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delTeacherByTeacherid(int teacherid);
	
	/**
	 * 	����Ա�޸Ľ�ʦ��Ϣ
	 * @param vo ��ʦ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyTeacher(Teacher vo);
	
	/**
	 * 	����Ա���ݹ��Ų�ѯ��ʦ��Ϣ
	 * @param teacherid ��ʦ����
	 * @return ��ʦ����
	 */
	public Teacher searchTeacherByTeacherid(int teacherid);
	
	/**
	 * 	����Ա��ӹ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return �Ƿ���ӳɹ�
	 */
	public boolean addAdmin(Admin vo);
	
	/**
	 * 	����Աɾ������Ա��Ϣ
	 * @param adminid ����Ա����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delAdminByAdminid(int adminid);
	
	/**
	 * 	����Ա�޸Ĺ���Ա��Ϣ
	 * @param vo ����Ա����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyAdmin(Admin vo);
	
	/**
	 * 	����Ա���ݹ��Ų�ѯ����Ա��Ϣ
	 * @param adminid ����Ա����
	 * @return ����Ա����
	 */
	public Admin searchAdminByAdminid(int adminid);
	
	/**
	 * 	�޸Ĺ���Ա��������
	 * @param adminid ����Աid
	 * @param newPwd ������
	 * @return ���ĵ��е�����
	 */
	public int modifyAdminPwd(int adminid,String newPwd);
	
	/**
	 * 	���鲢���Ĺ���Ա����
	 * @param adminid ����Աid
	 * @param pwd ԭʼ����
	 * @param newPwd ������
	 * @param rePwd ȷ������
	 * @return ���ĵ������������������������޸ĳɹ���������0���޸�ʧ�ܣ�������-1��˵�����ĵ�������ȷ�����벻����������-2��˵�������������ԭʼ���벻��
	 */
	public int checkAndModifyAdminPwd(int adminid,String pwd,String newPwd,String rePwd);
	
	/**
	 * 	����Ա���רҵ��
	 * @param vo רҵ�ζ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addCourses(Courses vo);
	
	/**
	 * 	����Ա����רҵ��idɾ��רҵ��
	 * @param coursesid רҵ��id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delCoursesByCoursesid(int coursesid);
	
	/**
	 * 	����Ա�޸�רҵ��
	 * @param vo רҵ�ζ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCourses(Courses vo);
	
	/**
	 * 	����Ա����רҵ��id��ѯרҵ��
	 * @param coursesid רҵ��id
	 * @return רҵ�ζ���
	 */
	public Courses searchCoursesByCoursesid(int coursesid);
	
	/**
	 * 	����Ա���ѡ�޿�
	 * @param vo ѡ�޿ζ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addElective(Elective vo);
	
	/**
	 *	 ����Ա����ѡ�޿�idɾ��ѡ�޿�
	 * @param electiveid ѡ�޿�id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delElectiveByElectiveid(int electiveid);
	
	/**
	 * 	����Ա�޸�ѡ�޿�
	 * @param vo ѡ�޿ζ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyElective(Elective vo);
	
	/**
	 * 	����Ա����ѡ�޿�id��ѯѡ�޿�
	 * @param electiveid ѡ�޿�id
	 * @return ѡ�޿ζ���
	 */
	public Elective searchElectiveByElectiveid(int electiveid);
	
	/**
	 * 	����Ա�޸ĵ��ΰ���
	 * @param vo ���ΰ��Ŷ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCurriculumArrange(Curriculumarrange vo);
	
	/**
	 * 	����Ա���ݵ���id��ѯ���ΰ���
	 * @param curriculumarrangeid ����id
	 * @return ���ΰ��Ŷ���
	 */
	public Curriculumarrange searchCurriculumarrangeByCurriculumarrangeid(int curriculumarrangeid);
	
	/**
	 * 	����Ա��ӿ���
	 * @param vo ���Զ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addExam(Exam vo);
	
	/**
	 * 	����Ա���ݿ���idɾ������
	 * @param examid ����id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delExamByExamid(int examid);
	
	/**
	 * 	����Ա����������п���
	 * @return �Ƿ�����ɹ�
	 */
	public boolean clearAllExam();
	
	/**
	 * 	����Ա�޸Ŀ���
	 * @param vo ���Զ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyExam(Exam vo);
	
	/**
	 * 	����Ա���ݿ���id��ѯ����
	 * @param examid ����id
	 * @return ���Զ���
	 */
	public Exam searchExamByExamid(int examid);
	
	/**
	 * 	����Ա���רҵ
	 * @param vo רҵ����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addMajor(Major vo);
	
	/**
	 * 	����Ա����רҵidɾ��רҵ
	 * @param majorid רҵid
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delMajorByMajorid(int majorid);
	
	/**
	 * 	����Ա�޸�רҵ
	 * @param vo רҵ����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyMajor(Major vo);
	
	/**
	 * 	����Ա����רҵid��ѯרҵ
	 * @param majorid רҵid
	 * @return רҵ����
	 */
	public Major searchMajorByMajorid(int majorid);
	
	/**
	 *	 ����Ա��Ӱ༶
	 * @param vo �༶����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addClasses(Classes vo);
	
	/**
	 *	 ����Ա���ݰ༶idɾ���༶
	 * @param classesid �༶id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delClassesByClassesid(int classesid);
	
	/**
	 * 	����Ա�޸İ༶
	 * @param vo �༶����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyClasses(Classes vo);
	
	/**
	 * 	����Ա���ݰ༶��Ų�ѯ�༶
	 * @param classesid �༶���
	 * @return �༶����
	 */
	public Classes searchClassesByClassesid(int classesid);
	
	/**
	 * 	����Ա�����ῼ��
	 * @param vo ��ῼ�Զ���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addCet(Cet vo);
	
	/**
	 * 	����Ա������ῼ��idɾ����ῼ��
	 * @param cetid ��ῼ��id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delCetByCetid(int cetid);
	
	/**
	 *	 ����Ա�޸���ῼ��
	 * @param vo ��ῼ�Զ���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyCet(Cet vo);
	
	/**
	 * 	����Ա������ῼ��id��ѯ��ῼ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Զ���
	 */
	public Cet searchCetByCetid(int cetid);
	
	/**
	 *	 ����Ա��ѯĳһ����ῼ�Ե�������ῼ�Ա���
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�������
	 */
	public List<Enrollcet> searchAllEnrollcetByCetid(int cetid);
	
	/**
	 * 	����Ա��ѯĳһ����ῼ�����б�����ѧ��ѧ��
	 * @param cetid ��ῼ��id
	 * @return ��ῼ�Ա�������
	 */
	public List<Integer> searchAllEnrollCetStudentidByCetid(int cetid);
	
	/**
	 * 	����Ա�����ῼ�Գɼ�
	 * @param vo ��ῼ�Գɼ�����
	 * @return �Ƿ�ɹ����
	 */
	public boolean addGradeCet(Gradecet vo);
	
	/**
	 * 	����Ա������ῼ�Գɼ�idɾ����ῼ�Գɼ�
	 * @param cetid ��ῼ�Գɼ�id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delGradeCetByGradeCetid(int gardecetid);
	
	/**
	 * 	����Ա�޸���ῼ�Գɼ�
	 * @param vo ��ῼ�Գɼ�����
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyGradeCet(Gradecet vo) ;
	
	/**
	 * 	����Ա��ӽ�ѧ����
	 * @param vo ��ѧ���۶���
	 * @return �Ƿ�ɹ����
	 */
	public boolean addEvaluation(Evaluation vo);
	
	/**
	 * 	����Ա���ݽ�ѧ����idɾ����ѧ����
	 * @param evaluationid ��ѧ����id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean delEvaluationByEvaluationid(int evaluationid);
	
	/**
	 * 	����Ա�޸Ľ�ѧ����
	 * @param vo ��ѧ���۶���
	 * @return �Ƿ��޸ĳɹ�
	 */
	public boolean modifyEvaluation(Evaluation vo);
	
	/**
	 * 	����Ա���ݽ�ѧ����id��ѯ��ѧ����
	 * @param evaluationid ��ѧ����id
	 * @return ��ѧ���۶���
	 */
	public Evaluation searchEvaluationByEvaluationid(int evaluationid);
	
}
