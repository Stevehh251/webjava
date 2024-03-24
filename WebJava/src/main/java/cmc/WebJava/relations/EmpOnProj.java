package cmc.WebJava.relations;

import lombok.*;

@Entity
@Table(name = "emp_on_proj")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class EmpOnProj implements DefaultEntity<Long> {

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