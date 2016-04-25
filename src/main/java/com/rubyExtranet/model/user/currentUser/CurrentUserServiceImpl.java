//package com.rubyExtranet.model.user.currentUser;
//
//import org.springframework.stereotype.Service;
//
//import com.rubyExtranet.model.user.Role;
//
//@Service
//public class CurrentUserServiceImpl implements CurrentUserService {
//
//	@Override
//	public boolean canAccessUser(com.rubyExtranet.model.user.CurrentUser currentUser, Long userId) {
//		return currentUser != null
//                && (currentUser.getRole() == Role.ADMIN || currentUser.getId() == userId);
//	}
//
//}
