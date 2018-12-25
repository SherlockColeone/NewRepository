package com.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Courses;
import com.cn.bean.CoursesExample;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.CurriculumarrangeExample;
import com.cn.bean.Elective;
import com.cn.bean.ElectiveExample;
import com.cn.bean.Evaluation;
import com.cn.bean.EvaluationExample;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import com.cn.bean.Student;
import com.cn.bean.StudentExample;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.TeacherExample;
import com.cn.bean.TeacherExample.Criteria;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.StuscoreMapper;
import com.cn.dao.TeacherMapper;
import com.cn.service.ServiceTeacher;

/**
 * 	��ʦ���߼���ʵ����
 * @author Sherlock
 *
 */
@Service
public class ServiceTeacherImpl implements ServiceTeacher {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private StuscoreMapper stuscoreMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;

	@Override
	public Teacher teacherLogin(int teacherid, String password) {
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(teacherid);
		criteria.andPasswordEqualTo(password);
		List<Teacher> list = teacherMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Teacher searchTeacherById(int id) {
		return teacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> searchAllStudentByClassesid(int classesid) {
		StudentExample example = new StudentExample();
		com.cn.bean.StudentExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return studentMapper.selectByExample(example);
	}

	@Override
	public int modifyTeacherPwd(int teacherid, String newPwd) {
		Teacher record = new Teacher();
		record.setId(teacherid);
		record.setPassword(newPwd);
		return teacherMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAndModifyTeacherPwd(int teacherid, String pwd, String newPwd, String rePwd) {
		//��ȡ�ý�ʦ�����ݿ��е�����
		String password = teacherMapper.selectByPrimaryKey(teacherid).getPassword();
		//�����������ԭʼ���벻��
		if(pwd!=password) {
			return -2;
		}
		//���ĵ�������ȷ�����벻��
		else if(newPwd!=rePwd){
			return -1;
		}
		//��֤ͨ���������޸�����
		else {  
			return modifyTeacherPwd(teacherid, newPwd);
		}
	}

	@Override
	public Map<Integer, Curriculum> curriculumTransform(Courses courses, Elective elective) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//רҵ�γ�
		if(courses!=null) {
			//��ȡ�Ͽν���
			String time = courses.getTime();
			//ͨ����ȡ��������γ̴�ڣ���ȡ���һ���ַ�
			int i = new Integer(time.substring(4));
			int lesson = 0;
			//����ȡ��2-8ʱ����2������γ��ڵڼ����
			if(i!=0) {
				lesson = i/2;
			}
			//����ȡ��0ʱ��Ϊ10�����ڵ�����
			else {
				lesson = 5;
			}
			//��ȡ�γ������ڼ�
			int day = courses.getDay();
			//ͨ���༶id�ҵ��༶����
			String classes = classesMapper.selectByPrimaryKey(courses.getClassesid()).getName();
			Curriculum curr = new Curriculum(courses.getName(), courses.getWeek(), day,time,lesson,courses.getPlace(),
					courses.getTeacher(), classes);
			mapCurr.put(day*10+lesson, curr);
		}
		//ѡ�޿γ�
		if(elective!=null) {
			String time = elective.getTime();
			int i = new Integer(time.substring(4));
			int lesson = 0;
			if(i!=0) {
				lesson = i/2;
			}
			else {
				lesson = 5;
			}
			int day = elective.getDay();
			Curriculum curr = new Curriculum(elective.getName(), elective.getWeek(), day, time, lesson, 
					elective.getPlace(), elective.getTeacher());
			mapCurr.put(day*10+lesson, curr);
		}
		return mapCurr;
	}

	@Override
	public Map<Integer, Curriculum> searchAllCurriculumByTermidAndTeacherid(int termid, int teacherid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//�ҵ��ý�ʦ����רҵ��
		CoursesExample coursesExample = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteriaCourses = coursesExample.createCriteria();
		criteriaCourses.andTermidEqualTo(termid);
		criteriaCourses.andTeacheridEqualTo(teacherid);
		List<Courses> listCourses = coursesMapper.selectByExample(coursesExample);
		for (Courses courses : listCourses) {
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		//�ҵ��ý�ʦ����ѡ�޿�
		ElectiveExample electiveExample = new ElectiveExample();
		com.cn.bean.ElectiveExample.Criteria criteriaElecitve = electiveExample.createCriteria();
		criteriaElecitve.andTermidEqualTo(termid);
		criteriaElecitve.andTeacheridEqualTo(teacherid);
		List<Elective> listElective = electiveMapper.selectByExample(electiveExample);
		for (Elective elective : listElective) {
			mapCurr.putAll(curriculumTransform(null, elective));
		}
		return mapCurr;
	}

	@Override
	public Map<Integer, Curriculum> searchAllCurriculumByTermidAndClassesid(int termid, int classesid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//�ҵ�����רҵ��
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		criteria.andTermidEqualTo(termid);
		List<Courses> listCourses = coursesMapper.selectByExample(example);
		for (Courses courses : listCourses) {
			//ת���ܿγ̵ĸ�ʽ
			mapCurr.putAll(curriculumTransform(courses, null));
		}
		return mapCurr;
	}

	@Override
	public boolean addCurriculumArrange(Curriculumarrange vo) {	
		if(curriculumarrangeMapper.insert(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Curriculumarrange> searchAllCurriculumArrangeByTeacherid(int teacherid) {
		CurriculumarrangeExample example = new CurriculumarrangeExample();
		com.cn.bean.CurriculumarrangeExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return curriculumarrangeMapper.selectByExample(example);
	}

	@Override
	public List<Exam> searchAllExamByTeacherid(int teacherid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return examMapper.selectByExample(example);
	}

	@Override
	public List<Gradecet> searchAllGradeCetByTeacherid(int teacherid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return gradecetMapper.selectByExample(example);
	}

	@Override
	public List<Student> searchAllStudentByElectiveid(int electiveid) {
		List<Student> listStudent = new ArrayList<>();
		//����ѡ�޿�id��ѯѧ���ɼ���
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		//�����ɼ���
		for (Stuscore stuscore : listStuscore) {
			int id = stuscore.getStudentid();
			//����ѧ��ѧ�Ų�ѯѧ��
			listStudent.add(studentMapper.selectByPrimaryKey(id));
		}
		return listStudent;
	}

	@Override
	public List<Stuscore> searchAllStuScoreByCoursesid(int coursesid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andCouresidEqualTo(coursesid);
		return stuscoreMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuScoreByElectiveid(int electiveid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andElectiveidEqualTo(electiveid);
		return stuscoreMapper.selectByExample(example);
	}

	@Override
	public List<Stuscore> searchAllStuScoreByClassesidAndTermid(int classesid, int termid) {
		List<Stuscore> listStusore = new ArrayList<>();
		//�ȸ��ݰ༶�ҵ�����ѧ��
		StudentExample studentExample = new StudentExample();
		com.cn.bean.StudentExample.Criteria studentCriteria = studentExample.createCriteria();
		studentCriteria.andClassesidEqualTo(classesid);
		List<Student> listStudent = studentMapper.selectByExample(studentExample);
		StuscoreExample stuscoreExample = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria stuscoreCriteria = stuscoreExample.createCriteria();
		//���ѧ������
		stuscoreCriteria.andTermidEqualTo(termid);
		//����ѧ������
		for (Student student : listStudent) {
			//���ѧ������
			stuscoreCriteria.andStudentidEqualTo(student.getId());
			//�ҵ�һ��ѧ�ڸ�ѧ�������гɼ�����
			listStusore.add(stuscoreMapper.selectByExample(stuscoreExample).get(0));
		}
		return listStusore;
	}

	@Override
	public boolean addStuScoreByCoursesid(int coursesid) {
		
		return false;
	}

	@Override
	public boolean addStuScoreByClassesid(int classesid) {
		
		return false;
	}

	@Override
	public boolean addGradeCetByStudentid(int studentid) {
		
		return false;
	}

	@Override
	public List<Evaluation> searchAllEvaluationByTeacherid(int teacherid) {
		EvaluationExample example = new EvaluationExample();
		com.cn.bean.EvaluationExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		return evaluationMapper.selectByExample(example);
	}

}
