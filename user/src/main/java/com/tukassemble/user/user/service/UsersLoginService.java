package com.tukassemble.user.user.service;

import com.tukassemble.user.user.Users;
import com.tukassemble.user.user.UsersRole;
import com.tukassemble.user.user.dto.UserCreateRequest;
import com.tukassemble.user.user.dto.UserInfo;
import com.tukassemble.user.user.exception.NotFoundUserEntityException;
import com.tukassemble.user.user.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersLoginService {

  private final UsersRepository usersRepository;

  public Users findLoginUsersById(Long userId) {
    return usersRepository.findUsersById(userId).orElseThrow(NotFoundUserEntityException::new);
  }

  public UserInfo findOneUsersById(Long userId) {
    Users foundUsers =
        usersRepository.findUsersById(userId).orElseThrow(NotFoundUserEntityException::new);
    return mapUserToUserInfo(foundUsers);
  }

  public UserInfo registerUser(UserCreateRequest userCreateRequest) {
    Users newUsers =
        Users.builder().name(userCreateRequest.getName()).role(UsersRole.ROLE_USER).build();
    newUsers = usersRepository.save(newUsers);
    return mapUserToUserInfo(newUsers);
  }

  private static UserInfo mapUserToUserInfo(Users foundUsers) {
    return UserInfo.builder().name(foundUsers.getName()).role(foundUsers.getRole()).build();
  }
}
