package webservices.restfulwebservices.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




// will act as database for now
@Service
public class TodoHardcodedService {
    private static List<todo> todos = new ArrayList();
    private static int counterId = 0;

    static {
        todos.add(new todo(++counterId, "learn Spring", "in28minutes", new Date(), false));
        todos.add(new todo(++counterId, "Learn Angular","in28minutes", new Date(), false));
        todos.add(new todo(++counterId, "Learn microservices","in28minutes", new Date(), false));
    }

    public List<todo> findAll() {
        return todos;
    }

    public todo DeleteById(long id) {
        todo Todo = findById(id);
        if(Todo == null) {
            return null;
        }
        if(todos.remove(Todo)){
            return Todo;
        }
        return null;
    }

    public todo findById(long id) {
        for(todo Todo: todos) {
            if(Todo.getId() == id) {
                return Todo;
            }
        }
        return null;
    }

//
    public todo save(todo Todo) {
        if(Todo.getId() == -1 || Todo.getId() == 0) {
            Todo.setId(++counterId);
            todos.add(Todo);
        } else {
            DeleteById(Todo.getId());
            todos.add(Todo);
        }
        return Todo;
    }
}
