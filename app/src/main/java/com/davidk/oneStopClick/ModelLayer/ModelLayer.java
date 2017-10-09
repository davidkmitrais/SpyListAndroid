package com.davidk.oneStopClick.ModelLayer;

import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.ModelLayer.Enums.Source;

import java.util.List;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public interface ModelLayer {
    void loadData(Consumer<List<SpyDTO>> onNewResults, Consumer<Source> notifyDataReceived);

    SpyDTO spyForId(int spyId);

    SpyDTO spyForName(String name);

    void save(List<SpyDTO> dtos, Action finished);
}
