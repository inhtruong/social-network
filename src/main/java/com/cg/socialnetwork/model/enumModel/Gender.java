package com.cg.socialnetwork.model.enumModel;


public enum  Gender {
    M("Male"), F("Female");
    private final String value;

    Gender(String value) {
        this.value = value;
    }
//
    public String getValue() {
        return this.value;
    }
//
//    public static Gender fromValue(String value) {
//        Gender[] status = values();
//        for (Gender c : status) {
//            if (c.value.equalsIgnoreCase(value)) {
//                return c;
//            }
//        }
//        throw new IllegalArgumentException("Invalid account status value: " + value);
//    }
}
