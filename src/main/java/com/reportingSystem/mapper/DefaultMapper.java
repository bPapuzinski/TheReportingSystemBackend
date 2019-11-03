package com.reportingSystem.mapper;

import com.reportingSystem.dto.SimpleReportDto;
import com.reportingSystem.model.ReportModel;
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
    }
}
