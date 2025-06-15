package com.example.jwt.Dto;

import com.example.jwt.model.EnumRole;

public record RegisterDto (String login, String password, EnumRole role){
}
