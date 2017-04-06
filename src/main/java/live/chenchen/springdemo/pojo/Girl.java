package live.chenchen.springdemo.pojo;

public class Girl {
    private Integer id;

    private String name;

    private String comingtime;

    private Integer age;

    private Integer maxscore;

    private Integer minscore;

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
        this.name = name == null ? null : name.trim();
    }

    public String getComingtime() {
        return comingtime;
    }

    public void setComingtime(String comingtime) {
        this.comingtime = comingtime == null ? null : comingtime.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    public Integer getMinscore() {
        return minscore;
    }

    public void setMinscore(Integer minscore) {
        this.minscore = minscore;
    }
}