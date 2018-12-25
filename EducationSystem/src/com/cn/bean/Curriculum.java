package com.cn.bean;

/**
 * �ܿγ��ࣨרҵ�μ�ѡ�޿Σ�
 * @author Sherlock
 *
 */
public class Curriculum {
	//�γ�����
	private String name;
	//�Ͽ��ܴ�
	private String week;
	//����
	private int day;
	//�Ͽν���
	private String time;
	//�γ̴��
	private int lesson;
	//�Ͽεص�
	private String place;
	//�ο���ʦ
	private String teacher;
	//�Ͽΰ༶����ʦ��ѯʱ��Ҫ��
	private String classes;
	
	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Curriculum(String name, String week, int day, String time, int lesson, String place, String teacher) {
		super();
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.lesson = lesson;
		this.place = place;
		this.teacher = teacher;
	}

	public Curriculum(String name, String week, int day, String time, int lesson, String place, String teacher,
			String classes) {
		super();
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.lesson = lesson;
		this.place = place;
		this.teacher = teacher;
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getLesson() {
		return lesson;
	}

	public void setLesson(int lesson) {
		this.lesson = lesson;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Curriculum [name=" + name + ", week=" + week + ", day=" + day + ", time=" + time + ", lesson=" + lesson
				+ ", place=" + place + ", teacher=" + teacher + ", classes=" + classes + "]";
	}

}
