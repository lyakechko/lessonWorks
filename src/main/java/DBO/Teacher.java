package DBO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "review")
    private String review;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="courses_id", nullable=false)
    private Courses courses;

//    @ManyToOne(optional=false)
//@JoinColumn(name="customerId",referencedColumnName="id_customer")
//private Customer customer;

    @ManyToMany(mappedBy = "teacherSet")
    private Set<Student> students = new HashSet<>();

}
