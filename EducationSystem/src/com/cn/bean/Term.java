package com.cn.bean;

/**
 * 	ѧ����
 * @author Sherlock
 *
 */
public class Term {
	//ѧ��id
	private Integer id;
	//ѧ��ʱ�䣺x��y��-a��b��
	private String termtime;

    public Term() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Term(Integer id, String termtime) {
		super();
		this.id = id;
		this.termtime = termtime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermtime() {
        return termtime;
    }

    public void setTermtime(String termtime) {
        this.termtime = termtime == null ? null : termtime.trim();
    }

	@Override
	public String toString() {
		return "Term [id=" + id + ", termtime=" + termtime + "]";
	}
}