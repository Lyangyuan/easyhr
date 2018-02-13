package com.boyuan.base;

/**
 * @author jiangbo
 * @time 2017/11/19
 */
public interface ErrorMsg {

    String TOKEN_WRONG = "the account {%s} used wrong token {%s}";

    String PASSWORD_OR_ACCOUNT_WRONG = "账号或密码错误！！！";

    String ACCOUNT_FREEZON = "该账户已被冻结,无法登陆";

    String DATA_NOT_EXIST = "数据不存在";

    String SAVE_ERROR = "保存失败";

    String DELETE_ERROR = "删除失败";

    String FILE_IS_EMPTY = "上传文件为空";

    String UPLOAD_FILE_FAIL = "文件上传失败";

    String UPLOAD_FILE_SUCCESS = "文件上传成功";
}
