package src.test.AopAnnotation;

import java.lang.annotation.*;

/**
 * @Author deng shuo
 * @Date 5/17/21 12:26
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {

    String name();                  //调用接口的名称
    boolean intoDB() default false; //日志写入数据库
}
