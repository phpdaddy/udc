package com.phpdaddy.udc.extra;

import org.springframework.stereotype.Service;

@Service
public class Helper {

    public String getKeyWordsFromText(String fullPath) {
        String excluded = "[ ,.](в|без|до|из|к|на|по|о|от|перед|при|через|с|у|нет|за|над|для|об|под|про|и)[ ,.]";
        return
                fullPath
                        .replaceAll("=>", " ").trim()
                        .replaceAll("null", " ").trim()
                        .replaceAll(excluded, " ").trim()
                        .replaceAll("[,.]", " ").trim()
                        .replaceAll(" +", " ").trim()
                        .replaceAll("[ ]", ",");
    }

}
