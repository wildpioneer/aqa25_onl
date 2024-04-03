package tests;

import lombok.val;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LombokTest {

    @Test
    public void simpleTest() {
        Project project = new Project();
        project.setId(10);
        project.setName("Test");
        project.setProjectType(3);

        System.out.println(project);
    }

    @Test
    public void equalsAndHashCodeTest() {
        Project project1 = new Project();
        project1.setId(10);
        project1.setName("Test");
        project1.setProjectType(3);

        Project project2 = new Project();
        project2.setId(11);
        project2.setName("Test");
        project2.setProjectType(3);

        Assert.assertTrue(project1.equals(project2));
    }

    @Test
    public void builderTest() {
        ProjectBuilder project1 = ProjectBuilder
                .builder()
                .id(10)
                .name("Test")
                .projectType(3)
                .build();

        ProjectBuilder project2 = ProjectBuilder
                .builder()
                .id(11)
                .name("Test")
                .projectType(3)
                .build();

        System.out.println(project1.toString());
        Assert.assertTrue(project1.equals(project2));
    }

    @Test
    public void valTest() {
        val list = new ArrayList<String>(); // Transfer to final variable
        list.add("Test Value");

        System.out.println(list.get(0));
    }

    @Test
    public void varTest() {
        var list = new ArrayList<String>(); // Transfer to not final variable
        list.add("Test Value");

        System.out.println(list.get(0));
    }

}
