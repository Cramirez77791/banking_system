package com.co.tita.payments.core.reports;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserReport implements Serializable {

    private Long id;

    private String userName;

    private String passWord;

    private boolean isActive;

    private String fullName;

}
