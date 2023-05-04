package ua.history.model;

import jakarta.persistence.*;

@Table(name = "post_types")
public enum PostType {
    HISTORY("Історія"),
    NOTABLE_PERSON("Видатні особистості"),
    GALLERY("Галерея"),
    SYMBOLISM("Символізм"),
    FOLKLORE("Фольклор"),
    VIDEO_FOOTAGE("Відеоматеріали"),
    AUDIO_FOOTAGE("Аудіоматеріали");

    @Column(name = "name")
    private String name;

    PostType(String name) {
        this.name = name;
    }
}
