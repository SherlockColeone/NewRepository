package com.cn.bean;

/**
 * 	ѧ����ῼ�Լ�¼��
 * @author Sherlock
 *
 */
public class Enrollcet {
	//id
	private Integer id;
	//��ῼ������id
	private Integer cetid;
	//��������
	private Integer studentid;

    public Enrollcet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollcet(Integer cetid, Integer studentid) {
		super();
		this.cetid = cetid;
		this.studentid = studentid;
	}

	public Enrollcet(Integer id, Integer cetid, Integer studentid) {
		super();
		this.id = id;
		this.cetid = cetid;
		this.studentid = studentid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCetid() {
        return cetid;
    }

    public void setCetid(Integer cetid) {
        this.cetid = cetid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

	@Override
	public String toString() {
		return "Enrollcet [id=" + id + ", cetid=" + cetid + ", studentid=" + studentid + "]";
	}
}