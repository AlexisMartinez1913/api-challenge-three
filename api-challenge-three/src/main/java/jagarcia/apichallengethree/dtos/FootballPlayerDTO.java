package jagarcia.apichallengethree.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
public class FootballPlayerDTO {

    private Integer id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private String team;

    public FootballPlayerDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
