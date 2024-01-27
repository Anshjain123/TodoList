package webservices.restfulwebservices.Todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoservice;

    @GetMapping("/users/{username}/todos")
    public List<todo> getAllTodos(@PathVariable String username) {
        return todoservice.findAll();
    }


    @GetMapping("/users/{username}/todos/{id}")
    public todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoservice.findById(id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> DeleteTodo(@PathVariable String username, @PathVariable long id) {
        todo Todo = todoservice.DeleteById(id);
        if(Todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody todo Todo) {
        todo updatedTodo = todoservice.save(Todo);
        return new ResponseEntity<todo>(Todo, HttpStatus.OK);
    }

    @PostMapping ("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody todo Todo) {
        todo CreatedTodo = todoservice.save(Todo);
        // we need to send back the url on which our new resource is created


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CreatedTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
