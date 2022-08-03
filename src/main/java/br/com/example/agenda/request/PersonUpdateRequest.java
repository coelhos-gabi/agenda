package br.com.example.agenda.request;

import lombok.Data;

@Data
public class PersonUpdateRequest {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String zipCode;
}
