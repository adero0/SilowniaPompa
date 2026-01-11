package com.AbAmAk.Pompa.service;

import com.AbAmAk.Pompa.entity.AppUser;

public interface AppUserService {

    AppUser findUserByUsername(String username);

    boolean saveUser(AppUser user);
}
