package com.kuai.springboot.test.annotation;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class UserDo {
    @Column(name = "name")
    private String userName;

    @Column(name = "title")
    private String title;

    @Column(name="long_times")
    private int longTimes;

    private String empId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLongTimes() {
        return longTimes;
    }

    public void setLongTimes(int longTimes) {
        this.longTimes = longTimes;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}