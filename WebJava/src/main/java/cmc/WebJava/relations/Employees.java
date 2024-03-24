package cmc.WebJava.relations;

import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Employees implements DefaultEntity<Long> {

    @Id
    @Column(nullable = false, name = "emp_id")
    private Long emp_id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "bdate")
    @NonNull
    private Date bdate;

    @Column(nullable = false, name = "phone_number")
    @NonNull
    private String phone_number;

    @Column(nullable = false, name = "email")
    @NonNull
    private String email;

    @Column(nullable = false, name = "emp_date")
    @NonNull
    private Date emp_date;
}