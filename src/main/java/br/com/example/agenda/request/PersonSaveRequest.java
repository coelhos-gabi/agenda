package br.com.example.agenda.request;

import lombok.Data;

@Data
public class PersonSaveRequest {

    private String name;
    private String phone;
    private String email;
    private String address;
    private String zipCode;
}
