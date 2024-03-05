package com.example.b3tempoapp2324;

public enum TempoColor {
    RED(R.color.tempo_red_day_bg, R.string.tempo_red_color_text),
    WHITE(R.color.tempo_white_day_bg, R.string.tempo_white_color_text),
    BLUE(R.color.tempo_blue_day_bg, R.string.tempo_blue_color_text),
    UNKNOWN(R.color.tempo_undecided_day_bg, R.string.tempo_undecided_color_text);

    private final int colorResId;
    private final int stringResId;

    // Ctor
    TempoColor(int colorResId, int stringResId) {
        this.colorResId = colorResId;
        this.stringResId = stringResId;
    }

    public int getColorResId() {
        return colorResId;
    }

    public int getStringResId() {
        return stringResId;
    }
}
