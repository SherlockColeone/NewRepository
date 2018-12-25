package com.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.bean.Cet;
import com.cn.bean.CetExample;
import com.cn.bean.Courses;
import com.cn.bean.CoursesExample;
import com.cn.bean.Curriculum;
import com.cn.bean.Curriculumarrange;
import com.cn.bean.CurriculumarrangeExample;
import com.cn.bean.Elective;
import com.cn.bean.Enrollcet;
import com.cn.bean.EnrollcetExample;
import com.cn.bean.Evaluation;
import com.cn.bean.Exam;
import com.cn.bean.ExamExample;
import com.cn.bean.Gradecet;
import com.cn.bean.GradecetExample;
import com.cn.bean.Student;
import com.cn.bean.StudentExample;
import com.cn.bean.StudentExample.Criteria;
import com.cn.bean.Stuscore;
import com.cn.bean.StuscoreExample;
import com.cn.bean.Teacher;
import com.cn.bean.Tempelective;
import com.cn.bean.TempelectiveExample;
import com.cn.dao.CetMapper;
import com.cn.dao.ClassesMapper;
import com.cn.dao.CoursesMapper;
import com.cn.dao.CurriculumarrangeMapper;
import com.cn.dao.ElectiveMapper;
import com.cn.dao.EnrollcetMapper;
import com.cn.dao.EvaluationMapper;
import com.cn.dao.ExamMapper;
import com.cn.dao.GradecetMapper;
import com.cn.dao.StudentMapper;
import com.cn.dao.StuscoreMapper;
import com.cn.dao.TeacherMapper;
import com.cn.dao.TempelectiveMapper;
import com.cn.service.ServiceStudent;

/**
 * 	ѧ�����߼���ʵ����
 * @author Sherlock
 *
 */
@Service
public class ServiceStudentImpl implements ServiceStudent {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ClassesMapper classesMapper;
	@Autowired
	private CoursesMapper coursesMapper;
	@Autowired
	private StuscoreMapper stuscoreMapper;
	@Autowired
	private ElectiveMapper electiveMapper;
	@Autowired
	private TempelectiveMapper tempelectiveMapper;
	@Autowired
	private CurriculumarrangeMapper curriculumarrangeMapper;
	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private EnrollcetMapper enrollcetMapper;
	@Autowired
	private GradecetMapper gradecetMapper;
	@Autowired
	private CetMapper cetMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private EvaluationMapper evaluationMapper;

