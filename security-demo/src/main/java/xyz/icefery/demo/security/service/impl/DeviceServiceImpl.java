package xyz.icefery.demo.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.icefery.demo.security.entity.Device;
import xyz.icefery.demo.security.mapper.DeviceMapper;
import xyz.icefery.demo.security.service.DeviceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author icefery
 * @since 2021-10-14
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

}
