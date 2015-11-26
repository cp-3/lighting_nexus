package com.lighting.front.web.constants;

/**
 * @desc 错误信息
 * @author Bill
 * @createtime : 2015年3月13日
 */
public interface ErrorMessage {
	 /** 错误信息定义 */
    public static final String EMAIL_IS_NOT_NULL = "email不能为空！";
    public static final String PASSWORD_IS_NOT_NULL = "密码不能为空！";
    public static final String EMAIL_IS_REGISTED = "该邮箱已被注册！";
    public static final String EMAIL_IS_NOT_REGISTED = "该邮箱还未注册！";
    
    public static final String USERID_CAN_NOT_NULL = "用户ID不能为空！";
    public static final String PRODUCT_ID_CAN_NOT_NULL = "产品ID不能为空！";
}
