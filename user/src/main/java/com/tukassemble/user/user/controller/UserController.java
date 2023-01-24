package com.tukassemble.user.user.controller;

import com.tukassemble.user.user.dto.UserCreateRequest;
import com.tukassemble.user.user.dto.UserInfo;
import com.tukassemble.user.user.service.UsersLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UsersLoginService usersLoginService;

  @PostMapping("/api/v1/users")
  public ResponseEntity<UserInfo> registerUsers(@RequestBody UserCreateRequest request) {
    UserInfo userInfo = usersLoginService.registerUser(request);
    return ResponseEntity.ok(userInfo);
  }

  @GetMapping("/api/v1/users/{id}")
  public ResponseEntity<UserInfo> getUsers(@PathVariable Long id) {
    UserInfo userInfo = usersLoginService.findOneUsersById(id);
    return ResponseEntity.ok(userInfo);
  }
}
