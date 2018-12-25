package com.cn.bean;

/**
 * ��ῼ����
 * @author Sherlock
 *
 */
public class Cet {
	//��ῼ��id
    private Integer id;
	//��ῼ������
	private String cetname;	
	//��ῼ��ʱ��
	private String cettime;
	//ѧ��id
    private Integer termid;

    public Cet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cet(Integer id, String cetname, String cettime) {
		super();
		this.id = id;
		this.cetname = cetname;
		this.cettime = cettime;
	}

	public Cet(Integer id, String cetname, String cettime, Integer termid) {
		super();
		this.id = id;
		this.cetname = cetname;
		this.cettime = cettime;
		this.termid = termid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCetname() {
        return cetname;
    }

    public void setCetname(String cetname) {
        this.cetname = cetname == null ? null : cetname.trim();
    }

    public String getCettime() {
        return cettime;
    }

    public void setCettime(String cettime) {
        this.cettime = cettime == null ? null : cettime.trim();
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

	@Override
	public String toString() {
		return "Cet [id=" + id + ", cetname=" + cetname + ", cettime=" + cettime + ", termid=" + termid + "]";
	}
}