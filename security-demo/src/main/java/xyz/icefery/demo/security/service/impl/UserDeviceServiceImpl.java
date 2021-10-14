package xyz.icefery.demo.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.icefery.demo.security.entity.UserDevice;
import xyz.icefery.demo.security.mapper.UserDeviceMapper;
import xyz.icefery.demo.security.service.UserDeviceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author icefery
 * @since 2021-10-14
 */
@Service
public class UserDeviceServiceImpl extends ServiceImpl<UserDeviceMapper, UserDevice> implements UserDeviceService {

}
