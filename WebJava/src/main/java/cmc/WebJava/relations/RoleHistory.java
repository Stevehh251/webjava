package cmc.WebJava.relations;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "role_history")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class RoleHistory implements DefaultEntity<Long> {

    @Id
    @Column(nullable = false, name = "record_id")
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

    @Column(nullable = false, name = "rec_date")
    @NonNull
    private Date rec_date;

    @Column(nullable = false, name = "new_role")
    @NonNull
    private String new_role;
}