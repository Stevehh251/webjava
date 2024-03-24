package cmc.WebJava.relations;

import lombok.*;

import jakarta.persistence.*;

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
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    @ToString.Exclude
    @NonNull
    private Employee employee;

    @Column(nullable = false, name = "role")
    @NonNull
    private String role;
}