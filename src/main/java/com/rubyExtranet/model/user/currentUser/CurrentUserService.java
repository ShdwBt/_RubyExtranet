package com.rubyExtranet.model.user.currentUser;

import com.rubyExtranet.model.user.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
