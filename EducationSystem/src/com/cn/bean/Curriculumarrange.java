package com.cn.bean;

/**
 * 	���ΰ�����
 * @author Sherlock
 *
 */
public class Curriculumarrange {
	//id
	private Integer id;
	//רҵ��id
	private Integer coursesid;
	//ѡ�޿�id
	private Integer electiveid;
	//�����Ͽ��ܴ�
	private String week;
	//�����Ͽ�����
	private Integer day;
	//�����Ͽν���
	private String time;
	//�Ͽεص�
	private String place;
	//�Ͽΰ༶����Ϊ0��˵����ѡ�޿�
	private Integer classesid;
	//�ο���ʦ����
	private Integer teacherid;
	//�����Ƿ���׼��-1��ʾ����׼��0��ʾδ����1��ʾ����׼
	private Integer permit;

    public Curriculumarrange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curriculumarrange(Integer id, Integer coursesid, Integer electiveid, String week, Integer day, String time,
			String place, Integer classesid, Integer teacherid, Integer permit) {
		super();
		this.id = id;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.classesid = classesid;
		this.teacherid = teacherid;
		this.permit = permit;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }

	@Override
	public String toString() {
		return "Curriculumarrange [id=" + id + ", coursesid=" + coursesid + ", electiveid=" + electiveid + ", week="
				+ week + ", day=" + day + ", time=" + time + ", place=" + place + ", classesid=" + classesid
				+ ", teacherid=" + teacherid + ", permit=" + permit + "]";
	}
}