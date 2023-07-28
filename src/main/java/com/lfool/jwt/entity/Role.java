package com.lfool.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;
    private Integer userId;
    // 1 -> root
    // 2 -> manager
    // 3 -> user
    private Integer role;
}