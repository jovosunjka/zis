package com.svj.zis.service;


import com.svj.zis.model.User;

public interface UserService {

    User getLoggedUser() throws Exception;
}
