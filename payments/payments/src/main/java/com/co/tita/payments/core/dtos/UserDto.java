package com.co.tita.payments.core.dtos;


import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String userName;
    private String passWord;
    private boolean isActive;
}
