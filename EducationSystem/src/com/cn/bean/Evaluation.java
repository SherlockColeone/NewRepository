package com.cn.bean;

/**
 * 	��ѧ������
 * @author Sherlock
 *
 */
public class Evaluation {
	//id
	private Integer id;
	//��ʦid
	private Integer teacherid;
	//����
	private String content;

    public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(Integer id, Integer teacherid, String content) {
		super();
		this.id = id;
		this.teacherid = teacherid;
		this.content = content;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", teacherid=" + teacherid + ", content=" + content + "]";
	}
}