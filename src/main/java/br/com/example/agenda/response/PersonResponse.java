package br.com.example.agenda.response;

import lombok.Data;

@Data

public class PersonResponse {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String zipCode;
}
