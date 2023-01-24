package com.tukassemble.user.user.dto;

import com.tukassemble.user.user.UsersRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String name;
    private UsersRole role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(name, userInfo.name) && role.name().equals(userInfo.role.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role.name());
    }
}
