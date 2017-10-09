package com.davidk.oneStopClick.Activities.SpyList;

import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.ModelLayer.Enums.Source;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public interface SpyListPresenter {
    void loadData(Consumer<Source> notifyDataReceived);

    void addNewSpy();

    BehaviorSubject<List<SpyDTO>> spies();
}
