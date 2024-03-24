package cmc.WebJava.relations;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Payments_Policies")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentsPolicies implements DefaultEntity<Long> {

    @Id
    @Column(nullable = false, name = "policy_id")
    private Long id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "type")
    @NonNull
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proj_id")
    @ToString.Exclude
    @NonNull
    private Projects project;

    @Column(nullable = false, name = "periodicity")
    @NonNull
    private Long periodicity;

    @Column(nullable = false, name = "start_date")
    @NonNull
    private Date start_date;

    @Column(nullable = false, name = "end_date")
    @NonNull
    private Date end_date;

    @Column(nullable = false, name = "amount")
    @NonNull
    private Long amount;
}