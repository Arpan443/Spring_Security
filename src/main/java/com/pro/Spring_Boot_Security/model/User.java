package com.pro.Spring_Boot_Security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    String name;
    String password;
    String email;

}
