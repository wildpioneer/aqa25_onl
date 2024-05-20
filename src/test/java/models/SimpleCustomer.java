package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleCustomer {
    int id;
    String firstname;
    String lastname;
    String email;
    int age;
}
