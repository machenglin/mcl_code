package com.shiro;

/**
 * Created by Mcl on 2018/7/13.
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloShiro {
    public static void main(String[] args) {
        //读取配置文件，初始化SecurityManager工厂
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        //获取securityManager实例
        SecurityManager securityManager = factory.getInstance();
        //把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //得到当前执行的用户
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("mcl","123456");
        try{
            //身份验证
            subject.login(token);
            System.out.println("身份登录成功 ");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("身份登录成失败");
        }
        //退出
        subject.logout();
    }
}
