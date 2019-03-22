package pl.schronisko.kontroler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;

//@Path("/rest/hello")
@Controller
@RequestMapping("/rest")
public class Hello {
	
	@RequestMapping(value="/hello/{imie}", method=RequestMethod.GET)
	public @ResponseBody String getmsg(@PathVariable String imie) {
		return "hello " + imie;
	}
	
/*	@GET
	@Path("/{param}") 
	
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 */
}
