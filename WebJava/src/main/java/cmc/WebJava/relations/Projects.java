package cmc.WebJava.relations;

import lombok.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Projects implements DefaultEntity<Long> {

    @Id
    @Column(nullable = false, name = "proj_id")
    private Long proj_id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "start_date")
    @NonNull
    private Date start_date;

    @Column(nullable = false, name = "end_date")
    @NonNull
    private Date end_date;

    @Column(nullable = false, name = "status")
    @NonNull
    private String status;
}