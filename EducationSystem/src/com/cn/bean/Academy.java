package com.cn.bean;

/**
 * ����ѧԺ��
 * @author Sherlock
 *
 */
public class Academy {
	//����ѧԺ���
    private Integer id;
    //����ѧԺ����
    private String name;

    public Academy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Academy(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Academy [id=" + id + ", name=" + name + "]";
	}
}