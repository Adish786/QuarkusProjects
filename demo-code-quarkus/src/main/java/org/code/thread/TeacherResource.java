package org.code.thread;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import org.code.entity.Teacher;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("teacher")
public class TeacherResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Teacher> getTeacher() {
        System.out.println(Thread.currentThread().getName());
        Teacher teacher = new Teacher(1l,"Adish Ansari","Quarkus");
        return Uni.createFrom().item(teacher);
    }

  

    //Return Collection
    @GET
    @Path("list")
    public Uni<List<Teacher>> getTeachers() {
        System.out.println(Thread.currentThread().getName());
        List<Teacher> teacherList = List.of(
                new Teacher(1l, "Subramanian", "Quarkus"),
                new Teacher(2l, "Murugan", "Quarkus"),
                new Teacher(3l, "Karthik", "Spring Framework")
        );
        return Uni.createFrom().item(teacherList);
    }

}
