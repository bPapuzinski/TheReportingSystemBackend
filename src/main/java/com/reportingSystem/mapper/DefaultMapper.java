package com.reportingSystem.mapper;

import com.reportingSystem.dto.SimpleReportDto;
import com.reportingSystem.dto.SimpleUserDto;
import com.reportingSystem.model.ReportModel;
import com.reportingSystem.model.UserModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(ReportModel.class, SimpleReportDto.class)
                .byDefault()
                .register();
        factory.classMap(UserModel.class, SimpleUserDto.class)
                .byDefault()
                .register();
    }
}
