package com.cg.socialnetwork.model.enumModel;

public enum Type {
    IMAGE("Image"), VIDEO("Video");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

//    public static Type fromValue(String value) {
//        Type[] status = values();
//        for (Type c : status) {
//            if (c.value.equalsIgnoreCase(value)) {
//                return c;
//            }
//        }
//        throw new IllegalArgumentException("Invalid account status value: " + value);
//    }
}
