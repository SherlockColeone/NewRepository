package com.cn.bean;

/**
 * 	ѧ����
 * @author Sherlock
 *
 */
public class Student {
	//ѧ��ѧ��
	private Integer id;
	//����
	private String name;
	//�Ա�
	private String sex;
	//��ϵ��ʽ
	private String phone;
	//���֤��
	private String idcard;
	//��������
	private String birth;
	//����
	private String password;
	//��ͥ��ַ
	private String address;
	//����
	private String birthplace;
	//��ѧʱ��
	private String regist;
	//����ѧԺ���
	private Integer academyid;
	//רҵ���
	private Integer majorid;
	//�༶���
	private Integer classesid;
	//���
	private Integer identity;

    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String regist, Integer academyid, Integer majorid, Integer classesid,
			Integer identity) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.idcard = idcard;
		this.birth = birth;
		this.password = password;
		this.address = address;
		this.birthplace = birthplace;
		this.regist = regist;
		this.academyid = academyid;
		this.majorid = majorid;
		this.classesid = classesid;
		this.identity = identity;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    public String getRegist() {
        return regist;
    }

    public void setRegist(String regist) {
        this.regist = regist == null ? null : regist.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", idcard=" + idcard
				+ ", birth=" + birth + ", password=" + password + ", address=" + address + ", birthplace=" + birthplace
				+ ", regist=" + regist + ", academyid=" + academyid + ", majorid=" + majorid + ", classesid="
				+ classesid + ", identity=" + identity + "]";
	}
}