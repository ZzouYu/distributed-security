package com.it.security.zy.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

/**
 * @author zouyu
 * @description
 * @date 2020/5/12
 */
@Data
@ToString
public class UserDto {
            private String username;//'用户名',
            private String password;//密码，加密存储',
            private String phone;//'注册手机号',
            private String email;//'注册邮箱',
            private Date created;//'创建时间',
            private Date updated;//'修改时间',
            private String source_type;//'会员来源：1:PC，2：H5，3：Android，4：IOS',
            private String nick_name;//'昵称',
            private String name;//'真实姓名',
            private String status;// '使用状态（1正常 0非正常）',
            private String head_pic;// '头像地址',  
            private String qq;//'QQ号码',
            private String is_mobile_check;//'0' COMMENT '手机是否验证 （0否  1是）',
            private String is_email_check;//'0' COMMENT '邮箱是否检测（0否  1是）',
            private String sex;// '1' COMMENT '性别，1男，0女',
            private Integer user_level;//'会员等级',
            private Integer points;//'积分',
            private Integer experience_value;// '经验值',
            private Date birthday;//'出生年月日',
            private Date last_login_time;//'最后登录时间',

    public static void main(String[] args) {

        System.out.println( BCrypt.hashpw("secert",BCrypt.gensalt()));
    }
}
