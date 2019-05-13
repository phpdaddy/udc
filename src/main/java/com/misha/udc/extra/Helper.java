package com.misha.udc.extra;

import com.misha.udc.model.jpa.Category;
import org.springframework.stereotype.Service;

@Service
public class Helper {

    public String getKeyWordsFromText(String text) {
        String excluded = "[ ,.](в|без|до|из|к|на|по|о|от|перед|при|через|с|у|нет|за|над|для|об|под|про|и)[ ,.]";
        return
                text
                        .replaceAll("=>", " ").trim()
                        .replaceAll("null", " ").trim()
                        .replaceAll(excluded, " ").trim()
                        .replaceAll("[,.]", " ").trim()
                        .replaceAll(" +", " ").trim()
                        .replaceAll("[ ]", ",");
    }

    public String getFullPath(Category c) {
        return (c.getParent() != null ? (this.getFullPath(c.getParent()) + " => ") : "") + c.getName();
    }


}
