package org.example.edge;

/**
 * 常用API返回对象
 */

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(405, "操作失败"),
    VALIDATEFAILED(402, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    WRONGUSER(406, "用户不合法(用户名或密码错误)"),
    EXISTEDUSER(407, "此用户名已存在,请重新输入"),
    NONEXISTEDID(408, "主键不存在"),
    EXISTEDPHONE(409, "手机号已经被注册"),
    NONMATCHPHONE(410, "手机号不匹配"),
    EXISTSUBDEPT(411, "部门下存在子部门,无法删除"),
    ASSRELUSER(412, "存在与用户相关联的分配,无法删除用户"),
    WRONGCARDID(413, "无与此员工编号相关的用户");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
