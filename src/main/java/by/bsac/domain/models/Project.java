package by.bsac.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "project")
@Getter @Setter
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;

    private String project_title;

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_title='" + project_title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return project_id.equals(project.project_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id);
    }
}
