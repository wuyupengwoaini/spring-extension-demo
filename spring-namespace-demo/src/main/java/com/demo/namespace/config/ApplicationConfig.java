package com.demo.namespace.config;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/12/27 17:30
 **/
public class ApplicationConfig {

    private String id ;

    private String name;

    private String version;

    private String organization;

    private String owner;

    public ApplicationConfig(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", organization='" + organization + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
