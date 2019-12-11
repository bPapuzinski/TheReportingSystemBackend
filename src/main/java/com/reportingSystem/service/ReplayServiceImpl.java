package com.reportingSystem.service;

import com.reportingSystem.dto.ReplayDto;
import com.reportingSystem.mapper.DefaultMapper;
import com.reportingSystem.model.ReplayModel;
import com.reportingSystem.model.ReportModel;
import com.reportingSystem.repository.ReplayRepository;
import com.reportingSystem.repository.ReportRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplayServiceImpl implements ReplayService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReplayRepository replayRepository;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public ReplayDto addReplayToReport(String id, ReplayDto replayDto) {
        ReportModel reportModel = reportRepository.findReportById(Integer.parseInt(id)).get();
        ReplayModel replayModel = replayRepository.save(mapper.map(replayDto,  ReplayModel.class));

        List<ReplayModel> replayList =  reportModel.getReplayList();
        replayList.add(replayModel);
        reportModel.setReplayList(replayList);
        reportRepository.save(reportModel);
        return mapper.map(replayModel, ReplayDto.class);
    }

    @Override
    public ReplayDto editReplay(String id, String replayId, ReplayDto replayDto) {
        return null;
    }
}
