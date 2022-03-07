package com.company.storyboard.controller;

import com.company.storyboard.model.Board;
import com.company.storyboard.repository.BoardRepository;
import com.company.storyboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BoardRESTController {


    @Autowired
    private BoardService boardService;



    //@PostMapping("/create")
    //public ResponseEntity<Board> create(@RequestBody Board board) {
    //    System.out.println(board);
    //    boardRepository.save(board);
    //    return new ResponseEntity<>(HttpStatus.OK);
    //}

    @GetMapping("/board/{id}")
    public ResponseEntity<Board> get(@PathVariable long id) {
        Board board = boardService.getBoardById(id);
        if (board != null) {
            return new ResponseEntity<>(board, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
