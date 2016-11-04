package com.qinyadan.brick.log;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Log {

    /** 要执行的具体操作比如：【添加商品】 **/
    public String actionName() default "";
}
