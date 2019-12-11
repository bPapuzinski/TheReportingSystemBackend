package com.reportingSystem.service;

import com.reportingSystem.dto.ReplayDto;

public interface ReplayService {
    ReplayDto addReplayToReport(String id, ReplayDto replayDto);

    ReplayDto editReplay(String id, String replayId, ReplayDto replayDto);
}
