package ua.history.model;

public enum PostType {
    HISTORY("Історія"),
    NOTABLE_PERSON("Видатні особистості"),
    GALLERY("Галерея"),
    SYMBOLISM("Символізм"),
    FOLKLORE("Фольклор"),
    VIDEO_FOOTAGE("Відеоматеріали"),
    AUDIO_FOOTAGE("Аудіоматеріали");


    private final String name;

    PostType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
