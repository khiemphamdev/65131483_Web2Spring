package thigk2.PhamGiaKhiem.ThiGK.models;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING) 
    @Column(columnDefinition = "ENUM('admin', 'customer') DEFAULT 'customer'")
    private Role role = Role.customer;

    public enum Role {
        admin, customer
    }
}
