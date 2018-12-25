package com.cn.bean;

/**
 * 	������
 * @author Sherlock
 *
 */
public class Classroom {
	//����id
    private Integer id;
    //���ҵص�
    private String name;
    //��������
    private Integer number;

    public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(Integer id, String name, Integer number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", name=" + name + ", number=" + number + "]";
	}
}