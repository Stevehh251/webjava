package cmc.WebJava.relations;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "payments_history")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentsHistory implements DefaultEntity<Long> {

    @Id
    @Column(nullable = false, name = "pay_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    @ToString.Exclude
    @NonNull
    private Employees employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policy_id")
    @ToString.Exclude
    @NonNull
    private PaymentsPolicies policy;

    @Column(nullable = false, name = "pay_date")
    @NonNull
    private Date pay_date;

    @Column(nullable = false, name = "amount")
    @NonNull
    private Long amount;
}