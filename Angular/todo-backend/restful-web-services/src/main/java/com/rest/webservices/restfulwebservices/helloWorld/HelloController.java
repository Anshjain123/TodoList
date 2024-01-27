package webservices.restfulwebservices.helloWorld;


import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloController {



//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")

//                    OR

    @GetMapping(path = "/hello-world")
    public String HelloWord() {
        return "Hello Ansh Jain";
    }


    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWordbean() {
        return new HelloWorldBean("Hello Ansh Jain Bean");
    }


    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean HelloWordbeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s Bean with path", name));
    }
}