	@Override
	public Student studentLogin(int studentid, String pwd) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		//���id������
		criteria.andIdEqualTo(studentid);
		//������������
		criteria.andPasswordEqualTo(pwd);
		List<Student> list = studentMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Student searchStudentById(int studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
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
	public List<Courses> searchAllCoursesByTermidAndClassesid(int termid, int classesid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		criteria.andClassesidEqualTo(classesid);
		return coursesMapper.selectByExample(example);
	}

	@Override
	public Map<Integer,Stuscore> searchAllStuScoreByStudentidAndTermid(int studentid, int termid) {
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> list = stuscoreMapper.selectByExample(example);
		Map<Integer, Stuscore> map = new HashMap<>();
		for (Stuscore stuscore : list) {
			map.put(stuscore.getId(), stuscore);
		}
		return null;
	}

	@Override
	public Elective searchElectiveById(int id) {
		return electiveMapper.selectByPrimaryKey(id);
	}

	@Override
	public Elective searchElectiveByStudentidAndTermid(int studentid, int termid) {
		//���ұ�ѧ�ڸ�ѧ�������пγ�
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> list = stuscoreMapper.selectByExample(example);
		//�������пγ�
		for (Stuscore stuscore : list) {
			int id = stuscore.getElectiveid();
			//�жϸÿγ��Ƿ�Ϊѡ�޿�
			if(id!=0) {
				//��Ϊѡ�޿���ͨ��ѡ�޿�id��ѯ
				return searchElectiveById(id);
			}
		}
		return null;
	}

	@Override
	public boolean addTempElectiveByStudentid(int studentid, int electiveid) {
		Tempelective tempelective = new Tempelective(electiveid, studentid);
		if(tempelectiveMapper.insert(tempelective)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyTempElectiveByStudentid(int tempid, int electiveid) {
		//���ҵ�ԭ���ļ�¼
		Tempelective tempElective = tempelectiveMapper.selectByPrimaryKey(tempid);
		//�ٽ����޸�
		Tempelective vo = new Tempelective(tempid, electiveid, tempElective.getStudentid());
		if(tempelectiveMapper.updateByPrimaryKey(vo)>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Tempelective> searchAllTempElectiveByStudentid(int studentid) {
		TempelectiveExample example = new TempelectiveExample();
		com.cn.bean.TempelectiveExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return tempelectiveMapper.selectByExample(example);
	}

	@Override
	public Map<Integer, Curriculum> searchCurriculumByStudentidAndTermid(int studentid, int termid) {
		Map<Integer,Curriculum> mapCurr = new HashMap<>();
		//ͨ��ѧ���ɼ����ѯ����רҵ����ѡ�޿�
		Map<Integer,Stuscore> mapStuScore = searchAllStuScoreByStudentidAndTermid(studentid, termid);
		for (Stuscore stuScore : mapStuScore.values()) {
			//�ֱ�ͨ�����Ե�id��ѯרҵ����ѡ�޿�
			int electiveid = stuScore.getElectiveid();
			if(electiveid!=0) {
				//רҵ��
				Courses courses = coursesMapper.selectByPrimaryKey(stuScore.getCouresid());
				mapCurr.putAll(curriculumTransform(courses, null));
			}
			else {
				//ѡ�޿�
				Elective elective = electiveMapper.selectByPrimaryKey(stuScore.getElectiveid());
				mapCurr.putAll(curriculumTransform(null, elective));
			}
		}
		return mapCurr;
	}

	@Override
	public Map<Integer, Courses> searcheAllCoursesByTeacheridAndTermid(int teacherid, int termid) {
		CoursesExample example = new CoursesExample();
		com.cn.bean.CoursesExample.Criteria criteria = example.createCriteria();
		criteria.andTeacheridEqualTo(teacherid);
		criteria.andTermidEqualTo(termid);
		List<Courses> list = coursesMapper.selectByExample(example);
		Map<Integer, Courses> map = new HashMap<>();
		for (Courses courses : list) {
			map.put(courses.getId(), courses);
		}
		return map;
	}

	@Override
	public List<Curriculumarrange> searchAllCoursesArrangeByClassesid(int classesid) {
		CurriculumarrangeExample example = new CurriculumarrangeExample();
		com.cn.bean.CurriculumarrangeExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return curriculumarrangeMapper.selectByExample(example);
	}

	@Override
	public List<Exam> searchAllExamByClassesid(int classesid) {
		ExamExample example = new ExamExample();
		com.cn.bean.ExamExample.Criteria criteria = example.createCriteria();
		criteria.andClassesidEqualTo(classesid);
		return examMapper.selectByExample(example);
	}

	@Override
	public int modifyStudentPwd(int studentid, String newPwd) {
		Student record = new Student();
		record.setId(studentid);
		record.setPassword(newPwd);
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int checkAndModifyStudentPwd(int studentid, String pwd, String newPwd, String rePwd) {
		//��ȡ��ѧ�������ݿ��е�����
		String password = studentMapper.selectByPrimaryKey(studentid).getPassword();
		if(pwd!=password) { //�����������ԭʼ���벻��
			return -2;
		}
		else if(newPwd!=rePwd){ //���ĵ�������ȷ�����벻��
			return -1;
		}
		else {
			return modifyStudentPwd(studentid, newPwd);
		}
	}

	@Override
	public boolean addEnrollCet(int studentid, int cetid) {
		Enrollcet vo = new Enrollcet(cetid, studentid);
		if (enrollcetMapper.insert(vo)>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Enrollcet searchEnrollCetByStudentidAndCetid(int studentid, int cetid) {
		EnrollcetExample example = new EnrollcetExample();
		com.cn.bean.EnrollcetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		List<Enrollcet> list = enrollcetMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public Gradecet searchGradeCetByStudentidAndCetid(int studentid, String cetid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andCetidEqualTo(cetid);
		List<Gradecet> list = gradecetMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public List<Gradecet> searchAllGradeCetByStudentid(int studentid) {
		GradecetExample example = new GradecetExample();
		com.cn.bean.GradecetExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return gradecetMapper.selectByExample(example);
	}

	@Override
	public List<Cet> searchAllCet(int termid) {
		CetExample example = new CetExample();
		com.cn.bean.CetExample.Criteria criteria = example.createCriteria();
		criteria.andTermidEqualTo(termid);
		return cetMapper.selectByExample(example);
	}

	@Override
	public List<Courses> searchAllCoursesByStudentidAndTermid(int studentid, int termid) {
		List<Courses> listCourses = new ArrayList<>();
		//���ҵ���ѧ�����пγ�
		StuscoreExample example = new StuscoreExample();
		com.cn.bean.StuscoreExample.Criteria criteria = example.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		criteria.andTermidEqualTo(termid);
		List<Stuscore> listStuscore = stuscoreMapper.selectByExample(example);
		for (Stuscore stuScore : listStuscore) {
			int id = stuScore.getCouresid();
			//���ҵ�רҵ��
			if(id!=0) {
				//��ӵ�������
				listCourses.add(coursesMapper.selectByPrimaryKey(id));
			}
		}
		return listCourses;
	}

	@Override
	public List<Teacher> searchAllCoursesTeacherByStudentidAndTermid(int studentid, int termid) {
		List<Teacher> listTeacher = new ArrayList<>();
		//���ҵ���ѧ������רҵ��
		List<Courses> listCourses = searchAllCoursesByStudentidAndTermid(studentid, termid);
		for (Courses courses : listCourses) {
			//ͨ���γ��ҵ���Ӧ���ο���ʦ
			listTeacher.add(teacherMapper.selectByPrimaryKey(courses.getTeacherid()));
		}
		return listTeacher;
	}

	@Override
	public int addEvaluationByTeacherid(Evaluation vo) {
		return evaluationMapper.insert(vo);
	}

}

