package com.jiehun.veigar.aop.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.jiehun.veigar.aop.LoginActivity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description:
 * @author: houwj
 * @date: 2019/7/4
 */
@Aspect
public class LoginCheckAspect {
//    private final static String TAG = "<<<";
//
//    //1.应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
//    //execution 以方法执行时作为切点，处罚Aspect类
//    //* *(..) 可以处理ClickBehavior这个类所有的方法
//    @Pointcut("execution(@com.jiehun.veigar.aop_login.annotation.LoginCheck * *(..))")
//    public void methodPointCut(){
//
//    }
//
//    //2.对切入点如何处理
//    @Around("methodPointCut()")
//    public Object jointPoint(ProceedingJoinPoint joinPoint) throws Throwable{
//        Context context = (Context) joinPoint.getThis();
//        if(false){//从SharePreferences 中读取
//            Log.e(TAG,"已登录");
//            return joinPoint.proceed();
//        }else{
//            Log.e(TAG, "检测到未登录！");
//            Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
//            context.startActivity(new Intent(context, LoginActivity.class));
//            return null;//不再执行方法（切入点）
//        }
//
//    }

    private final static String TAG = "netease >>> ";

    // 1、应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
    // execution，以方法执行时作为切点，触发Aspect类
    // * *(..)) 可以处理ClickBehavior这个类所有的方法
    @Pointcut("execution(@com.jiehun.veigar.aop.annotation.LoginCheck * *(..))")
    public void methodPointCut() {}

    // 2、对切入点如何处理
    @Around("methodPointCut()")
    public Object jointPotin(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getThis();
        if (false) { // 从SharedPreferences中读取
            Log.e(TAG, "检测到已登录！");
            return joinPoint.proceed();
        } else {
            Log.e(TAG, "检测到未登录！");
            Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return null; // 不再执行方法（切入点）
        }
    }
}
