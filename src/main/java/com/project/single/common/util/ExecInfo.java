package com.project.single.common.util;

import com.project.single.common.Constant;

//*执行反馈类
public class ExecInfo extends Exception{

    //错误信息
    private String info;
    private String code;
    //数据类
    private Object object;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExecInfo() {

    }



    public ExecInfo(String info, String code, Object object, Throwable t) {
        super(t);

        this.info = info;
        this.code=code;
        this.object = object;
    }

    /**
     * 成功
     * @return
     */
    public static ExecInfo successExecInfo(Object o){
        ExecInfo execInfoException =new ExecInfo();
        execInfoException.setCode(Constant.SUCCESS);
        return execInfoException;
    }

    /**
     * 设置异常
     * @param message
     * @param code
     * @param object
     * @param e
     * @return
     */
    public static ExecInfo failExecInfo(String message, String code, Object object, Exception e){
        return new ExecInfo(message,code,object,e);
    }

}
