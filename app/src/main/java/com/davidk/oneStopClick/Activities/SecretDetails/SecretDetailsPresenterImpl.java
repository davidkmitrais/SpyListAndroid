package com.davidk.oneStopClick.Activities.SecretDetails;

import com.davidk.oneStopClick.Helpers.Threading;
import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.ModelLayer.ModelLayer;

import io.reactivex.functions.Consumer;

public class SecretDetailsPresenterImpl implements SecretDetailsPresenter {
    public String password;

    @Override
    public String getPassword() {
        return password;
    }

    private int spyId;
    private SpyDTO spy;
    private ModelLayer modelLayer;

    public SecretDetailsPresenterImpl(int spyId, ModelLayer modelLayer) {
        this.spyId = spyId;
        this.modelLayer = modelLayer;

        configureData();
    }

    private void configureData() {
        spy = this.modelLayer.spyForId(spyId);
        password = spy.password;
    }

    @Override
    public void crackPassword(Consumer<String> finished) {
        Threading.async(()-> {
            //fake processing work
            Thread.sleep(2000);
            return true;
        }, success -> {
            finished.accept(password);
        });
    }
}
