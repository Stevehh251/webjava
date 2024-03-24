package cmc.WebJava.relations;

import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emp_on_proj")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class EmpOnProj implements DefaultEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proj_id")
    @ToString.Exclude
    @NonNull
    private Projects project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    @ToString.Exclude
    @NonNull
    private Employees employee;

    @Column(nullable = false, name = "role")
    @NonNull
    private String role;
}