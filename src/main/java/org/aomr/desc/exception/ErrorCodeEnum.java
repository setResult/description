package org.aomr.desc.exception;

/**
 * Copyright (C), 2017-2020, org.tianli
 * PackageName: org.aomr.desc.controller
 * Author:      aomr
 * Date:        2019/3/5 下午3:03
 * Description:
 */
public enum ErrorCodeEnum {

    /*** －－－－－－基础错误码 错误码范围 1001-4000－－－－－－*/
    SUCCESS(1000, "成功"),
    FAIL(1001, "失败"),
    ARGUEMENT_ERROR(1002, "参数错误"),
    ARGUEMENT_VALUE_ERROR(1003, "参数值错误"),
    ARGUMENT_VALID_ERROR(1004, "参数校验出错"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(1005, "请求方式出错"),
    UNLOIGN(1006, "请登录"),
    SYSTEM_INTERNAL_ERROR(1007, "系统内部错误"),
    SERVICE_UNSUPPORT(1008, "业务不支持"),
    LOGOUT_FAIL(1009, "注销失败"),
    ACCOUNT_NOT_FOUND(1010, "账号不存在"),
    SYSTEM_BUSY(1011, "系统繁忙,请稍后再试"),
    HTTP_MESSAGE_NOT_READABLE(1012, "请求参数无法读取"),
    MISSING_REQUEST_PARAMETER(1013, "请求参数缺失"),
    /*** －－－－－－基础错误码 END－－－－－－*/


    /*** －－－－－－业务错误码 错误码范围 4001-4100－－－－－－*/
    GOODS_PUT_OFF(4001, "商品已下架"),
    LOW_STOCKS(4002, "库存不足"),
    ACCOUNT_OR_PASSWORD_ERROR(4003, "账号或密码错误"),
    USERNAME_REGISTERED(4004, "用户名已注册"),
    PHONE_REGISTERED(4005, "手机号已注册"),
    PHONE_FORMAT_ERROR(4006, "手机号格式错误"),
    CAPTCHA_ERROR(4007, "验证码错误"),
    PHONE_NOT_REGISTERED(4008, "手机号未注册"),
    ORDER_NOT_EXIST(4009, "订单不存在"),
    NOT_CURRENT_USER_ORDER(4010, "不是当前用户的订单"),
    PLACE_ORDER_FAIL(4011, "下单失败"),
    ORDER_NOT_CANCEL(4012, "订单不能取消"),
    ORDER_CANCEL_FAIL(4013, "订单取消失败"),
    ORDER_NOT_PAY(4014, "订单不能支付"),
    ORDER_NOT_CONFIRM_RECEIPT(4015, "订单不能确认收货"),
    ORDER_NOT_DELETE(4016, "订单不能删除"),

    ROOT_NOT_MODIFY(4017, "超级管理员不能修改"),
    ROOT_NOT_DELETE(4018, "超级管理员不能删除"),
    GOODS_NAME_EXISTED(4019, "商品名已存在"),
    ORDER_REFUND_FAIL(4020, "订单退款失败"),
    ORDER_NOT_DELIVER(4021, "订单不能发货"),
    CURRENT_USER_NOT_EXIST_FOOTPRINT(4022, "当前用户不存在足迹"),
    NOT_CURRENT_USER_FOOTPRINT(4023, "不是当前用户的足迹"),
    PASSWORD_NOT_SETTING(4024, "登录密码未设置"),
    PASSWORD_EXISTED(4025, "已设置登录密码"),
    CAPTCHA_INVALID(4026, "验证码已失效"),
    IDNO_FORMAT_ERROR(4027, "身份证格式不正确"),
    ID_REGISTERED(4028, "身份证已绑定"),
    CURRENT_USER_NOT_CERTIFICATION(4029, "当前用户未实名认证"),
    CERTIFICATION_NOT_MATCH(4030, "认证信息不匹配"),
    CURRENT_USER_CERTIFICATED(4031, "当前用户已实名认证"),
    ID_CENTER_MAINTENANCE(4032, "身份证中心维护，请稍后重试"),
    ID_CENTER_LINK_FAIL(4033, "身份证中心链接失败，请稍后重试"),
    NO_THIS_IDNO(4034, "无此身份证号码"),
    CERTIFICATION_FAIL(4035, "实名认证失败"),
    CAPTCHA_SEND_FAIL(4036, "验证码发送失败"),
    CAPTCHA_SEND_CLOSE(4037, "验证码发送功能已关闭"),
    CONFIRM_PASSWORD_NOT_EQULE(4038, "两次密码输入不一致"),
    OLD_PASSWORD_ERROR(4039, "原密码错误"),
    PASSWORD_NOT_EQULE_OLDPASSWORD(4040, "新密码不能与旧密码一致"),
    PAYPASSWORD_NOT_SETTING(4041, "支付密码未设置"),
    PAYPASSWORD_EXISTED(4042, "已设置支付密码"),
    PAYPASSWORD_ERROR(4044, "支付密码错误"),
    NOT_CURRENT_CARD(4045, "不是当前用户的银行卡"),
    LACK_OF_CREDIT(4046, "白条额度不足"),
    PAYPASSWORD_EMPTY(4047, "支付密码不能为空"),


    COLLECT_GOODS_EXISTED(4048, "该商品已被收藏，请勿重复收藏!"),
    COLLECT_GOODS_NOT_EXISTED(4049, "该商品未被收藏!"),
    PAYMENT_AMOUNT_DOES_NOT_MATCH(4050, "支付金额与原订单金额不匹配"),

    NO_PERMISSION_TO_QUERY_OTHERS_BILLORDERS(4051, "您无权查看他人的出账信息"),
    BUY_NUMBER_TOO_MANY(4052, "单次购买数量不能超过9999"),

    PHONE_FORBIDDEN(4053, "您的手机号已被禁用!"),


    BILL_CANNOT_BE_FOUND(4054, "找不到对应账单"),
    INSTALMENT_CANNOT_BE_FOUND(4055, "找不到对应分期账单"),
    HAVE_OVERDUE_BILLS(4056, "用户有逾期账单未支付，无法进行白条支付"),
    NO_CORRESPONDING_USER_WAS_FOUND(4057, "找不到账单对应用户"),
    ACCOUNT_BALANCE_DEFICIENCY(4058, "账户余额不足"),
    NEED_LIVING_CHECK(4059, "全球购商品需要实名认证"),
    COUPON_BEEN_COLLENTED(4060, "优惠劵已领完"),
    COUPON_GET_TO_ONLINE(4061, "没领到哦 您的单张劵已领取达到上限"),
    EXPRESS_QUERY_FAIL(4062, "物流信息查询失败"),
    ORDER_HAS_COMMENTED(4063, "该订单已评价"),
    ACTIVITY_NOT_EXIST(4065, "活动不存在"),
    USER_NOT_EXIST(4064, "用户不存在"),
    LINE_RECOVER_FAIL(4065, "额度恢复失败"),
    GOODS_SHELVES_CONTACT_COSTOMER(4066, "商品已下架,请联系客服"),
    BILL_STATE_NOT_MATCH(4067, "账单状态不匹配"),
    LINE_ABNORMAL(4068, "额度异常"),
    CONSIGNEE_ID_NOT_MATCH(4069, "身份证与收货人姓名不匹配"),
    AMOUNT_LESS_CAN_NOT_INSTALMENT(4070, "账单金额过低，无法分期"),

    /*** －－－－－－其他错误码 错误码范围 9001-9999－－－－－－*/
    VERIFY_GIGN_FAIL(9001, "验签失败"),

    BASE_CHECKED_IN_THE_ROUGH(9002, "基础认证未完成");

    private int errorNo;

    private String errorMsg;


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    ErrorCodeEnum(int errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

    ErrorCodeEnum() {
    }

    public ErrCodeException generalException() {
        return new ErrCodeException(this.errorNo, this.errorMsg);
    }
}