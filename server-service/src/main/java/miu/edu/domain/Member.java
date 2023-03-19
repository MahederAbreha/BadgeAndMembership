package miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstname;
    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

    @OneToMany(mappedBy = "member")
    private List<Badge> badges = new ArrayList<>();
    @Embedded
    private Audit audit;
    @OneToMany
    @JoinTable(name = "member_roles",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleTypes = new ArrayList<>();

    public Member(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

}
