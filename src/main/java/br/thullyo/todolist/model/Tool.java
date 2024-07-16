package br.thullyo.todolist.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TB_TOOLS")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String link;

    private String description;

    private Set<String> tags;

    public Tool() {
    }

    public Tool(Integer id, String title, String link, String description, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
