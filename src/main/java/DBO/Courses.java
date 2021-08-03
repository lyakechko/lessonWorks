package DBO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "task")
    private String task;

    @ManyToMany(mappedBy = "coursesSet")
    private Set<Student> employees = new HashSet<>();

    @OneToMany(mappedBy="courses")
    private Set<Teacher> teachers;
}
