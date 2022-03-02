package com.example.jushi.util;

/**
 * @author 居無何
 * date: 2022/2/23 13:55
 * Description: 将后端数据以JOSN的形式传到前端
 */
public class JsonResult<E> {

    /** 正常码 200 */
    private static final int codeNum = 200;

    /** 返回的数据 Data 泛型 */
    private E date;

    /** 返回的状态码  status int */
    private int status;

    /** 描述的内容 description String */
    private String description;

    public JsonResult() {
    }

    /** 状态正常 */
    public JsonResult(String description) {
        this.status = codeNum;
        this.description = description;
    }

    /** 状态正常 */
    public JsonResult( E data,String description) {
        this.status = codeNum;
        this.date = data;
        this.description = description;
    }

    /** 状态异常 */
    public JsonResult(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public E getDate() {
        return date;
    }

    public void setDate(E date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JOSNDesign{" +
                "date=" + date +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
