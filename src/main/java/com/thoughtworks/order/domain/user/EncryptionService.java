package com.thoughtworks.order.domain.user;

public interface EncryptionService {
    String encrypt(String password);
    boolean check(String checkPassword, String realPassword);
}
