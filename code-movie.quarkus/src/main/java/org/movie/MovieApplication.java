package org.movie;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        info = @Info(
                title = "movie APIs",
                description = "Movie Application",
                version = "1.0.0",
                license = @License(
                        name = "AKG",
                        url="http://localhost:8080"
                )
        ),
        tags = {
                @Tag(name = "Movies",description = "Movies")
        }
)
public class MovieApplication extends Application {


}
