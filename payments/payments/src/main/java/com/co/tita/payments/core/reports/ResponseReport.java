package com.co.tita.payments.core.reports;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseReport<T> {

    private T entity;
    private String message;

}
