package liu.yan.asm;

/**
 * @author liu yan
 * @description
 * @date 2018/12/21
 */
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE)
public @interface CheckGetter {
}

