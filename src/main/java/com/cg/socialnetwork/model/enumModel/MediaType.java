package com.cg.socialnetwork.model.enumModel;

public enum MediaType {
    USER(1), POST(2);

    private final int value;

    MediaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static MediaType fromValue(int value) {
        MediaType[] status = values();
        for (MediaType c : status) {
            if (c.value == value) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid account status value: " + value);
    }
}

