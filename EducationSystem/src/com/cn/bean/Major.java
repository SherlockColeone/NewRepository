package com.cn.bean;

/**
 * 	רҵ��
 * @author Sherlock
 *
 */
public class Major {
	//רҵid
	private Integer id;
	//רҵ����
	private String name;
	//����ѧԺid
	private Integer academyid;

    public Major() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Major(Integer id, String name, Integer academyid) {
		super();
		this.id = id;
		this.name = name;
		this.academyid = academyid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", academyid=" + academyid + "]";
	}
}