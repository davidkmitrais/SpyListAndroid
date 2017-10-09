package com.davidk.oneStopClick.ModelLayer.Translation;

import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy;
import com.davidk.oneStopClick.ModelLayer.Enums.DTOType;

import java.util.List;

import io.realm.Realm;

public interface TranslationLayer {
    List<SpyDTO> convertJson(String json);

    SpyTranslator translatorFor(DTOType type);

    SpyDTO translate(Spy spy);

    Spy translate(SpyDTO dto, Realm realm);
}
