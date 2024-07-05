package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.pojo.Doctor;
import generator.service.DoctorService;
import generator.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
* @author liwenxuan
* @description 针对表【doctor】的数据库操作Service实现
* @createDate 2024-06-13 12:04:24
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

}




