package com.cn.bean;

/**
 * ��ῼ�Գɼ���
 * @author Sherlock
 *
 */
public class Gradecet {
	//id
	private int id;
	//��������
	private int studentid;
	//��ῼ��id
	private String cetid;
	//��ῼ��ʱ��
	private String cettime;
	//�ɼ�
	private int cetscore;
	//����id
	private int classroomid;
	//�࿼��ʦ����
	private int teacherid;

    public Gradecet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gradecet(int id, int studentid, String cetid, String cettime, int classroomid, int teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
	}

	public Gradecet(int id, int studentid, String cetid, String cettime, int cetscore, int classroomid, int teacherid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.cetid = cetid;
		this.cettime = cettime;
		this.cetscore = cetscore;
		this.classroomid = classroomid;
		this.teacherid = teacherid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getCetid() {
        return cetid;
    }

    public void setCetid(String cetid) {
        this.cetid = cetid == null ? null : cetid.trim();
    }

    public String getCettime() {
        return cettime;
    }

    public void setCettime(String cettime) {
        this.cettime = cettime == null ? null : cettime.trim();
    }

    public Integer getCetscore() {
        return cetscore;
    }

    public void setCetscore(Integer cetscore) {
        this.cetscore = cetscore;
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

	@Override
	public String toString() {
		return "Gradecet [id=" + id + ", studentid=" + studentid + ", cetid=" + cetid + ", cettime=" + cettime
				+ ", cetscore=" + cetscore + ", classroomid=" + classroomid + ", teacherid=" + teacherid + "]";
	}
}