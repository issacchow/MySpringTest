package springboot.resolver;

import java.lang.annotation.*;

/**
 * @author suanjin
 * @create 2017-10-24 21:13
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJsonParamResolver {

}
