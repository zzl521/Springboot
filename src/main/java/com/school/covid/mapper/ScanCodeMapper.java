package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.QrCode.ScanCode;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanCodeMapper extends BaseMapper<ScanCode> {

}
