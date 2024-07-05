package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.pojo.Hospital;
import generator.service.HospitalService;
import generator.mapper.HospitalMapper;
import org.springframework.stereotype.Service;

/**
* @author liwenxuan
* @description 针对表【hospital】的数据库操作Service实现
* @createDate 2024-06-13 12:04:24
*/
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital>
    implements HospitalService{

}




