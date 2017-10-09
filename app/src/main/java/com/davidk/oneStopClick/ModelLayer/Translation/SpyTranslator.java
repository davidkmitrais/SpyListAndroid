package com.davidk.oneStopClick.ModelLayer.Translation;

import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy;

import io.realm.Realm;

public interface SpyTranslator {
    SpyDTO translate(Spy from);
    Spy translate(SpyDTO dto, Realm realm);
}
