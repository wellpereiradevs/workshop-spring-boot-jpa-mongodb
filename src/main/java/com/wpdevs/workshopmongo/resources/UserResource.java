package com.wpdevs.workshopmongo.resources;

import com.wpdevs.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User(1L,"Maria Brown", "mariabrown@gmail.com");
        User alex = new User(2L,"Alex Green", "alexgreen@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
