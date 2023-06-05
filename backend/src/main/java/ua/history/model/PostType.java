package ua.history.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PostType {
    @JsonProperty("Історія")
    HISTORY("Історія"),
    @JsonProperty("Видатні особистості")
    NOTABLE_PERSON("Видатні особистості"),
    @JsonProperty("Галерея")
    GALLERY("Галерея"),
    @JsonProperty("Символізм")
    SYMBOLISM("Символізм"),
    @JsonProperty("Фольклор")
    FOLKLORE("Фольклор"),
    @JsonProperty("Відеоматеріали")
    VIDEO_FOOTAGE("Відеоматеріали"),
    @JsonProperty("Аудіоматеріали")
    AUDIO_FOOTAGE("Аудіоматеріали");


    private final String name;

    PostType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
