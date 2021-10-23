package com.cg.socialnetwork.model.enumModel;

public enum StatusFriend {
    W("Waiting"), F("Friend"), B("Block");
    private final String value;

    StatusFriend(String value) {
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
