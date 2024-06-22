package net.codejava;
 
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// The @Path annotation defines the relative URL that forms the URI that identifies a resource. 
// You can use this annotation on both class level or method level.
@Path("/bonjour")
public class HelloResource {
 
    @GET  // The @GET annotation specifies that the annotated method, direBonjour() handles HTTP GET request. 
    // Jersey provides annotations corresponding to HTTP methods: @POST, @PUT, @DELETE…
    @Produces(MediaType.TEXT_PLAIN)  // The @Produces annotation specifies the content type of the response, 
    // which is text plain in our code. You can also specify text/xml, text/html, JSON, etc.
    public String direBonjour() {
        // And you can see the method direBonjour() returns a plain text, 
        return "Bonjour, tout le monde!";  // saying hello world in French – as response to the clients.
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
		return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<html><title>Hello</title><body><h1>Bonjour, tout le monde!</h1><body></html>";
	}
}