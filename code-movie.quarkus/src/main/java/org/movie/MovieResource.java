package org.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.movie.entity.Movie;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movies")
public class MovieResource {

	public static List<Movie> movies = new ArrayList<>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(movies).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/size")
	public Integer countMovie() {
		return movies.size();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovie(Movie newMovie) {
		movies.add(newMovie);
		return Response.ok(movies).build();
	}

	@PUT
	@Path("{id}/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMovie(@PathParam("id") Long id, @PathParam("name") String title) {
		movies = movies.stream().map(movie -> {
			if (movie.getId().equals(id)) {
				movie.setTitle(title);
			}
			return movie;
		}).collect(Collectors.toList());
		return Response.ok(movies).build();
	}

	@DELETE
	@Path("customerUpdate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMovie(@PathParam("id") String id) {
		Optional<Movie> movieDeleted = movies.stream().filter(cust -> cust.getId().equals(id)).findFirst();
		boolean removed = false;
		if (movieDeleted.isPresent()) {
			removed = movies.remove(movieDeleted.get());
		}
		if (removed) {
			return Response.noContent().build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

}

