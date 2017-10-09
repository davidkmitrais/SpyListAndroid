package com.davidk.oneStopClick.Dependencies;

import android.os.Bundle;

import com.google.gson.Gson;
import com.davidk.oneStopClick.Activities.Details.SpyDetailsActivity;
import com.davidk.oneStopClick.Activities.Details.SpyDetailsPresenter;
import com.davidk.oneStopClick.Activities.Details.SpyDetailsPresenterImpl;
import com.davidk.oneStopClick.Activities.SecretDetails.SecretDetailsActivity;
import com.davidk.oneStopClick.Activities.SecretDetails.SecretDetailsPresenter;
import com.davidk.oneStopClick.Activities.SecretDetails.SecretDetailsPresenterImpl;
import com.davidk.oneStopClick.Activities.SpyList.SpyListActivity;
import com.davidk.oneStopClick.Activities.SpyList.SpyListPresenter;
import com.davidk.oneStopClick.Activities.SpyList.SpyListPresenterImpl;
import com.davidk.oneStopClick.Coordinators.RootCoordinator;
import com.davidk.oneStopClick.Helpers.Constants;
import com.davidk.oneStopClick.ModelLayer.Database.DataLayer;
import com.davidk.oneStopClick.ModelLayer.Database.DataLayerImpl;
import com.davidk.oneStopClick.ModelLayer.ModelLayer;
import com.davidk.oneStopClick.ModelLayer.ModelLayerImpl;
import com.davidk.oneStopClick.ModelLayer.Network.NetworkLayer;
import com.davidk.oneStopClick.ModelLayer.Network.NetworkLayerImpl;
import com.davidk.oneStopClick.ModelLayer.Translation.SpyTranslator;
import com.davidk.oneStopClick.ModelLayer.Translation.SpyTranslatorImpl;
import com.davidk.oneStopClick.ModelLayer.Translation.TranslationLayer;
import com.davidk.oneStopClick.ModelLayer.Translation.TranslationLayerImpl;

import java.util.NoSuchElementException;

import io.realm.Realm;

public class DependencyRegistry {
    public static  DependencyRegistry shared = new DependencyRegistry();

    //region External Dependencies

    private Gson gson = new Gson();

    private Realm realm = Realm.getDefaultInstance();
    public Realm newRealmInstanceOnCurrentThread() {
        return Realm.getInstance(realm.getConfiguration());
    }

    //endregion

    //region Coordinators

    public RootCoordinator rootCoordinator = new RootCoordinator();

    //endregion

    //region Singletons

    public SpyTranslator spyTranslator = new SpyTranslatorImpl();

    public TranslationLayer translationLayer = createTranslationLayer();
    private TranslationLayer createTranslationLayer() {
        return new TranslationLayerImpl(gson, spyTranslator);
    }

    public DataLayer dataLayer = createDataLayer();
    private DataLayer createDataLayer() {
        return new DataLayerImpl(realm, this::newRealmInstanceOnCurrentThread);
    }

    public NetworkLayer networkLayer = new NetworkLayerImpl();

    public ModelLayer modelLayer = createModelLayer();

    private ModelLayer createModelLayer() {
        return new ModelLayerImpl(networkLayer, dataLayer, translationLayer);
    }

    //endregion

    //region Injection Methods

    public void inject(SpyDetailsActivity activity, Bundle bundle) throws NoSuchElementException {
        int spyId = idFromBundle(bundle);

        SpyDetailsPresenter presenter = new SpyDetailsPresenterImpl(spyId, activity, modelLayer);
        activity.configureWith(presenter, rootCoordinator);
    }

    public void inject(SecretDetailsActivity activity, Bundle bundle) throws NoSuchElementException {
        int spyId = idFromBundle(bundle);

        SecretDetailsPresenter presenter = new SecretDetailsPresenterImpl(spyId, modelLayer);
        activity.configureWith(presenter, rootCoordinator);
    }

    public void inject(SpyListActivity activity) {
        SpyListPresenter presenter = new SpyListPresenterImpl(modelLayer);
        activity.configureWith(presenter, rootCoordinator);
    }

    //endregion

    //region Helper Methods

    private int idFromBundle(Bundle bundle) {
        if(bundle == null) throw new NoSuchElementException("Unable to get spy id from bundle");

        int spyId = bundle.getInt(Constants.spyIdKey);
        if(spyId == 0) throw new NoSuchElementException("Unable to get spy id from bundle");
        return spyId;
    }

    //endregion

}
