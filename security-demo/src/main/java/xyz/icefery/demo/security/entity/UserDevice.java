package xyz.icefery.demo.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author icefery
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_device")
public class UserDevice implements Serializable {

    private static final long serialVersionUID=1L;

    private Long userId;

    private Long deviceId;


}
