package com.tukassemble.user.user.controller;

import com.tukassemble.user.user.dto.UserCreateRequest;
import com.tukassemble.user.user.dto.UserInfo;
import com.tukassemble.user.user.service.UsersLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UsersLoginService usersLoginService;

  @PostMapping
  public ResponseEntity<UserInfo> registerUsers(@RequestBody UserCreateRequest request) {
    UserInfo userInfo = usersLoginService.registerUser(request);
    return ResponseEntity.ok(userInfo);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserInfo> getUsers(@PathVariable Long id) {
    UserInfo userInfo = usersLoginService.findOneUsersById(id);
    return ResponseEntity.ok(userInfo);
  }
}
